package datastructure;

public class Node {
	private int element;
	private int height;
	private Node parent;
	private Node left;
	private Node right;
	
	public Node(int element) {
		super();
		this.element = element;
		this.height = 0;
		this.parent = null;
		this.left = null;
		this.right = null;
	}
	

	public int getElement() {
		return element;
	}
	public int getHeight() {
		return height;
	}
	public Node getParent() {
		return parent;
	}
	public Node getLeft() {
		return left;
	}
	public Node getRight() {
		return right;
	}
	

	public void setElement(int element) {
		this.element = element;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public void setRight(Node right) {
		this.right = right;
	}
			
	
}
