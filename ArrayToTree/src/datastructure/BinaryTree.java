package datastructure;

public class BinaryTree {
	protected Node root;

	public BinaryTree(int newElement) {
		super();
		this.root = new Node(newElement);
	}
	
	public void teste() {
		System.out.println("A");
	}
	
	public void add(int newElement) {
		addNode(root, newElement);
	}
	
	public void printInOrder() {
		inOrder(root);
	}
	
	public void printPreOrder() {
		preOrder(root);
	}
	
	public void printPostOrder() {
		postOrder(root);
	}
	
	public void addNode(Node node, int newElement) {
		if(root == null) {
			Node newNode = new Node(newElement);
			root = newNode;
		} else if(newElement < node.getElement()){
			if(node.getLeft() == null) {
				Node newNode = new Node(newElement);
				node.setLeft(newNode);
				newNode.setParent(node);
			} else {
				addNode(node.getLeft(), newElement);
			}
		} else if(newElement > node.getElement()) {
			if(node.getRight() == null) {
				Node newNode = new Node(newElement);
				node.setRight(newNode);
				newNode.setParent(node);
			} else {
				addNode(node.getRight(), newElement);
			}
		} else {
			System.out.println("Duplicado!");
		}	
	} 
	
	protected void inOrder(Node node) {
		if(node != null) {
			inOrder(node.getLeft());
			System.out.print(node.getElement() + " ");
			inOrder(node.getRight());
		}
	}
	
	protected void preOrder(Node node) {
		if(node != null) {
			System.out.print(node.getElement() + " ");
			preOrder(node.getLeft());			
			preOrder(node.getRight());
		}
	}
	
	protected void postOrder(Node node) {
		if(node != null) {
			postOrder(node.getLeft());			
			postOrder(node.getRight());
			System.out.print(node.getElement() + " ");
		}
	}


}
