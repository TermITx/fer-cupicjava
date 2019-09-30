package hr.fer.zemris.java.hw01;

import java.util.Scanner;

/**
 * Program which calculates area and perimeter
 * 
 * @author Karlo Lochert
 *
 */
public class Rectangle {
	
	/**
	 * Returns area of rectangle given with width and height
	 * 
	 * @param a - width
	 * @param b - height
	 * @return - area of rectangle
	 */
	public static double povrsina(double a, double b) {
		return a * b;
	}

	/**
	 *Returns perimeter of rectangle given with width and height
	 * 
	 * @param a - width
	 * @param b - height
	 * @return - perimeter of rectangle
	 */
	public static double opseg(double a, double b) {
		return 2 * a + 2 * b;
	}

	/**
	 * Expects height and width of rectangle and returns its area and perimeter
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length != 0 && args.length != 2) {
			System.out.println("Treba unesti 2 ili nijedan argument!");
			return;
		}

		if (args.length == 0) {
			Scanner sc = new Scanner(System.in);
			String a;
			double width = 0;
			do {
				System.out.println("Unesite širinu: ");
				a = sc.nextLine();
				try {
					width = Double.parseDouble(a);
				} catch (Exception e) {
					System.out.println("'" + a + "'" + " se ne može protumačiti kao broj.");
					continue;
				}
				if (width < 0) {
					System.out.println("Unijeli ste negativnu vrijednost.");
					continue;
				}
				if (width == 0) {
					System.out.println("Širina ne može biti 0.");
					continue;
				}
			} while (width <= 0);
			String b;
			double height = 0 ;
			do {
				System.out.println("Unesite visinu: ");
				b = sc.nextLine();
				try {
					height = Double.parseDouble(b);
				} catch (Exception e) {
					System.out.println("'" + b + "'" + " se ne može protumačiti kao broj.");
					continue;
				}
				if (height < 0) {
					System.out.println("Unijeli ste negativnu vrijednost.");
					continue;
				}
				if (height == 0) {
					System.out.println("Visina ne može biti 0.");
					continue;
				}
			} while (height <= 0);
			
			sc.close();
			System.out.println("Pravokutnik širine " + a + " i visine " + b + " ima površinu "
					+ povrsina(Double.parseDouble(a), Double.parseDouble(b)) + " te opseg "
					+ opseg(Double.parseDouble(a), Double.parseDouble(b)) + ".");
			return;
		}

		double a = 0;
		double b = 0;
		try {
			a = Double.parseDouble(args[0]);
			b = Double.parseDouble(args[1]);

		} catch (NumberFormatException e) {
			System.out.println("Neispravni argumenti");
		}
		
		if (a < 0 || b < 0) {
			System.out.println("Brojevi ne smiju biti negativni");
			return;
		}
		System.out.println("Pravokutnik širine " + a + " i visine " + b + " ima površinu " + povrsina(a, b)
				+ " te opseg " + opseg(a, b) + ".");
	}
}
