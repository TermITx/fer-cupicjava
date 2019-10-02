package hr.fer.zemris.java.hw02.demo;

import hr.fer.zemris.java.hw02.ComplexNumber;

/**
 * Program koji poziva određene metode nad kompleksnim brojevima i demonstrira
 * njihovo djelovanje
 * 
 * @author Karlo
 *
 */

public class ComplexDemo {
	/**
	 * Metoda main stvara 3 kompleksna broja i izvodi određene operacije nam njima,
	 * te vraća rješenje
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ComplexNumber c1 = new ComplexNumber(2, 3);
		ComplexNumber c2 = ComplexNumber.parse("2.5-3i");
		System.out.println(c2);
		System.out.println(ComplexNumber.parse("2+i").toString());
		ComplexNumber c3 = c1.add(ComplexNumber.fromMagnitudeAndAngle(2, 1.57)).div(c2).power(3).root(2)[1];
		System.out.println(c3);
	}

}
