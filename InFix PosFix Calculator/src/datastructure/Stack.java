package datastructure;

public class Stack<T extends Comparable<T>>{
	
	protected Node<T> last;
	protected int size;
	
	public Stack() {
		super();
	}
	
	//empilha
	public void push(T newElement) {
		Node<T> newNode = new Node<T>(newElement);
		
		if(this.last == null) {
			this.last = newNode;
			this.size++;
				
		} else {
			Node<T> previous = this.last;
			this.last = newNode;
			this.last.setNext(previous);	
			this.size++;
		}
			
			
	}
	
	// mostra o topo
	public T check() {
		if(this.size == 0) {
			return null;
		}
		return this.last.getElement();
	}
	
	//desempilha
	public T pop() {
		if(this.size == 0) {
			return null;
		}
		T node = this.last.getElement();
		this.last = last.getNext();
		this.size--;
		return node;
	}
	
	public int getSize() {
		return this.size;
	}

	@Override
	public String toString() {
		return "Pilha [last=" + last + ", size=" + size + "]";
	}
	
	
}
