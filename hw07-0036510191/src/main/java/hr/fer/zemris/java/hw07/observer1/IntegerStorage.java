package hr.fer.zemris.java.hw07.observer1;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasa koja sprema jedan broj tipa integer
 * 
 * @author Karlo
 *
 */
public class IntegerStorage {

	/**
	 * Vrijednost jednog integera
	 */
	private int value;

	/**
	 * Varijabla koja prati je li bilo promjena
	 */
	private boolean changed;

	/**
	 * Varijabla za sinkronizaciju
	 */
	private static Object MUTEX = new Object();

	/**
	 * Lista observera
	 */
	private List<IntegerStorageObserver> observers; // use ArrayList here!!!

	/**
	 * Konstruktor koji inicijalizira početnu vrijenost i stvara instancu liste
	 * observera
	 * 
	 * @param initialValue
	 */
	public IntegerStorage(int initialValue) {
		this.value = initialValue;
		observers = new ArrayList<>();
	}

	/**
	 * Dodaje jedan IntegerStorageObserver u listu Observera
	 * 
	 * @param observer
	 */
	public void addObserver(IntegerStorageObserver observer) {
		synchronized (MUTEX) {
			observers.add(observer);
		}
	}

	/**
	 * Briše jedan IntegerStorageObserver iz liste Observera
	 * 
	 * @param observer
	 */
	public void removeObserver(IntegerStorageObserver observer) {
		synchronized (MUTEX) {
			observers.remove(observer);
		}
	}

	/**
	 * Briše sve IntegerStorageObservere iz liste Observera
	 */
	public void clearObservers() {
		synchronized (MUTEX) {
			observers.clear();
		}
	}

	/**
	 * Vraća vrijednost
	 * 
	 * @return vrijednost
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Postavlja vrijednost i javlja Observeru da je postavljena nova vrijednos
	 * 
	 * @param value - nova vrijednost
	 */
	public void setValue(int value) {
		// Only if new value is different than the current value:
		if (this.value != value) {
			// Update current value
			this.value = value;
			this.changed = true;
			// Notify all registered observers
			List<IntegerStorageObserver> observersHelp = null;
			synchronized (MUTEX) {
				if (!changed) {
					return;
				}

				observersHelp = new ArrayList<>(this.observers);
				this.changed = false;
			}
			if (observers != null) {
				for (IntegerStorageObserver observer : observersHelp) {
					observer.valueChanged(this);
				}
			}
		}
	}
}
