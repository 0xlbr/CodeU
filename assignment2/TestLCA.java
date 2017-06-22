import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestLCA {

	public Tree<Integer> root;
	public Tree<Integer> t1;
	public Tree<Integer> t2;
	public Tree<Integer> t3;
	public Tree<Integer> t4;
	public Tree<Integer> t5;
	public Tree<Integer> t6;

	@Before
	public void setUp(){
		t6 = new Tree<Integer> (6, null, null);
		t5 = new Tree<Integer> (5, null, null);
		t4 = new Tree<Integer> (4, null, null);
	  	t3  = new Tree<Integer> (3, null, null);
	  	t1  = new Tree<Integer> (1, t3, t4);
		t2 = new Tree<Integer> (2, t5, t6);
		root = new Tree<Integer> (0, t1, t2);
	}

	@Test
	public void testNullTree() {
		assertEquals(null, LCA.findLCA(null, t3, t5));
	}

	@Test
	public void testRootLCA() {
		assertEquals(root, LCA.findLCA(root, root, t1));
		assertEquals(root, LCA.findLCA(root, root, t4));
	}

	@Test
	public void testLeftChildParentLCA() {
		assertEquals(t1, LCA.findLCA(root, t1, t3));
	}

	@Test
	public void testRightChildParentLCA() {
		assertEquals(t1, LCA.findLCA(root, t1, t4));
	}

	@Test
	public void testSameLevelNodesLCA() {
		assertEquals(root, LCA.findLCA(root, t3, t5));
	}

	@Test
	public void testsSiblingsLCA() {
		assertEquals(t2, LCA.findLCA(root, t5, t6));
	}

	@Test
	public void testDifferentLevelNodesLCA() {
		assertEquals(root, LCA.findLCA(root, t3, t2));
	}
}
