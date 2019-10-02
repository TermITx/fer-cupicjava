package hr.fer.zemris.java.hw02;

/**
 * Klasa koji omogućava podršku za kompleksne brojeve, te implementira osnovne
 * metode za rad s njima
 * 
 * @author Karlo
 *
 */

public class ComplexNumber {
	private static final double PRECISION = Math.pow(10, 8);
	private double real;
	private double imaginary;

	/**
	 * Konstruktor kompleksnog broja sa varijablama realnog i imaginarnog dijela
	 * 
	 * @param real      - realni dio kompleksnog broja
	 * @param imaginary - imaginarni dio kompleksnog broja
	 */
	public ComplexNumber(double real, double imaginary) {
		this.imaginary = imaginary;
		this.real = real;
	}

	/**
	 * Vraća kompleksni broj od realnog
	 * 
	 * @param real - realni dio kompleksnog broja
	 * @return kompleksni broja samo sa realnim dijelom
	 */
	public static ComplexNumber fromReal(double real) {
		return new ComplexNumber(real, 0);
	}

	/**
	 * Vraća kompleksni broj od imaginarnog
	 * 
	 * @param imaginary - imaginarni dio kompleksnog broja
	 * @return kompleksni broja samo sa imaginarnim dijelom
	 */
	public static ComplexNumber fromImaginary(double imaginary) {
		return new ComplexNumber(0, imaginary);
	}

	/**
	 * Vraća kompleksni broj od modula kompleksnog broja i njegovog kuta
	 * 
	 * @param magnitude - modul kompleksnog broja
	 * @param angle     - kut kompleksnog broja
	 * @return standardni zapis kompleksnog broja izračunat iz modula i kuta
	 */
	public static ComplexNumber fromMagnitudeAndAngle(double magnitude, double angle) {
		if (magnitude < 0) {
			throw new IllegalArgumentException("Modul kompleksnog broja mora biti pozitivan");
		}
		return new ComplexNumber(magnitude * Math.cos(angle), magnitude * Math.sin(angle));
	}

	/**
	 * Pomoćna metoda za parse koja radi kompleksni broj iz stringa
	 * 
	 * @param s - string iz kojeg se radi kompleksni broj
	 * @return kompleksni broj koji je napravljen od predanog stringa
	 */
	public static ComplexNumber parseCore(String s) {
		double newReal = 0;
		double newImaginary = 0;
		int i = 0;
		String[] z = s.split("");
		if (!s.endsWith("i")) {
			return new ComplexNumber(Double.parseDouble(s), 0);
		}
		if (s.length() == 1) {
			return new ComplexNumber(0, 1);
		}
		for (int j = 2; j <= s.length(); j++) {
			try {
				Double.parseDouble(s.substring(i, j));
				continue;
			} catch (Exception e) {
			}
			if (z[j - 1].equals(".")) {
				continue;
			}
			if (z[j - 1].equals("i")) {
				if (z[j - 2].equals("+") || z[j - 2].equals("-")) {
					newImaginary = Double.parseDouble(z[j - 2] + "1");
					i = j - 1;
					break;
				}
				newImaginary = Double.parseDouble(s.substring(i, j - 1));
				i = j - 1;
				break;
			}
			newReal = Double.parseDouble(s.substring(i, j - 1));
			i = j - 1;
			continue;
		}
		return new ComplexNumber(newReal, newImaginary);
	}

	/**
	 * Iz stringa vraća kompleksni broj Cijeli posao zapravo odrađuje pomoćna metoda
	 * parseCore, a ova ju samo poziva i baca iznimku ako predani string nije
	 * kompleksni broj
	 * 
	 * @param s - string koji se pretvara u kompleksni broj
	 * @return kompleksni broj iz predanog stringa
	 * @throws NumberFormatException ako nije kompleksni broj
	 */
	public static ComplexNumber parse(String s) {
		try {
			ComplexNumber a = parseCore(s);
			return a;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Predani string nije dobrog formata.");
		}
	}

	/**
	 * Vraća realni dio kompleksnog broja
	 * 
	 * @return realni dio kompleksnog broja
	 */
	public double getReal() {
		return this.real;
	}

	/**
	 * Vraća imaginarni dio kompleksnog broja
	 * 
	 * @return imaginarni dio kompleksnog broja
	 */
	public double getImaginary() {
		return this.imaginary;
	}

	/**
	 * Vraća modul kompleksnog broja
	 * 
	 * @return modul kompleksnog broja
	 */
	public double getMagnitude() {
		return Math.sqrt(Math.pow(getReal(), 2) + Math.pow(getImaginary(), 2));
	}

	/**
	 * Vraća kut kompleksnog broja
	 * 
	 * @return kut kompleksnog broja
	 */
	public double getAngle() {
		double angle = Math.atan2(getImaginary(), getReal());
		if (angle < 0) {
			angle = angle + 2 * Math.PI;
		}
		return angle;

	}

	/**
	 * Zbraja dva kompleksna broja
	 * 
	 * @param c - kompleksni broj koji se zbraja sa ovim
	 * @return zbroj dva kompleksna broja
	 * @throws NullPointerException ako je predani kompleksni broj null
	 */
	public ComplexNumber add(ComplexNumber c) {
		if (c == null) {
			throw new NullPointerException();
		}
		return new ComplexNumber(c.getReal() + this.getReal(), c.getImaginary() + this.getImaginary());
	}

	/**
	 * Oduzima dva kompleksna broja
	 * 
	 * @param c - kompleksni broj koji se oduzima od ovog
	 * @return razliku dva kompleksna broja
	 * @throws NullPointerException ako je predani kompleksni broj null
	 */
	public ComplexNumber sub(ComplexNumber c) {
		if (c == null) {
			throw new NullPointerException();
		}
		return new ComplexNumber(this.getReal() - c.getReal(), this.getImaginary() - c.getImaginary());
	}

	/**
	 * Množi dva kompleksna broja
	 * 
	 * @param c - kompleksni broj koji se množi sa ovim
	 * @return umnožak dva kompleksna broja
	 * @throws NullPointerException ako je predani kompleksni broj null
	 */
	public ComplexNumber mul(ComplexNumber c) {
		if (c == null) {
			throw new NullPointerException();
		}
		double newImaginary = this.getImaginary() * c.getReal() + this.getReal() * c.getImaginary();
		double newReal = this.getReal() * c.getReal() - this.getImaginary() * c.getImaginary();
		return new ComplexNumber(newReal, newImaginary);
	}

	/**
	 * Dijeli dva kompleksna broja
	 * 
	 * @param c - kompleksni broj kojim se dijeli sa ovaj
	 * @return količnik dva kompleksna broja
	 * @throws NullPointerException ako je predani kompleksni broj null
	 */
	public ComplexNumber div(ComplexNumber c) {
		if (c == null) {
			throw new NullPointerException();
		}
		double newAngle = getAngle() - c.getAngle();
		double newMagnitude = getMagnitude() / c.getMagnitude();
		return fromMagnitudeAndAngle(newMagnitude, newAngle);
	}

	/**
	 * Potencira dva kompleksna broja
	 * 
	 * @param n - eksponent
	 * @return potencirani kompleksni broj
	 * @throws NullPointerException     ako je predani kompleksni broj null
	 * @throws IllegalArgumentException ako je eksponent manji od 0
	 */
	public ComplexNumber power(int n) {
		if (n == 0) {
			return new ComplexNumber(1, 0);
		}
		if (n < 0) {
			throw new IllegalArgumentException();
		}
		double newAngle = getAngle() * n;
		double newMagnitude = Math.pow(getMagnitude(), n);
		return fromMagnitudeAndAngle(newMagnitude, newAngle);
	}

	/**
	 * Korjenuje dva kompleksna broja
	 * 
	 * @param n - korijen
	 * @return korijen kompleksnog broja
	 * @throws IllegalArgumentException ako je korijen manji ili jednak 0
	 */
	public ComplexNumber[] root(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException();
		}
		ComplexNumber[] roots = new ComplexNumber[n];
		double newMagnitude = Math.pow(Math.E, Math.log(getMagnitude()) / 2);
		for (int i = 0; i < n; i++) {
			double newAngle = (getAngle() + 2 * i * Math.PI) / n;
			roots[i] = fromMagnitudeAndAngle(newMagnitude, newAngle);
		}
		return roots;
	}

	/**
	 * Vraća String kompleksnog broja
	 * 
	 * @return String kompleksnog broja
	 */
	@Override
	public String toString() {
		if (getReal() != 0.0 && getImaginary() >= 0.0) {
			return getReal() + "+" + getImaginary() + "i";
		} else if (getReal() == 0.0 && getImaginary() != 0.0) {
			return getImaginary() + "i";
		} else if (getReal() != 0.0 && getImaginary() == 0.0) {
			return Double.toString(getReal());
		} else if (getReal() >= 0.0 && getImaginary() >= 0.0) {
			return getReal() + " + " + getImaginary() + "i";
		}
		return getReal() + "" + getImaginary() + "i";
	}

	@Override
	public int hashCode() {
		return ((Double) getReal()).hashCode() * 37 + ((Double) getImaginary()).hashCode();
	}

	@Override
	public boolean equals(Object object) {
		if (object == null || !(object instanceof ComplexNumber)) {
			return false;
		}
		ComplexNumber other = (ComplexNumber) object;
		return (int) (Math.abs(getReal() - other.getReal()) * PRECISION) == 0
				& (int) (Math.abs(getImaginary() - other.getImaginary()) * PRECISION) == 0;
	}
}
