package hr.fer.zemris.java.hw07.demo4;

import java.util.Objects;

/**
 * Klasa koja predstavlja jedan primjerak studenta
 * 
 * @author Karlo
 *
 */
public class StudentRecord implements Comparable<StudentRecord> {

	String jmbag;
	String prezime;
	String ime;
	double miBodovi;
	double ziBodovi;
	double labosBodovi;
	int ocjena;

	/**
	 * Prima jednu liniju iz datoteke sa studentima
	 * 
	 * @param line
	 */
	public StudentRecord(String line) {
		line = Objects.requireNonNull(line);
		String[] fields = line.split("\\s++");
		jmbag = fields[0].trim();
		prezime = fields[1].trim();
		ime = fields[2].trim();
		miBodovi = Double.parseDouble(fields[3].trim());
		ziBodovi = Double.parseDouble(fields[4].trim());
		labosBodovi = Double.parseDouble(fields[5].trim());
		ocjena = Integer.parseInt(fields[6].trim());
	}

	/**
	 * Vraća JMBAG
	 * 
	 * @return JMBAG
	 */
	public String getJmbag() {
		return jmbag;
	}

	/**
	 * Vraća Prezime
	 * 
	 * @return Prezime
	 */
	public String getPrezime() {
		return prezime;
	}

	/**
	 * Vraća Ime
	 * 
	 * @return Ime
	 */
	public String getIme() {
		return ime;
	}

	/**
	 * Vraća bodove s meduispita
	 * 
	 * @return bodove s meduispita
	 */
	public double getMiBodovi() {
		return miBodovi;
	}

	/**
	 * Vraća bodove sa završnog ispita
	 * 
	 * @return bodove sa završnog ispita
	 */
	public double getZiBodovi() {
		return ziBodovi;
	}

	/**
	 * Vraća bodove s labosa
	 * 
	 * @return bodove s labosa
	 */
	public double getLabosBodovi() {
		return labosBodovi;
	}

	/**
	 * Vraća ocjenu
	 * 
	 * @return ocjenu
	 */
	public int getOcjena() {
		return ocjena;
	}

	/**
	 * Vraća stringovni prikaz primjerka studenta
	 */
	@Override
	public String toString() {
		return "jmbag = " + jmbag + "  prezime = " + prezime + "   ime = " + ime + "   miBodovi = " + miBodovi
				+ "   ziBodovi = " + ziBodovi + "  labosBodovi = " + labosBodovi + "  ocjena = " + ocjena;
	}

	/**
	 * Uspoređuje dva studenta s obzirom na JMBAG
	 */
	@Override
	public int compareTo(StudentRecord o) {
		return this.jmbag.compareTo(o.jmbag);
	}
}
