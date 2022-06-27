package Calculator;
import datastructure.Stack; 

public class Calculator {
	private Stack<String> stackExp;
	private Stack<Integer> stackNum;
	
	
	public Calculator() {
		super();
		this.stackExp = new Stack<String>();
		this.stackNum = new Stack<Integer>();
	}

	
	
	public Stack<String> getStackExp() {
		return stackExp;
	}


	/* Realiza operações */
 	private int function() {
 		int b = stackNum.pop(); 
 		int a = stackNum.pop();
 		String x = stackExp.pop();
		int result = 0;
		
		switch(x) {
		case "+":
			result = a+b;
			break;
			
		case "-":
			result = a-b;
			break;
			
		case "*":
			result = a*b;
			break;
		
		case "/":
			result = a/b;
			break;
			
		default:
			System.out.println("Não encontrou função");
			break;
		}
		return result;
	}

	/* Retorna true o char corresponde a um operador */
	static boolean isOperator (char character) {
		if(	character == '+' || 
				character == '-' || 
				character == '*' || 
				character == '/') {
			return true;
		}
		return false;
	}
 		
	/* Calcula o resultado da função pós fixada */
	public void cal() {
		int count = 0;
		do{
			if(Character.isDigit(stackExp.check().charAt(0))) {
				stackNum.push(Integer.parseInt(stackExp.pop()));
			} else if(isOperator(stackExp.check().charAt(0))) {
				stackNum.push(function());
			} else {
				System.out.println("caractere invalido");
				break;
			}
			count++;
		}while(stackExp.getSize() > 0 || stackNum.getSize() > 1 || count < 2);
		System.out.println("Resultado: " + stackNum.pop());
	}

	
	
}
