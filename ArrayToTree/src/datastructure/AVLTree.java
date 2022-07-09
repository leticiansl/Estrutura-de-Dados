package datastructure;

public class AVLTree extends BinaryTree {

	public AVLTree(int newElement) {
		super(newElement);
	}
	
	private int height(Node element) {
		if(element != null) {
			return element.getHeight();
		}		
		return -1;
	}
	
	private void updateHeight(Node element) {
		int aux = 1 + Math.max(height(element.getLeft()), height(element.getRight()));
		element.setHeight(aux);
	}
	
	private int getBalance(Node element) {
		return height(element.getRight()) - height(element.getLeft());
	}
	

	private Node rotateRight(Node y){
		Node aux = new Node(0);
		aux.setParent(y.getParent());
		Node x = y.getLeft();
		Node z = x.getRight();
		x.setRight(y);
		y.setParent(x);
		x.setParent(aux.getParent());
		y.setLeft(z);
		if(z != null) {
			z.setParent(y);
		}
		if(y == this.root) {
			 this.root = x;
			 x.setParent(null);
		 }		
		updateHeight(y);
		updateHeight(x);
		return x;
	}
	
	private Node rotateLeft(Node y) {
		Node aux = new Node(0);
		aux.setParent(y.getParent());
		Node x = y.getRight();
		Node z = x.getLeft();
		x.setLeft(y);
		y.setParent(x);
		x.setParent(aux.getParent());
		y.setRight(z);
		if(z != null) {
			z.setParent(y);
		}
		if(y == this.root) {
			 this.root = x;
			 x.setParent(null);
		 }
		updateHeight(y);
		updateHeight(x);
		return x;
	}
	
	private void changeChild(Node z, Node aux) {
		if(z != this.root) {
			Node parent = aux.getParent();
			if(z.getLeft() == parent.getLeft() || z.getRight() == parent.getLeft()) {
				parent.setLeft(z);
			} else if(z.getLeft() == parent.getRight() || z.getRight() == parent.getRight()) {
				parent.setRight(z);
			} else {
				System.out.println("Vc sabe onde ta meu pai?");
			}
		}		
	}
	
	private Node rebalance(Node z) {
		Node aux = new Node(0);
		aux.setParent(z.getParent());
		updateHeight(z);
	    int balance = getBalance(z);
	    if (balance > 1) {
	        if (height(z.getRight().getRight()) > height(z.getRight().getLeft())) {
	            z = rotateLeft(z);
	            changeChild(z, aux);
	            
	        } else {
	            z.setRight(rotateRight(z.getRight()));
	            z = rotateLeft(z);
	            changeChild(z, aux);
	        }
	    } else if (balance < -1) {
	        if (height(z.getLeft().getLeft()) > height(z.getLeft().getRight())) {
	        	z = rotateRight(z);
	        	changeChild(z, aux);
	        }	            
	        else {
	            z.setLeft(rotateLeft(z.getLeft()));
	            z = rotateRight(z);
	        }
	    }
	    return z;
	}
	

	@Override
	public void addNode(Node node, int newElement) {
		super.addNode(node, newElement);
		rebalance(node);
	}


}
