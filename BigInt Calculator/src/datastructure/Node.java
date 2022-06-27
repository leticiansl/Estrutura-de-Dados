package datastructure;

public class Node<T extends Comparable<T>> {
	private T element;
	private Node<T> next;
	private Node<T> previous;
	private int index;
	
	public Node(T element, int index) {
		this.element = element;
		this.next = null;
		this.previous = null;
		this.index = index;
	}
	
	public T getElement() {
		return element;
	}
	public Node<T> getNext() {
		return next;
	}
	public Node<T> getPrevious() {
		return previous;
	}	
	public int getIndex() {
		return index;
	}

	public void setElement(T element) {
		this.element = element;
	}
	public void setNext(Node<T> next) {
		this.next = next;
	}
	public void setPrevious(Node<T> previous) {
		this.previous = previous;
	}
	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public String toString() {
		return  "" + element ;
	}	
}
