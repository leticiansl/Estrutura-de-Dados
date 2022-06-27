package Calculator;
import datastructure.Stack;

public class ExpressionHandler {
	String exp;
	
	
	public ExpressionHandler() {
		super();
	}
	

	/* Retorna false se os parenteses estão desbalanceados*/
	private boolean checkParenthesis() {
		int a = 0, b = 0;
		for(int i = 0; i < exp.length(); i++) {
			if(exp.charAt(i) == '(') {
				a++;
			} else if(exp.charAt(i) == ')') {
				b++;
			}
		}
		if(a != b) {
			return false;
		}
		return true;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}


	/* Retorna false se existem dois operadores em seguida */
	private boolean checkOperators() {
		for(int i = 0; i < exp.length()-1; i++) {
			if(Calculator.isOperator(exp.charAt(i)) && Calculator.isOperator(exp.charAt(i+1))) {
				return false;
			} else if(Calculator.isOperator(exp.charAt(i)) && exp.charAt(i+1) == ')') {
				return false;
			} else if(exp.charAt(i) == '(' && Calculator.isOperator(exp.charAt(i+1))) {
				return false;
			}
		}
		return true;
	}
	
	/* Transforma a expressão algébrica em uma expressão pós fixada */
	public String algReader(String algExp) {
 		Stack<Character> auxStack = new Stack<Character>();
 		String pfExp = null;
 		for(int i = 0; i< algExp.length(); i++) {
 			if(algExp.charAt(i) == ' ') {
 
 			} else if (Calculator.isOperator(algExp.charAt(i)) || 
 					algExp.charAt(i) == '('){
 				auxStack.push(algExp.charAt(i));
 			} else if (Character.isDigit(algExp.charAt(i))) {
 				String num = Character.toString(algExp.charAt(i));
 				if (Character.isDigit(algExp.charAt(i+1))) {
 					int j = i;
 					do {
 						num = num.concat(Character.toString(algExp.charAt(j+1)));
 						j++;
 					} while (Character.isDigit(algExp.charAt(j+1)));
 					i = j;
 				}
 				
 				
 				
 				if(pfExp == null) {
 					pfExp = num;
 				} else {
 					pfExp = pfExp.concat(" " + num);
 				}
 			} else if (algExp.charAt(i) == ')') {
 				while(auxStack.check() != '(') {
 					pfExp = pfExp.concat(" " + Character.toString(auxStack.pop()));
 				}
 				auxStack.pop();
 				
 			} else {
 				return "false";
 			}
 		}
 		return pfExp;
 	}
	
	/* Realiza o tratamento da String
	 * Retorna a expressão pós fixada se a expressão for válida
	 * Retorna "false" se a expressão estiver errada*/
	public String stringTreatment(String exp) {
		if(checkParenthesis()) {
			/* Adiciona parenteses */
			exp = Character.toString('(').concat(exp + ")");
			if(checkOperators()) {
				exp = algReader(exp);
				return exp;
			}
		}
		return "false";
	}
}
