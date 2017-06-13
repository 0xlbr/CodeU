import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.regex.Matcher;

import org.junit.Before;
import org.junit.Test;


public class TestWordSearch {
	public Dictionary d;
	public char [] [] grid;
	
	@Before
	public void setUp(){
		ArrayList<String> wordList  = new ArrayList<String>();
		wordList.add("car");
		wordList.add("card");
		wordList.add("cat");
		wordList.add("cart");
		d = new Dictionary(wordList);
		char [] firstRow= {'a', 'a', 'r'};
		char [] secondRow= {'t', 'c', 'd'};
		grid = new char [2] [];
		grid [0] = firstRow;
		grid [1] = secondRow;
	}
	
	@Test
	public void testExample() {
		HashSet<String> validWords = WordSearch.wordsInGrid(2, 3, grid, d);
		LinkedHashSet<String> orderedWords = new LinkedHashSet<String>(validWords);
		LinkedHashSet<String> expectedWords = new LinkedHashSet<String>();
		expectedWords.add("cat");
		expectedWords.add("car");
		expectedWords.add("card");
		assertEquals(orderedWords, expectedWords);
	}
}
