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
	
	public BinaryTree getLeftChild() {
		return leftChild;
	}
	
	public BinaryTree getRightChild() {
		return rightChild;
	}
	
	public boolean hasSameStructureAs(BinaryTree tree) {
//		if (!(getLeftChild() == null || tree.getLeftChild() == null) && !(getLeftChild().hasSameStructureAs(tree.getLeftChild())))
//			return false;
//		
//		
//		if (!(getRightChild() == null || tree.getRightChild() == null))
//			if (!(getRightChild().hasSameStructureAs(tree.getRightChild())))
//				return false;
//			else
//				return true;
//		else if (getRightChild() == null && tree.getRightChild() == null)
//				return true;
//		else
//			return false;
		

		if(getLeftChild() == null && tree.getLeftChild() == null &&
			getRightChild() == null && tree.getRightChild() == null )
	            return true;

		if(!(getLeftChild() == null || tree.getLeftChild() == null) &&
			getRightChild() == null && tree.getRightChild() == null )
	            return getLeftChild().hasSameStructureAs(tree.getLeftChild());
		
		if(getLeftChild() == null && tree.getLeftChild() == null &&
	        !(tree.getRightChild() == null || this.getRightChild() == null) )
	            return getRightChild().hasSameStructureAs(tree.getRightChild());

	    if(!(getLeftChild() == null || tree.getLeftChild() == null) &&
	    		!(getRightChild() == null || tree.getRightChild() == null) )
	            return getLeftChild().hasSameStructureAs(tree.getLeftChild()) &&
	            		getRightChild().hasSameStructureAs(tree.getRightChild());

	    return false;
					
	}
}
