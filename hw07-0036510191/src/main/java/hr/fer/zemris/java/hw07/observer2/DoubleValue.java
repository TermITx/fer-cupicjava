package hr.fer.zemris.java.hw07.observer2;

/**
 * Instanca sučelja IntegerStorageObserver koja ispisuje decimalnu vrijednost
 * postavljenog broja
 * 
 * @author Karlo
 *
 */
public class DoubleValue implements IntegerStorageObserver {

	/**
	 * Broj ispisa
	 */
	int n = 0;

	/**
	 * Konstrukotr koji inicijalizira željeni broj ispisa
	 * 
	 * @param n
	 */
	public DoubleValue(int n) {
		this.n = n;
	}

	@Override
	public void valueChanged(IntegerStorageChange change) {
		if (n > 0) {
			n--;
			System.out.println("Double value: " + change.getNewValue() * 2);
		}
	}

}
