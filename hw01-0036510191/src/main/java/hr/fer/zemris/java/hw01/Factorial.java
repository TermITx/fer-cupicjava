package hr.fer.zemris.java.hw01;

import java.util.Scanner;

/**
 * Program which calculates factorial of given number if the number is from 3 to 20
 * 
 * @author Karlo Lochert
 *
 */

public class Factorial {
	
	/**
	 * Returns factorial of given number
	 * 
	 * @param num - given number
	 * @return - factorial of given number
	 */
	public static long izracunaj(int num) {
		if (num < 0) {
			throw new IllegalArgumentException("Expected positive number.");
		}
		
		if (num == 0) {
			return 1;
		}
		
		long fact = num;
		for (int i = num; i > 1; i--) {
			fact *= (i - 1);
		}
		return fact;
	}

	/**
	 * Program expects number given through console and prints factorial of given number
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String b;
		int a = 0;
		do {
			System.out.print("Unesite broj > ");
			b = sc.nextLine();
			try {
				a = Integer.parseInt(b);
			} catch (IllegalArgumentException e) {
				if (b.equals("kraj")) {
					break;
				}
				System.out.println("'" + b + "'" + " nije cijeli broj.");
				continue;
			}
			if (a < 3 || a > 20) {
				System.out.println("'" + a + "'" + " nije broj u dozvoljenom rasponu.");
				continue;
			}
			System.out.println(a + "! = " + izracunaj(a));
		} while (!b.equals("kraj"));
		sc.close();
		System.out.println("Doviđenja.");
	}

}
