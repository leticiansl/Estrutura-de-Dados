package BigInt;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Operator op = new Operator();
		Scanner scanner = new Scanner(System.in); 
		String exp;
		
		try {
			System.out.println("Insira a expressão: ");
			exp = scanner.nextLine();
			op.calculate(exp);	
			
		} catch (Exception e) {
			System.out.println("Expressão inválida");
		}
	}
}
