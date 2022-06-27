package Calculator;

public class CalculatorOperator{
	Calculator calculator = new Calculator();
	ExpressionHandler expHandler = new ExpressionHandler();

	public void controller(String exp) {
		expHandler.setExp(exp);
		System.out.println("Expressão inserida: " + exp);
		exp = expHandler.stringTreatment(exp);
		if(exp.equalsIgnoreCase("false")) {
			System.out.println("Expressão inválida");
		} else {
			System.out.println("Expressão pós-fixada: " + exp);
			pfReader(exp);
			calculator.cal();		
		}
	}	
		
 	//coloca expressão pf na pilha
	public void pfReader(String pfExp) {
		for(int i = pfExp.length()-1; i >= 0 ; i--) {
			if(i == 0 || pfExp.charAt(i-1) == ' ' || Character.isDigit(pfExp.charAt(i-1))) {
				if(Character.isDigit(pfExp.charAt(i))) {
					String num = Character.toString(pfExp.charAt(i));
	 				if (i > 0 && Character.isDigit(pfExp.charAt(i-1))) {
	 					int j = i;
	 					do {
	 						String aux = num;
	 						num = Character.toString(pfExp.charAt(j-1));
	 						num = num.concat(aux);
	 						j--;
	 					} while (j > 0 && Character.isDigit(pfExp.charAt(j-1)));
	 					i = j;
	 				}
	 				calculator.getStackExp().push(num);
				} else if (pfExp.charAt(i) == ' ') {
					
				
				} else {
					calculator.getStackExp().push(Character.toString(pfExp.charAt(i)));
				}		
			}
		}
	}
}
