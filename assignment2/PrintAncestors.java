public class PrintAncestors {
	/**
	* This method is used to print the ancestors of a node with a given key in a tree starting from the lowest one.
	* @param tree This is the tree.
	* @param key This is the key that is being searched for.
	* @return boolean This is true if the key is found in the tree and false otherwise.
	*/
	public static <T> boolean ancestors(Tree<T> tree, T key) {
		if (tree == null) {
			return false;
		} else if (tree.key == key) {
			return true;
			// search recursively for the key in the left and right subtrees
		} else if (ancestors(tree.leftChild, key) || ancestors(tree.rightChild, key)) {
			// if the key is found in either subtrees, print the current's node key
			System.out.println(tree.key);
			return true;
		}
		return false;
	}
}
