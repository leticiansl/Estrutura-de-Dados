package datastructure;

public class Main {

	public static void main(String[] args) {
		AVLTree ban = new AVLTree(1);
		ban.add(10);
		ban.add(5);
		ban.add(39);
		ban.printPreOrder();
		System.out.println("--------------------------------");
		ban.add(40);
		ban.printPreOrder();
		System.out.println("--------------------------------");
		ban.add(42);
		ban.printPreOrder();
		System.out.println("--------------------------------");
		ban.add(41);
		ban.printPreOrder();
		System.out.println("--------------------------------");
		ban.add(39);
		ban.printPreOrder();
		System.out.println("--------------------------------");
		ban.add(53);
		
		
		
		System.out.println("\n Balanceada: ");
		ban.printPreOrder();
		

	}

}
