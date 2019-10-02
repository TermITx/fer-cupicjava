package hr.fer.zemris.java.hw07.demo2;

import java.util.Iterator;

/**
 * Klasa koja pomoću interatora izbacuje predani broj prostih brojeva
 * 
 * @author Karlo
 *
 */
public class PrimesCollection implements Iterable<Integer> {

	/**
	 * Broj prostih brojeva koje želimo prikazati
	 */
	int numberOfPrimes;

	/**
	 * Konstrukotr koji inicijalizira broj prostih brojeva koje želimo prikazati
	 * 
	 * @param numberOfPrimes - broj prostih brojeva koje želimo prikazati
	 */
	public PrimesCollection(int numberOfPrimes) {
		this.numberOfPrimes = numberOfPrimes;
	}

	/**
	 * Iterator prostih brojeva
	 * 
	 * @author Karlo
	 *
	 */
	private class MyIterator implements Iterator<Integer> {

		/**
		 * Broj prostih brojeva koje smo izbacili do sada
		 */
		int numberOfCurrentPrime;

		/**
		 * Trenutni prosti broj
		 */
		int potentialPrime;

		/**
		 * Konstruktor koji inicijalizira početni prosti broj
		 */
		public MyIterator() {
			this.potentialPrime = 2;
		}

		/**
		 * Vraća treba li izbaciti još prostih brojeva
		 */
		public boolean hasNext() {
			return numberOfCurrentPrime < numberOfPrimes;
		}

		/**
		 * Generira sljedeći prosti broj
		 */
		public Integer next() {
			boolean found = false;
			if (!hasNext()) {
				throw new IllegalArgumentException("Nema vise");
			}
			while (!found) {
				for (int i = 2; i <= Math.sqrt(potentialPrime); i++) {
					if (potentialPrime % i == 0) {
						potentialPrime++;
						i = 1;
					}
				}
				found = true;
			}
			potentialPrime++;
			numberOfCurrentPrime++;
			return potentialPrime - 1;

		}

	}

	/**
	 * Stvara instancu iteratora prostih brojeva
	 */
	public Iterator<Integer> iterator() {
		return new MyIterator();
	}

}
