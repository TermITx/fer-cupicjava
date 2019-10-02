package hr.fer.zemris.java.hw07.observer1;

/**
 * Sučelje koje prilikom promjene vrijednosti u klasi IntegerStorage obavlja
 * neku radnju
 * 
 * @author Karlo
 *
 */
public interface IntegerStorageObserver {

	/**
	 * Metoda koja se poziva prilikom promjene vrijednosti u klasi IntegerStorage,
	 * te se njome odrađuje neka radnja
	 * 
	 * @param istorage - instanca klase IntegerStorage čija se vrijednost
	 *                 promijenila
	 */
	public void valueChanged(IntegerStorage istorage);
}