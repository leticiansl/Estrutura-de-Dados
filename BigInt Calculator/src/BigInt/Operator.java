package BigInt;

import datastructure.LinkedList;

public class Operator {
	Calculator calculator;
		
	public Operator() {
		super();
		this.calculator = new Calculator();
	}

	/* Separa os números em duas strings e chama a proxima funçao*/
	public boolean inputHandler(String exp){
		String num = null, mult = null;
		boolean but = false;
		for(int i = 0; i < exp.length(); i++) {
			if(exp.charAt(i) == '*' || exp.charAt(i) == 'x') {
				but = true;
			}else if(but == false && Character.isDigit(exp.charAt(i))) {
				if(num == null) {
					num = Character.toString(exp.charAt(i));
				} else {
					num = num.concat(Character.toString(exp.charAt(i)));
				}
			} else if (but == true && Character.isDigit(exp.charAt(i))) {
				if(mult == null) {
					mult = Character.toString(exp.charAt(i));
				} else {
					mult = mult.concat(Character.toString(exp.charAt(i)));
				}
			} else {
				System.out.println("Expressão inválida");
				return false;				
			}
		}
		if(but) {
			stringHandler(num, calculator.getNum());
			stringHandler(mult, calculator.getMult());
			return true;
		} else {
			System.out.println("Expressão inválida");
			return false;
		}		
	}

	/* Coloca os numeros nas listas*/
	static void stringHandler(String exp, LinkedList<Integer> list) {
		for(int i = 0; i < exp.length(); i+=2) {
			String num = Character.toString(exp.charAt(i));
			if(i == 0 && exp.length()%2 == 1) {
				list.addIni(Integer.parseInt(num));
				i--;
			} else {
				num = num.concat(Character.toString(exp.charAt(i+1)));
				list.addIni(Integer.parseInt(num));
			}
		}
	}
	
	public void calculate(String exp) {
		if(inputHandler(exp)) {
			calculator.cal();
			clean();
		}		
	}

	public void clean() {
		calculator.getNum().clean();
		calculator.getMult().clean();
		calculator.getProd().clean();
	}
}