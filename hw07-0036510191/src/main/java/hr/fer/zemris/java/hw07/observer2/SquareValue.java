package hr.fer.zemris.java.hw07.observer2;

/**
 * Instanca sučelja IntegerStorageObserver koja ispisuje kvadriranu vrijednost
 * postavljenog broja
 * 
 * @author Karlo
 *
 */
public class SquareValue implements IntegerStorageObserver {

	@Override
	public void valueChanged(IntegerStorageChange change) {
		System.out.println("Provided new value: " + change.getNewValue() + ", square is "
				+ change.getNewValue() * change.getNewValue());

	}

}
