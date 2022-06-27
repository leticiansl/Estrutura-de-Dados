package Calculator;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String exp;
		CalculatorOperator calculator = new CalculatorOperator();
		Scanner scanner = new Scanner(System.in);
		
		try {
			System.out.println("Insira a expressão algébrica: ");
			exp = scanner.nextLine();
			calculator.controller(exp);
			
		} catch (Exception e) {
			System.out.println("Expressão inválida");
		}


	}

}
