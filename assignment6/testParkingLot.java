import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import org.junit.Test;

public class testParkingLot {
	
	@Test
	public void testExampleParkingLot() {
		int [] [] expected = new int [5] [];
		expected [0] = new int [] {0,2,1,3};
		expected [1] = new int [] {3,2,1,0};
		expected [2] = new int [] {3,0,1,2};
		expected [3] = new int [] {3,1,0,2};
		expected [4] = new int [] {3,1,2,0};
		String ExpectedString = Arrays.toString(expected[0]) + "\n" +  
                            Arrays.toString(expected[1]) + "\n" +  
                            Arrays.toString(expected[2]) + "\n" + 
                            Arrays.toString(expected[3]) + "\n" +  
                            Arrays.toString(expected[4]) + "\n";

		ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
	  System.setOut(new PrintStream(actualOutput));
		int [] initialArrangement = new int [] {1, 2, 0, 3};
		int [] targetArrangement = new int [] {3, 1, 2, 0};
	  ParkingLot.rearrange(initialArrangement, targetArrangement);
    
		assertEquals(ExpectedString, actualOutput.toString());
	}
}
