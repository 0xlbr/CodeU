public class Islands {
	/**
	* This method is used to find the number of islands in a matrix.
	* @param m This is the number of rows of the matrix.
	* @param n This is the number of columns of the matrix.
	* @param map This is the matrix.
	* @return int This is the number of islands.
	*/
	public static int islands(int m, int n, boolean [] [] map) {
		int islands = 0;
		// go through each cell of the matrix and perform DFS from there if you find a land (cell with  value true)
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (map [i] [j] == true) {
					islands+=DFS(i, j, map);
				}
			}
		}
		return islands;
	}
	
	/**
	* This method is used to perform DFS starting from a particular cell of a matrix.
	* @param i This is the starting row index.
	* @param j This is the starting column index.
	* @param map This is the matrix.
	* @return int It is always 1. 
	*/
	private static int DFS(int i, int j, boolean[][] map) {
		// if you find land in a valid cell of the map, set it to false and call DFS for all adjacent cells.
		if (i>=0 && j>=0 && i<map.length && j<map[0].length && map [i] [j] == true) {
			map [i] [j] = false;
			DFS(i-1, j, map);
			DFS(i, j-1, map);
			DFS(i+1, j, map);
			DFS(i, j+1, map);
		}
		return 1;
	}
}
