package hr.fer.zemris.java.custom.collections;

/**
 * Klasa predstavlja implementaciju kolekcije
 * 
 * @author Karlo
 *
 */

public class Collection {

	/**
	 * Metoda provjerava je li kolekcija prazna
	 * 
	 * @return vraca true ako jest, a false ako nije
	 */
	public boolean isEmpty() {
		if (this.size() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Metoda vraća veličinu kolekcije
	 * 
	 * @return
	 */
	public int size() {
		return 0;
	}

	/**
	 * Dodaje element u kolekciju
	 * 
	 * @param value
	 */
	public void add(Object value) {
	}

	/**
	 * Provjerava postoji li primjerak objekta value u kolekciji
	 * 
	 * @param value
	 * @return vraća true ako postoji, a false ako ne postoji
	 */
	public boolean contains(Object value) {
		return false;
	}

	/**
	 * Briše prvi primjerak objekta iz kolekcije
	 * 
	 * @param value
	 * @return vraća true ako je primjerak uspješno obrisan, a false ako nij
	 */
	public boolean remove(Object value) {
		return false;
	}

	/**
	 * Vraća kolekciju u obliku liste
	 * 
	 * @return
	 */
	public Object[] toArray() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Za svaki element kolekcije obavlja radnju, određenom metodom proces iz klase
	 * Processor
	 * 
	 * @param processor
	 */
	public void forEach(Processor processor) {
	}

	/**
	 * Dodaje sve elemente iz zadane kolekcije u ovu kolekciju
	 * 
	 * @param collection
	 */
	public void addAll(Collection collection) {
		class AddProcessor extends Processor {
			@Override
			public void process(Object object) {
				if (object != null) {
					add(object);
				}
			}
		}
		collection.forEach(new AddProcessor());
	}
}
