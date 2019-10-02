package hr.fer.zemris.java.hw07.observer2;

/**
 * Instanca sučelja IntegerStorageObserver koja ispisuje koliko puta smo
 * promijenili vrijednost
 * 
 * @author Karlo
 *
 */
public class ChangeCounter implements IntegerStorageObserver {

	/**
	 * Brojač
	 */
	int n;

	@Override
	public void valueChanged(IntegerStorageChange istorage) {
		System.out.println("Number of value changes since tracking: " + ++n);
	}

}
