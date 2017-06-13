import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import javax.print.attribute.Size2DSyntax;


public class WordSearch {

/**
* Searches for valid words starting from each cell on the grid
*/
public static HashSet<String> wordsInGrid(int rows, int cols, char [] [] grid, Dictionary dictionary){
	
	HashSet<String> validWords = new HashSet<String>();
	for (int i = 0; i < rows; i++) {
		for (int j = 0; j < cols; j++) {
			/** the array keeps track of visited cells when starting from each cell */
			boolean [] [] visitedFromCell = new boolean [rows] [cols];
			/** stores valid words starting from each cell */
			HashSet<String> wordsFromCell = searchFromCell(i, j,"", grid,visitedFromCell, dictionary, rows, cols);
				if (!wordsFromCell.isEmpty()){
					validWords.addAll(wordsFromCell);	
				}
		}
	}
	return validWords;
}

public static HashSet<String> searchFromCell(int i, int j, String word, char [] [] grid, boolean [] [] visited,
											 Dictionary dictionary, int rows, int cols) {
	/** store valid words */
	HashSet<String> wordsFromCell = new HashSet<String>();
	
	/** add the current letter to the prefix */
	String temp = word + grid [i] [j];
	visited [i] [j] = true;
	
	/**if temp is a valid word add it to the set of words*/
	if (dictionary.isWord(temp)) {
		wordsFromCell.add(temp);
	
	/** if temp is a valid prefix iterate in all 8 possible directions starting from current cell */	
	}if (dictionary.isPrefix(temp)) {
		for (int k = i-1; k < i+2 && k<rows; k++) {
			for (int q = j-1; q < j+2 && q<cols; q++) {
				/** if the cell fits in the grid and hasn't been visited yet call searchFromCell recursively*/
				if (q>-1 && k>-1 && !visited [k] [q] ) {
					wordsFromCell.addAll(searchFromCell(k, q, temp, grid, visited, dictionary, rows, cols));
					/** restore the cell as unvisited */
					visited [k] [q] = false;
				}	
			}
		}
	}
		return wordsFromCell;
}
}
