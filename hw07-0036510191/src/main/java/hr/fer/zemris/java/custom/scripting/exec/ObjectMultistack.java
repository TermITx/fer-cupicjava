package hr.fer.zemris.java.custom.scripting.exec;

import java.util.HashMap;
import java.util.Map;

/**
 * Klasa koja nudi implementaciju višestogovnog spremanja objekata
 * 
 * @author Karlo
 *
 */
public class ObjectMultistack {

	/**
	 * Mapa stogova
	 */
	private Map<String, MultistackEntry> internalMap;

	/**
	 * Pomoćna klasa koja na temelju ulančane liste definira jedan stog
	 *
	 */
	private static class MultistackEntry {

		/**
		 * Vrijednost
		 */
		private ValueWrapper value;

		/**
		 * Pokazivač na idući element
		 */
		private MultistackEntry next;

		/**
		 * Konstruktor koji inicijalizira vrijednost i pokazivač na idući element
		 * 
		 * @param value - Vrijednost
		 * @param next  - Pokazivač na idući element
		 */
		public MultistackEntry(ValueWrapper value, MultistackEntry next) {
			this.value = value;
			this.next = next;
		}

		/**
		 * Vraća vrijednost elementa
		 * 
		 * @return vrijednost elementa
		 */
		public Object getValue() {
			return value;
		}

		/**
		 * Vraća pokazivač na idući element
		 * 
		 * @return pokazivač na idući element
		 */
		public MultistackEntry getNext() {
			return next;
		}
	}

	/**
	 * Konstruktor koji stvara mapu stogova
	 */
	public ObjectMultistack() {
		this.internalMap = new HashMap<>();
	}

	/**
	 * Postavlja element na stog čije ime odgovara predanom ključu
	 * 
	 * @param keyName      - ime ključa koji označava na koji stog se stavlja
	 *                     element
	 * @param valueWrapper - vrijednost elementa
	 */
	public void push(String keyName, ValueWrapper valueWrapper) {
		if (!internalMap.containsKey(keyName)) {
			internalMap.put(keyName, new MultistackEntry(valueWrapper, null));
		} else {
			internalMap.put(keyName, new MultistackEntry(valueWrapper, internalMap.get(keyName)));
		}
	}

	/**
	 * Vraća element sa stoga čije ime odgovara predanom ključu
	 * 
	 * @param keyName - ime ključa koji označava sa kojeg stoga se vraća element
	 * @return ValueWrapper - element sa stoga
	 */
	public ValueWrapper pop(String keyName) {
		if (!internalMap.containsKey(keyName)) {
			throw new IllegalArgumentException("No such element");
		}
		ValueWrapper pom;
		pom = internalMap.get(keyName).value;
		internalMap.put(keyName, internalMap.get(keyName).getNext());
		return pom;
	}

	/**
	 * Vraća element (bez brisanja) sa stoga čije ime odgovara predanom ključu
	 * 
	 * @param keyName - ime ključa koji označava sa kojeg stoga se vraća element
	 *                (bez brisanja)
	 * @return ValueWrapper - element sa stoga
	 */
	public ValueWrapper peek(String keyName) {
		if (!internalMap.containsKey(keyName)) {
			throw new IllegalArgumentException("No such element");
		}
		return internalMap.get(keyName).value;
	}

	/**
	 * Vraća je li stog pod imenom predanog ključa prazan
	 * 
	 * @param keyName - ključ pod čijim se imenom provjerava je li taj stog prazan
	 * @return true ako je stog prazan, false ako nije
	 */
	public boolean isEmpty(String keyName) {
		if (!internalMap.containsKey(keyName)) {
			throw new IllegalArgumentException("Key not in map.");
		}
		return internalMap.get(keyName) == null;
	}

	/**
	 * Klasa koja služi za testiranje
	 * 
	 * @return internu mapu
	 */
	public Map<String, MultistackEntry> getMap() {
		return internalMap;
	}
}
