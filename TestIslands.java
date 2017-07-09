public class TestIslands {
	public boolean  [] [] map;
	public boolean [] [] ocean;
	
	@Before
	public void setUp(){
		map = new boolean [4] [];
		ocean = new boolean [2] [];
		map [0] = new boolean [] {false, true, false, true};
		map [1] = new boolean [] {true, true, false, false};
		map [2] = new boolean [] {false, false, true, false};
		map [3] = new boolean [] {false, false, true, false};
		ocean [0] = new boolean [] {false, false}; 
		ocean [1] = new boolean [] {false, false};
	}
	
	@Test
	public void testExample() {
		assertEquals(3, Islands.islands(4, 4, map));
	}
	
	@Test
	public void testOneRow() {
		assertEquals(2, Islands.islands(1, 4, map));
	}
	
	@Test
	public void testOneColumn() {
		assertEquals(1, Islands.islands(4, 1, map));
	}
	
	@Test
	public void testEmpty() {
		assertEquals(0, Islands.islands(2, 2, ocean));
	}
}
