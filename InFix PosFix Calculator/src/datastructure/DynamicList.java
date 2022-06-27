package datastructure;

public class DynamicList<T extends Comparable<T>> {

	protected Node<T> first;
	protected Node<T> last;
	protected Node<T> previous;
	protected Node<T> actual;
	protected int size;

	//return list size
	public int getSize() {
		return size;
	}
	
	//add new element in list
	public void add(T newElement) {
		Node<T> newNode = new Node<T>(newElement);
		
		if(this.first == null && this.last == null) {
			this.first = newNode;
			this.last = newNode;
			
		} else {
			this.last.setNext(newNode);
			this.last = newNode;
			
		}
		this.size++;			
	}

	
	public Node<T> search(int index){
		Node<T> actual = this.first;
		for(int i = 0; i < index; i++) {
			if(actual.getNext() != null) {
				actual = actual.getNext();
			}
		}
		return actual;
	}
	
	public void remove(T searchedElement) {
		Node<T> previous = null;
		Node<T> actual = this.first;
		for(int i = 0; i < this.getSize(); i++) {
			if(actual.getElement().equals(searchedElement)) {
				if(this.size == 1) {
					this.first = null;
					this.last = null;
					
				} else if(actual == first) {
					this.first = actual.getNext();
					actual.setNext(null);
						
				} else if (actual == last) {
					this.last = previous;
					previous.setNext(null);
					
				} else {			
					previous.setNext(actual.getNext());
					actual = null;
				}
				
				this.size--;
				break;
			}
			previous = actual;
			actual = actual.getNext();
		}
	}
	
	
	public void orderList(DynamicList<T> list) {
		int minIndex = 0;
		T min;
		T actual;
		
		for(int i = 0; i < list.getSize(); i++) {
			min = list.search(i).getElement();
			
			for(int j = i; j < list.getSize(); j++) {
				actual = list.search(j).getElement();
				
				if(min.compareTo(actual) > 0) {
					min = list.search(j).getElement();
					minIndex = j;
				}
			}
			list.changeOrder(list.search(minIndex), list.search(i));
		}
	}
	
	public void changeOrder(Node<T> a, Node<T> b) {
		T aux = a.getElement();		
		a.setElement(b.getElement());
		b.setElement(aux);	
	}
	
	@Override
	public String toString() {
		return (first != null ? " " + first : "") + "";
	}
	
	
	
}