public class Tree<T>{
	T key;
	Tree<T> leftChild;
	Tree<T> rightChild;
	
	public Tree(T key, Tree<T> left, Tree<T> right){
		this.key = key;
		leftChild = left;
		rightChild = right;
	}
}

