package hr.fer.zemris.java.custom.collections;

/**
 * Klasa koja implementira stog
 * 
 * @author Karlo
 *
 */

public class ObjectStack {
	private ArrayIndexedCollection pomocnaKolekcija;

	public ObjectStack() {
		pomocnaKolekcija = new ArrayIndexedCollection();
	}

	/**
	 * Vraća je li stog prazan
	 * 
	 * @return true ako je stog prazan, false ako nije
	 */
	public boolean isEmpty() {
		return pomocnaKolekcija.isEmpty();
	}

	/**
	 * Vraća veličinu stoga
	 * 
	 * @return veličina stoga
	 */
	public int size() {
		return pomocnaKolekcija.size();
	}

	/**
	 * Briše sve elemente stoga
	 */
	public void clear() {
		pomocnaKolekcija.clear();
	}

	/**
	 * Metoda ubacuje element na stog
	 * 
	 * @param value - element koji se ubacuje na stog
	 */
	public void push(Object value) {
		pomocnaKolekcija.add(value);
	}

	/**
	 * Metoda skida element s vrha stoga
	 * 
	 * @return element s vrha stoga
	 * @throws EmptyStackException ako je stog prazan
	 */
	public Object pop() {
		if (pomocnaKolekcija.size() == 0) {
			throw new EmptyStackException();
		}
		Object ret = pomocnaKolekcija.get(pomocnaKolekcija.size() - 1);
		pomocnaKolekcija.remove(ret);
		return ret;
	}

	/**
	 * Metoda prikazuje element s vrha stoga
	 * 
	 * @return element s vrha stoga
	 * @throws EmptyStackException ako je stog prazan
	 */
	public Object peek() {
		if (pomocnaKolekcija.size() == 0) {
			throw new EmptyStackException();
		}
		return pomocnaKolekcija.get(pomocnaKolekcija.size() - 1);
	}
}
