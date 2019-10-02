package hr.fer.zemris.java.hw07.observer1;

/**
 * Instanca sučelja IntegerStorageObserver koja ispisuje kvadriranu vrijednost
 * postavljenog broja
 * 
 * @author Karlo
 *
 */
public class SquareValue implements IntegerStorageObserver {

	@Override
	public void valueChanged(IntegerStorage istorage) {
		System.out.println("Provided new value: " + istorage.getValue() + ", square is "
				+ istorage.getValue() * istorage.getValue());

	}

}
