package hr.fer.zemris.java.hw07.observer1;

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
	int n;

	/**
	 * Konstrukotr koji inicijalizira željeni broj ispisa
	 * 
	 * @param n
	 */
	public DoubleValue(int n) {
		this.n = n;
	}

	@Override
	public void valueChanged(IntegerStorage istorage) {
		if (n > 0) {
			n--;
			System.out.println("Double value: " + istorage.getValue() * 2);
		} else {
			istorage.removeObserver(this);
		}
	}

}
