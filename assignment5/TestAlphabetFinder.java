import static org.junit.Assert.assertTrue;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class TestAlphabetFinder {
	public AlphabetFinder finder;
	public String [] dictionary;
	
	@Before
	public void setUp(){
		finder = new AlphabetFinder();
		dictionary = new String [4];
		dictionary [0] = "ART";
		dictionary [1] = "RAT";
		dictionary [2] = "CAT";
		dictionary [3] = "CAR";
	}
	
	@Test
	public void testExample() {
		char [] expectedAlphabet= {'T', 'A', 'R', 'C'};
		char [] actualAlphabet = finder.findAlphabet(dictionary);
		assertTrue(Arrays.equals(expectedAlphabet, actualAlphabet));
	}
}
