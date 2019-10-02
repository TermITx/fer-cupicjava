package hr.fer.zemris.java.hw07.observer2;

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
	 * @param istorage - instanca klase IntegerStorageChange koja prati promejenu
	 *                 vrijednosti
	 */
	public void valueChanged(IntegerStorageChange istorage);
}