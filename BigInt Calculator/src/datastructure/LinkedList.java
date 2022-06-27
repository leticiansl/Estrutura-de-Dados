package datastructure;

public class LinkedList<T extends Comparable<T>> {
	protected Node<T> head;
	protected Node<T> last;
		
	public LinkedList() {
		super();
		this.head = null;
		this.last = null;
	}
	
	public Node<T> getHead() {
		return head;
	}
	public Node<T> getLast() {
		return last;
	}
	
	public void clean() {
		this.head = null;
		this.last = null;
	}
	
	/* Index do novo elemento é 0*/
	public void addIni(T newElement) {
		Node<T> newNode = new Node<T>(newElement, 0);
		if(this.head == null) {
			this.head = newNode;
			this.last = newNode;
		} else {
			this.last.setNext(newNode);
			newNode.setPrevious(this.last);
			this.last = newNode;
			this.last.setNext(this.head);
			this.head.setPrevious(this.last);
			/* metodo p ajeitar o index pq sou mt corna*/
			for(int i = 0; newNode != this.head; i++) {
				newNode.getPrevious().setIndex(i+1);
				newNode = newNode.getPrevious();
			}
		}
	}
	
	/* Head tem index 0 */
	public void addFin(T newElement) {
		if(this.head == null) {
			Node<T> newNode = new Node<T>(newElement,0);
			this.head = newNode;
			this.last = newNode;
		} else {
			Node<T> newNode = new Node<T>(newElement, this.last.getIndex()+1);
			this.last.setNext(newNode);
			newNode.setPrevious(this.last);
			this.last = newNode;
			this.last.setNext(this.head);
			this.head.setPrevious(this.last);
		}
	}	
	
	@Override
	public String toString() {
		String str = "Lista Vazia";
		if(head!=null) {
			boolean loop = false;
			str = "LinkedList: [";
			Node<T> node = this.head;
			do{
				if(node == this.last) {
					str = str.concat(" " + node + " ]");
					loop = true;
				} else {
					str = str.concat(" " + node + ",");
				}
				node = node.getNext();
			}while(loop == false);
		}		
		return str;
	}	
}
