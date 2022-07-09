package datastructure;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int x;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Insira o tamanho do array: ");
		x = scanner.nextInt();
		scanner.nextLine();
		
		int[] a = new int[x];
		
		for(int i = 0; i < x; i++) {
			System.out.println("Insira um valor: (" + (i+1) + "/" + x + ")");
			a[i] = scanner.nextInt();
			scanner.nextLine();
		}
		
		Arrays.sort(a);
		System.out.print("\n Array: \n");
		for(int i = 0; i < x; i++) {
			System.out.print(a[i] + " ");
		}
		
		AVLTree bt = new AVLTree(a[0]);
		for(int i = 1; i < x; i++) {
			bt.add(a[i]);
		}
		
		
		System.out.println("\n Arvore balanceada: ");
		bt.printPreOrder();
		

	}

}
