import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

public class AlphabetFinder{
	
	public class Graph {
		private int numVert;
		private LinkedList<Integer> [] adjList;
		
		public Graph(int numVert){
			this.numVert = numVert;
			adjList = new LinkedList [numVert];
			for (int i = 0; i < numVert; i++) {
				adjList[i] = new LinkedList<Integer>();
			}
		}	

		/**
		* This method is used to add a directed edge in a graph.
		* @param vertexA this is the tail of the arrow between the two vertices.
		* @param vertexB This is the head of the arrow between the two vertices.
		*/	
		public void addEdge(int vertexA, int vertexB){
			adjList[vertexA].add(vertexB);
		}
	
		/**
		* This method performs topological sorting on a graph.
		* @param graph This is the graph.
		* @return Stack<Integer> This is a stack of integers representing the sorted vertices of the graph.	
		*/
		public Stack<Integer> topSort(Graph graph){
		
			boolean [] visited = new boolean [graph.numVert];
			Stack<Integer> stack = new Stack<Integer>();
			
			for (int i = 0; i < graph.numVert; i++) {
				if (visited[i] == false) {
					topSortHelper(graph, i, visited, stack);
				}
			}
			return stack;
		}
	
		/*
		* This method is used to do topological sorting starting from a vertex.
		* @param graph This is the graph.
		* @param vertex This is the starting vertex.
		* @param visited This is the array of already visited vertices. 
		*/
		private void topSortHelper(Graph g, int vertex, boolean[] visited, Stack<Integer> stack) {
			
			visited [vertex] = true;
	
			for (Integer neighbour : g.adjList[vertex] ) {
				if (!visited[neighbour]) { 
					topSortHelper(g, neighbour, visited, stack);
				}
			}
			stack.push(vertex);
		}
	}
	
	/**
	* This method sorts the characters of an alphabet represented by the words in a dictionary in a lexicographical order. 
	* @param dictionary This is the dictionary of words.
	* @return char [] This is the sorted array of the characters in the alphabet.
	*/
	public char [] findAlphabet(String [] dictionary){
		
		// find the number of characters in the alphabet
		String allCharsString = "";
		HashSet<Character> uniqueCharacters = new HashSet<Character>();
		for (int i = 0; i < dictionary.length; i++) {
			allCharsString+= dictionary[i];
		}
		
		char[] allChars = allCharsString.toCharArray();
		for (int i = 0; i < allChars.length; i++) {
			uniqueCharacters.add(allChars[i]);
		}

		int alphabetSize = uniqueCharacters.size();
		// convert the set to a list
		ArrayList<Character> uniqueCharsList = new ArrayList<Character>();
			
		// map each character from the alphabet to a number in an arraylist
		for (Character c:uniqueCharacters) {
			uniqueCharsList.add(c);
		}
		// create a graph with the necessary number of edges
		Graph graph = new Graph(alphabetSize);
		
		// compare each pair of two adjacent strings in the array
		for (int i = 0; i < dictionary.length-1; i++) {
			// find the first mismatching character in each pair
			ArrayList<Character> edge= findFirstDifference(dictionary[i], dictionary[i+1]);
			// get the numbers that the two characters have been mapped to and add them an edge in the graph
			if (edge!=null) {
				int vertexA = uniqueCharsList.indexOf(edge.get(0));
				int vertexB = uniqueCharsList.indexOf(edge.get(1));
				graph.addEdge(vertexA, vertexB);
			}
		}
		
		// get the topological sorting of the graph
		Stack<Integer> alphabetStack = graph.topSort(graph);
		char [] alphabet = new char [alphabetSize];
		for (int j = 0; j < alphabetSize; j++) {
			alphabet [j] = uniqueCharsList.get(alphabetStack.pop());
		}
		return alphabet;
	}

	/**
	* This method finds the first mismatching character between two strings.
	* @param string1 This is the first string.
	* @param string2 This is the second string.
	* @return ArrayList<Character> This is a list of the first pair of mismatching characters.	
	*/
	private ArrayList<Character> findFirstDifference(String string1,String string2) {
		ArrayList<Character> mismatching = new ArrayList<Character>();
		int length = string1.length()>string2.length()?string2.length():string1.length();
		for (int i = 0; i < length; i++) {
			if (string1.charAt(i)!=string2.charAt(i)) {
				mismatching.add(string1.charAt(i));
				mismatching.add(string2.charAt(i));
				return mismatching;
			}
		}
		return null;
	}	
}
