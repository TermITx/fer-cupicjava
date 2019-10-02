package hr.fer.zemris.java.hw07.observer2;

/**
 * Klasa koja prati promjenu vrijednosti klase IntegerStograge
 * 
 * @author Karlo
 *
 */
public class IntegerStorageChange {

	/**
	 * Stara vrijednost
	 */
	int oldValue;

	/**
	 * Nova vrijednost
	 */
	int newValue;

	/**
	 * Primjerak klase IntegerStorage čije promjene prati
	 */
	IntegerStorage istorage;

	/**
	 * Konstuktor koji inicijalizira staru vrijednost, novu vrijednost i primjerak
	 * klase IntegerStorage
	 * 
	 * @param oldValue - stara vrijednost
	 * @param newValue - nova vrijednost
	 * @param istorage - Primjerak klase IntegerStorage čije promjene prati
	 */
	public IntegerStorageChange(int oldValue, int newValue, IntegerStorage istorage) {
		this.oldValue = oldValue;
		this.newValue = newValue;
		this.istorage = istorage;
	}

	/**
	 * Vraća staru vrijednost
	 * 
	 * @return stara vrijednost
	 */
	public int getOldValue() {
		return oldValue;
	}

	/**
	 * Vraća novu vrijednost
	 * 
	 * @return nova vrijednost
	 */
	public int getNewValue() {
		return newValue;
	}

	/**
	 * Vraća primjerak klase IntegerStorage čije promjene prati
	 * 
	 * @return primjerak klase IntegerStorage čije promjene prati
	 */
	public IntegerStorage getIstorage() {
		return istorage;
	}

}
