package hr.fer.zemris.java.custom.collections;

import java.util.Arrays;

/**
 * Klasa koja nudi implementaciju kolekcije koja koristi polje kao pomoćnu
 * strukturu, te se njenim elementima može pristupiti preko indeksa
 * 
 * @author Karlo
 *
 */

public class ArrayIndexedCollection extends Collection {
	public int capacity;
	private Object[] elements;
	private int size;
	private static final int INITIALCAPACITY = 16;

	/**
	 * Konstruktor koji postavlja kapacitet na 16
	 */
	public ArrayIndexedCollection() {
		this(INITIALCAPACITY);
	}

	/**
	 * Konstruktor koji prima kapacitet kolekcije i inicijalizira pomoćno polje
	 * 
	 * @param initialCapacity - zadani kapacitet kolekcije
	 * @throws IllegalArgumentException ako je predani kapacitet manji od 0
	 */
	public ArrayIndexedCollection(int initialCapacity) {
		if (initialCapacity <= 0) {
			throw new IllegalArgumentException();
		}
		this.elements = new Object[initialCapacity];
		this.capacity = initialCapacity;
	}

	/**
	 * Konstruktor koji prima drugu kolekciju i željeni kapacitet ove kolekcije, te
	 * ubacuje sve elemente iz predane kolekcije u ovu. Ako je kapacitet manji od
	 * veličine kolekcije koju ubacujemo, kapacitet se postavlja na veličinu predane
	 * kolekcije
	 * 
	 * @param collection      - predana kolekcija koja se dodaje u ovu kolekciju
	 * @param initialCapacity - željeni kapacitet kolekcije
	 * @throws NullPointerException ako je predana kolekcija null
	 */
	public ArrayIndexedCollection(Collection collection, int initialCapacity) {
		if (collection == null) {
			throw new NullPointerException();
		}
		if (initialCapacity < collection.size()) {
			this.elements = new Object[collection.size()];
			this.capacity = collection.size();
			this.addAll(collection);
		} else {
			this.elements = new Object[initialCapacity];
			this.capacity = initialCapacity;
			this.addAll(collection);
		}
	}

	/**
	 * Konstruktor koji predanu kolekciju ubacuje u ovu, te inicijalizira kapacitet
	 * na 16. Ako je taj kapacitet manji od veličine kolekcije koju ubacujemo,
	 * kapacitet se postavlja na kapacitet predanekolekcije
	 * 
	 * @param collection - predana kolekcija koju ubacujemo u ovu
	 */
	public ArrayIndexedCollection(Collection collection) {
		this(collection, INITIALCAPACITY);
	}

	/**
	 * Metoda vraća veličinu kolekcije
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Metoda dodaje element u kolekciju Prosječna kompleksnost je O(n)
	 * 
	 * @param value - element koji se dodaje u kolekciju
	 * @throws NullPointerException ako je element null
	 */
	@Override
	public void add(Object value) {
		if (value == null) {
			throw new NullPointerException();
		}
		if (size() == elements.length) {
			this.capacity = elements.length * 2;
			elements = Arrays.copyOf(elements, elements.length * 2);
		}
		for (int i = 0; i < elements.length; i++) {
			if (elements[i] == null) {
				elements[i] = value;
				this.size++;
				return;
			}
		}
	}

	/**
	 * Metoda vraća true ako element postoji u kolekciji, a false ako ne postoji
	 * 
	 * @param value - element čije postojanje u kolekciji provjeravamo
	 * @return true ako element postoji u kolekciji, false ako ne postoji
	 */
	@Override
	public boolean contains(Object value) {
		if (value == null) {
			return false;
		}
		for (int i = 0; i < size(); i++) {
			if (elements[i].equals(value)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Metoda briše element iz kolekcije, te vraća true ako je element uspješno
	 * izbrisan, a false ako nije
	 * 
	 * @param value - element koji se briše
	 * @return true ako je element uspješno izbrisan, a false ako nije
	 */
	@Override
	public boolean remove(Object value) {
		if (indexOf(value) == -1) {
			return false;
		}
		remove(indexOf(value));
		return true;
	}

	/**
	 * Metoda briše element pod zadanim indeksom
	 * 
	 * @param index - indeks pod kojim brišemo element
	 * @throws IndexOutOfBoundsException ako je indeks veći od veličine liste, ili
	 *                                   manji od 0
	 */
	public void remove(int index) {
		if (index < 0 || index >= this.size()) {
			throw new IndexOutOfBoundsException();
		}
		for (int j = index; j < this.size() - 1; j++) {
			elements[j] = elements[j + 1];
		}
		elements[this.size() - 1] = null;
		size--;
	}

	/**
	 * Metoda vraća kolekciju u obliku polja
	 * 
	 * @return elemente kolekcije u obliku polja
	 * @throws UnsupportedOperationException ako je veličina kolekcije 0
	 */
	@Override
	public Object[] toArray() {
		if (size() == 0) {
			throw new UnsupportedOperationException();
		}
		if (size() != elements.length) {
			elements = Arrays.copyOf(elements, size());
		}
		return elements;
	}

	/**
	 * Metoda za svaki element odrađuje određeni posao definiran metodom process iz
	 * pomoćne strukture Processor
	 * 
	 * @param processor - objekt čijom metodom process odrađujemo određeni posao nad
	 *                  svakim elementom kolekcije
	 */
	@Override
	public void forEach(Processor processor) {
		for (int i = 0; i < size(); i++) {
			if (elements[i] != null) {
				processor.process(elements[i]);
			}
		}
	}

	/**
	 * Metoda vraća element pod zadanim indeksom Prosječna kompleksnost je O(1)
	 * 
	 * @param index - indeks pod kojim vraća element
	 * @return element pod predanim indeksom
	 * @throws IndexOutOfBounds ako je indeks veći od veličine kolekcije ili manji
	 *                          od 0
	 */
	public Object get(int index) {
		if (index < 0 || index > this.size() - 1) {
			throw new IndexOutOfBoundsException();
		}
		return elements[index];
	}

	/**
	 * Metoda briše sve elemente iz kolekcije
	 */
	public void clear() {
		for (int i = 0; i < this.size(); i++) {
			elements[i] = null;
		}
		this.size = 0;
	}

	/**
	 * Metoda ubacuje element na zadanu poziciju, te ostale elemente pomiče udesno
	 * Prosječna kompleksnost je O(n)
	 * 
	 * @param value    - element koji ubacuje
	 * @param position - pozicija se ubacuje element
	 * @throws NullPointerException      ako je element null
	 * @throws IndexOutOfBoundsException ako je indeks veći od veličine kolekcije
	 *                                   ili manji od 0
	 */
	public void insert(Object value, int position) {
		if (value == null) {
			throw new NullPointerException();
		}
		if (position < 0 || position > size()) {
			throw new IndexOutOfBoundsException();
		}
		if (size() == elements.length) {
			elements = Arrays.copyOf(elements, elements.length * 2);
		}
		if (position == size()) {
			add(value);
		}
		Object pom = elements[position];
		Object pom2;
		elements[position] = value;
		size++;
		for (int i = position + 1; i < this.size(); i++) {
			pom2 = elements[i];
			elements[i] = pom;
			pom = pom2;
		}
	}

	/**
	 * Metoda vraća indeks od prvog pojavljanja zadanog elementa Prosječna
	 * kompleksnost je O(n)
	 * 
	 * @param value - element čiji se indeks traži
	 * @return indeks predanog elementa
	 */
	public int indexOf(Object value) {
		if (value == null) {
			return -1;
		}
		for (int i = 0; i < this.size(); i++) {
			if (elements[i].equals(value)) {
				return i;
			}
		}
		return -1;
	}

}
