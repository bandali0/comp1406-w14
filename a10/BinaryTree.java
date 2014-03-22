public class BinaryTree {
	private String	   	data;
	private BinaryTree	leftChild;
	private BinaryTree	rightChild;

	public BinaryTree(String d) {
		data = d;
		leftChild = null;
		rightChild = null;
	}

	public BinaryTree(String d, BinaryTree left, BinaryTree right) {
		data = d;
		leftChild = left;
		rightChild = right;
	}
}
