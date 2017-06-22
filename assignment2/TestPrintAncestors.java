import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Before;
import org.junit.Test;

public class TestPrintAncestors {
	
	public Tree<Integer> root;
	
	@Before
	public void setUp(){
		Tree<Integer> t6 = new Tree<Integer> (6, null, null);
		Tree<Integer> t5 = new Tree<Integer> (5, null, null);
		Tree<Integer> t4 = new Tree<Integer> (4, null, null);
		Tree<Integer> t3  = new Tree<Integer> (3, null, null);
		Tree<Integer> t1  = new Tree<Integer> (1, t3, t4);
		Tree<Integer> t2 = new Tree<Integer> (2, t5, t6);
		root = new Tree<Integer> (0, t1, t2);
	}

	@Test
	public void testNullTree() {
		assertEquals(PrintAncestors.ancestors(null, 5), false);
	}
	
	@Test
	public void testNonExistentKey() {
		assertEquals(PrintAncestors.ancestors(root, 8), false);
	}
	
	@Test
	public void testKeyAtRoot() {
		ByteArrayOutputStream expectedOutput = new ByteArrayOutputStream();
		System.setOut(new PrintStream(expectedOutput));
		assertEquals(PrintAncestors.ancestors(root, 0), true);
		assertEquals(expectedOutput.toString(), "");
	}
	
	@Test
	public void testNearLeavesLeft() {
		ByteArrayOutputStream expectedOutput = new ByteArrayOutputStream();
		System.setOut(new PrintStream(expectedOutput));
		assertEquals(PrintAncestors.ancestors(root, 3), true);
		assertEquals(expectedOutput.toString(), "1" + "\n" + "0" + "\n");
	}
	
	@Test
	public void testNearLeavesRight() {
		ByteArrayOutputStream expectedOutput = new ByteArrayOutputStream();
		System.setOut(new PrintStream(expectedOutput));
		assertEquals(PrintAncestors.ancestors(root, 5), true);
		assertEquals(expectedOutput.toString(), "2" + "\n" + "0" + "\n");
	}
	
	@Test
	public void testInternalNodes() {
		ByteArrayOutputStream expectedOutput = new ByteArrayOutputStream();
		System.setOut(new PrintStream(expectedOutput));
		assertEquals(PrintAncestors.ancestors(root, 2), true);
		assertEquals(expectedOutput.toString(),  "0" + "\n");
	}
}
