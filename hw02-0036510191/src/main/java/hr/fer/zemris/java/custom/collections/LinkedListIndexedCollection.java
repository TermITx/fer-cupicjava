package hr.fer.zemris.java.custom.collections;

/**
 * Klasa koja implementira kolekcije s povezanim listama
 * 
 * @author Karlo
 *
 */
public class LinkedListIndexedCollection extends Collection {

	/**
	 * Pomoćna struktura čvora povezane liste
	 * 
	 * @author Karlo
	 *
	 */
	private static class ListNode {
		ListNode previous;
		ListNode next;
		Object value;
	}

	private ListNode first;
	private ListNode last;
	private int size;

	/**
	 * Konstruktor koji inicijalizira first i last na null, a value na 0
	 */
	public LinkedListIndexedCollection() {
		this.first = null;
		this.last = null;
		this.size = 0;
	}

	/**
	 * Konstruktor koji sve elemente predane kolekcije dodaje ovoj kolekciji
	 * 
	 * @param collection - kolekcija čiji se elementi dodaju ovoj kolekciji
	 * @throws NullPointerException ako je predana kolekcija null
	 */
	public LinkedListIndexedCollection(Collection collection) {
		if (collection == null) {
			throw new NullPointerException();
		}
		this.addAll(collection);
	}

	/**
	 * Metoda vraća true ako je kolekcija prazna, a false ako nije
	 */
	@Override
	public boolean isEmpty() {
		if (this.size() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Metoda vraća veličinu kolekcije
	 */
	@Override
	public int size() {
		return this.size;
	}

	/**
	 * Metoda dodaje element u kolekciju
	 * 
	 * @param value - element koji se dodaje u kolekciju
	 * @throw NullPointerException ako je value null
	 */
	@Override
	public void add(Object value) {
		if (value == null) {
			throw new NullPointerException();
		}
		if (size() == 0) {
			first = new ListNode();
			first.value = value;
			last = first;
			size++;
			return;
		}
		ListNode pom = new ListNode();
		last.next = pom;
		pom.previous = last;
		last = last.next;
		last.value = value;
		size++;
	}

	/**
	 * Metoda vraća true ako je element sadržan, a false ako nije
	 * 
	 * @param value - element za koji provjeravamo je li sadržan
	 * @return true ako je element sadržan, false ako nije
	 */
	@Override
	public boolean contains(Object value) {
		ListNode node = first;
		for (int i = 0; i < size(); i++) {
			if (node.value.equals(value)) {
				return true;
			}
			node = node.next;
		}
		return false;
	}

	/**
	 * Metoda briše predani element iz liste, te vraća true ako je uspješno obrisan,
	 * a false ako nije
	 * 
	 * @param value - element koji se briše
	 * @return true ako je izbrisan element, false ako nije
	 * @throw NullPointerException ako je value null
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
	 * Metoda briše element iz liste zadan indeksom
	 * 
	 * @param index - indeks pod kojim se briše element
	 * @throws IllegalArgumentException ako je indeks manji od 0 ili veći od
	 *                                  veličine kolekcije
	 */
	public void remove(int index) {
		if (index < 0 || index > size() - 1) {
			throw new IllegalArgumentException();
		}
		ListNode pom = first;
		for (int i = 0; i < size() - 1; i++) {
			if (i == index) {
				if (pom == first) {
					pom.value = null;
					first = pom.next;
					size--;
					return;
				} else if (pom.next == null) {
					pom.previous.next = null;
					pom = null;
					size--;
					return;
				}
				pom.previous.next = pom.next;
				pom.next.previous = pom.previous;
				pom = null;
				size--;
				return;
			}
			pom = pom.next;
		}
	}

	/**
	 * Metoda vraća prikaz kolekije u polju
	 * 
	 * @return polje koje sadrzi elemente kolekcije
	 */
	@Override
	public Object[] toArray() {
		if (size() == 0) {
			throw new UnsupportedOperationException();
		}
		Object[] array = new Object[size()];
		ListNode node = first;
		for (int i = 0; i < size(); i++) {
			array[i] = node.value;
			node = node.next;
		}
		return array;
	}

	/**
	 * Metoda za svaki element u kolekciji poziva metodu process iz klase Processor
	 * 
	 * @param processor - objekt čijom metodom process obrađujemo svaki element
	 *                  kolekcije
	 */
	@Override
	public void forEach(Processor processor) {
		ListNode node = this.first;
		for (int i = 0; i < size(); i++) {
			if (node.value != null) {
				processor.process(node.value);
			}
			node = node.next;
		}
	}

	/**
	 * Metoda vraća element iz kolekcije pod zadanim indeksom
	 * 
	 * @param index - indeks s kojeg vraća element
	 * @return element pod zadanim indeksom
	 * @throws IndexOutOfBounds ako je zadani indeks manji od nula ili veći od
	 *                          veličine kolekcije
	 */
	public Object get(int index) {
		if (index < 0 || index > size() - 1) {
			throw new IndexOutOfBoundsException();
		}
		ListNode node;
		if (index > size() / 2) {
			node = last;
			for (int i = size() - 1; i > index; i--) {
				node = node.previous;
			}
			return node.value;
		}
		node = first;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node.value;
	}

	/**
	 * Metoda briše kolekciju
	 */
	public void clear() {
		first = last = null;
		size = 0;
	}

	/**
	 * Metoda ubacuje element na određenu poziciju, te ostale elemente pomiče udesno
	 * Prosječna kompleksnost je O(n)
	 * 
	 * @param value    - element koji se ubacuje
	 * @param position - pozicija na koje se ubacuje element
	 * @throws NullPointerException ako je value null
	 */
	public void insert(Object value, int position) {
		if (value == null) {
			throw new NullPointerException();
		}
		ListNode pom;
		if (position == 0) {
			pom = new ListNode();
			pom.value = value;
			pom.next = first;
			first.previous = pom;
			first = pom;
			size++;
			return;
		} else if (position == size()) {
			add(value);
			return;
		}
		pom = first;
		ListNode pom2;
		for (int i = 1; i < size(); i++) {
			if (i == position) {
				pom2 = new ListNode();
				pom2.value = value;
				pom2.next = pom.next;
				pom2.previous = pom;
				pom.next = pom2;
				size++;
				return;
			}
			pom = pom.next;
		}
	}

	/**
	 * Metoda vraća indeks zadanog elementa Prosječna kompleksnost je O(n)
	 * 
	 * @param value - element čiji indeks se vraća
	 * @return - indeks zadanog elementa
	 * @throws NullPointerException ako je value null
	 */
	public int indexOf(Object value) {
		if (value == null) {
			throw new NullPointerException();
		}
		ListNode node = first;
		for (int i = 0; i < size(); i++) {
			if (node.value.equals(value)) {
				return i;
			}
			node = node.next;
		}
		return -1;
	}
}
