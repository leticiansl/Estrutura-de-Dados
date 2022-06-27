package BigInt;
import datastructure.LinkedList;
import datastructure.Node;

public class Calculator {
	LinkedList<Integer> num;
	LinkedList<Integer> mult;
	LinkedList<Integer> prod;
	
	public Calculator() {
		super();
		this.num = new LinkedList<Integer>();
		this.mult = new LinkedList<Integer>();
		this.prod = new LinkedList<Integer>();
	}

	public LinkedList<Integer> getNum() {
		return num;
	}
	public LinkedList<Integer> getMult() {
		return mult;
	}	
	public LinkedList<Integer> getProd() {
		return prod;
	}

	public void setNum(LinkedList<Integer> num) {
		this.num = num;
	}

	public void setMult(LinkedList<Integer> mult) {
		this.mult = mult;
	}

	public void setProd(LinkedList<Integer> prod) {
		this.prod = prod;
	}

	public void cal() {
		int res;
		Node<Integer> nNum, nMult;
		
		nMult = mult.getLast();
		for(int i = 0; i <= mult.getHead().getIndex(); i++) {			
			nNum = num.getLast();
			for(int j = 0; j <= num.getHead().getIndex(); j++) {
				res = nMult.getElement() * nNum.getElement();
				prodHandler(res, i, j);

				nNum = nNum.getPrevious();
			}
			nMult = nMult.getPrevious();
		}
		showResult();
	}
		
	public void prodHandler(int res, int mult, int num) {
		LinkedList<Integer> aux = new LinkedList<Integer>();
		Node<Integer> nAux, nProd;
		Operator.stringHandler(Integer.toString(res), aux);	
		
		nAux = aux.getLast();
		for(int i = 0; i <= aux.getHead().getIndex(); i++) {
			if(prod.getHead() == null) {
				prod.addFin(nAux.getElement());
			} else if (prod.getLast().getIndex() < i+mult+num){
				prod.addFin(nAux.getElement());
			} else {
				nProd = prod.getHead();
				for(int j = 0; j <= prod.getLast().getIndex(); j++) {
					if(j == i+mult+num) {
						int soma = nProd.getElement() + nAux.getElement();
						if(soma > 99) {
							nProd.setElement(0);
							prodHandler(soma, i, j);
						} else {
							nProd.setElement(soma);
						}						
					} else {
						nProd = nProd.getNext();
					}
				}
			}
			nAux = nAux.getPrevious();
		}
	}
	
	public void showResult() {
		String str = "Lista Vazia";
		if(prod.getHead()!=null) {
			boolean loop = false;
			str = "Resultado: ";
			Node<Integer> node = prod.getLast();
			do{
				
				if (node.getIndex() != prod.getLast().getIndex() 
						&& node.getElement() < 10) { 
					str = str.concat("0" + node + "");
				}else {
					str = str.concat(node + "");
				} if(node == prod.getHead()) {
					loop = true;
				}
				node = node.getPrevious();
			}while(loop == false);
		}		
		System.out.println(str);
	}

}
