public class LCA {
	/**
	* This method is used to find the lowest common ancestor(LSA) of two nodes of a tree
	* @param root This is the root of the tree.
	* @param nodeA This is the first node of the given tree.
	* @param nodeB This is the second node of the given tree.
	* @return Tree<T> This is the node which is the lowest common ancestor of nodeA and nodeB.
	*/
	public static <T> Tree<T> findLCA(Tree<T> root, Tree<T> nodeA, Tree<T> nodeB){
		
		if(root == null || root == nodeA || root == nodeB) {
        	return root;
        	}
	  
        	Tree<T> leftBranch = findLCA(root.leftChild , nodeA, nodeB);
        	Tree<T> rightBranch = findLCA(root.rightChild , nodeA, nodeB);
      
        	// if both the left and the right subtrees of a node contain one of nodeA and nodeB, then this node is the LCA. 
        	if(leftBranch!= null && rightBranch!= null) {
            	return root;     
        	}
      
        	// if the left subtree contains both nodeA and nodeB, then keep looking in the left subtree. 
		if (leftBranch!=null) {
		    return leftBranch;
		}
		
		// else look in the right subtree
		return rightBranch;
	}
}
