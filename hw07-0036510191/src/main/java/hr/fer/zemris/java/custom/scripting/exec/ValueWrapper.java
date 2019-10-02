package hr.fer.zemris.java.custom.scripting.exec;

import java.util.function.BiFunction;

/**
 * Klasa koja zamata predani objekt i nudi aritmetičke operacije s njim ako je
 * on broj
 * 
 * @author Karlo
 *
 */
public class ValueWrapper {

	/**
	 * Vrijednost elementa
	 */
	Object value;

	/**
	 * Konstruktor koji inicijalizira vrijednost elementa
	 * 
	 * @param value - vrijednost elementa
	 */
	public ValueWrapper(Object value) {
		this.value = value;
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
	 * Postavlja vrijednost elementa
	 * 
	 * @param value - vrijednost elementa
	 */
	public void setValue(Object value) {
		this.value = value;
	}

	/**
	 * Zbraja trenutni i predani element
	 * 
	 * @param incValue - vrijednost koja se zbraja
	 */
	public void add(Object incValue) {
		setValue(operatation(this.value, incValue, (v1, v2) -> v1 + v2));
	}

	/**
	 * Oduzima trenutni od predanog elementa
	 * 
	 * @param decValue - vrijednost koja se oduzima
	 */
	public void subtract(Object decValue) {
		setValue(operatation(this.value, decValue, (v1, v2) -> v1 - v2));
	}

	/**
	 * Množi trenutni s predanim elementom
	 * 
	 * @param mulValue- vrijednost s kojom se množi
	 */
	public void multiply(Object mulValue) {
		setValue(operatation(this.value, mulValue, (v1, v2) -> v1 * v2));
	}

	/**
	 * Djeli trenutni s predanim elementom
	 * 
	 * @param divValue - vrijednost s kojom se djeli
	 */
	public void divide(Object divValue) {
		setValue(operatation(this.value, divValue, (v1, v2) -> v1 / v2));
	}

	/**
	 * Usporeduje trenutni i predani element
	 * 
	 * @param withValue - predani element s koji se uspoređuje
	 * @return 0 ako su isti, -1 ako je trenutni element manji, 1 ako je predani
	 *         element manji
	 */
	public int numCompare(Object withValue) {
		return Double.compare(Double.parseDouble(whichClass(this.value).toString()),
				Double.parseDouble(whichClass(withValue).toString()));
	}

	private static Object operatation(Object o1, Object o2, BiFunction<Double, Double, Double> function) {
		double result = function.apply(Double.parseDouble(whichClass(o1).toString()),
				Double.parseDouble(whichClass(o2).toString()));
		if (whichClass(o1) instanceof Integer && whichClass(o2) instanceof Integer) {
			return Integer.valueOf((int) result);
		}
		return result;
	}

	/**
	 * Vraća koje je klase element
	 * 
	 * @param o - predani element
	 * @return koje je klase element
	 */
	private static Object whichClass(Object o) {
		if (o == null) {
			return Integer.valueOf(0);
		}
		if (o instanceof String) {
			try {
				if (((String) o).contains(".") || ((String) o).contains("E")) {
					return Double.parseDouble((String) o);
				}
				return Integer.parseInt((String) o);
			} catch (Exception e) {
				throw new RuntimeException("Wrong format in string.");
			}
		} else if (o instanceof Double) {
			return (Double) o;
		} else if (o instanceof Integer) {
			return (Integer) o;
		} else {
			throw new RuntimeException("Wrong!");
		}
	}
}