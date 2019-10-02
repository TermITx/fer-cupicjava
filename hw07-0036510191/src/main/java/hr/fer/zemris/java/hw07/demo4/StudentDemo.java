package hr.fer.zemris.java.hw07.demo4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Program koji čita datoteku sa studentima i pretvara ih u objekte
 * StudentRecorda
 * 
 * @author Karlo
 *
 */
public class StudentDemo {
	public static void main(String[] args) {
		List<String> lines = null;
		try {
			lines = Files.readAllLines(Paths.get("src\\main\\resources\\studenti.txt"));
		} catch (IOException e) {
			System.err.println("Can't load file.");
		}

		List<StudentRecord> records = convert(lines);

		System.out.println("Zadatak1");
		System.out.println("=======================================================================");
		System.out.println(vratiBodovaViseOd25(records));

		System.out.println("Zadatak2");
		System.out.println("=======================================================================");
		System.out.println(vratiBrojOdlikasa(records));

		System.out.println("Zadatak3");
		System.out.println("=======================================================================");
		vratiListuOdlikasa(records).forEach(System.out::println);
		;
		System.out.println("Zadatak4");
		System.out.println("=======================================================================");
		vratiSortiranuListuOdlikasa(records).forEach(System.out::println);
		System.out.println("Zadatak5");
		System.out.println("=======================================================================");
		vratiPopisNepolozenih(records).forEach(System.out::println);

		System.out.println("Zadatak6");
		System.out.println("=======================================================================");
		razvrstajStudentePoOcjenama(records).entrySet().forEach((a) -> {
			System.out.println(a.getKey() + ": ");
			a.getValue().forEach((b) -> System.out.println(b.toString()));
		});

		System.out.println("Zadatak7");
		System.out.println("=======================================================================");
		vratiBrojStudenataPoOcjenama(records).entrySet()
				.forEach((a) -> System.out.println(a.getKey() + " = " + a.getValue()));

		System.out.println("Zadatak8");
		System.out.println("=======================================================================");
		razvrstajProlazPad(records).entrySet().forEach((a) -> {
			System.out.println(a.getKey() + ": ");
			a.getValue().forEach((b) -> System.out.println(b.toString()));
		});

	}

	/**
	 * Vraća broj studenata sa više od 25 bodova
	 * 
	 * @param records - lista studenata
	 * @return broj studenata sa više od 25 bodova
	 */
	public static long vratiBodovaViseOd25(List<StudentRecord> records) {
		return records.stream().filter((s) -> (s.getMiBodovi() + s.getZiBodovi() + s.getLabosBodovi()) > 25).count();
	}

	/**
	 * Vraća broj studenata čija je ocjena 5
	 * 
	 * @param records - lista studenata
	 * @return broj studenata čija je ocjena 5
	 */
	public static long vratiBrojOdlikasa(List<StudentRecord> records) {
		return records.stream().filter((s) -> s.getOcjena() == 5).count();
	}

	/**
	 * Vraća listu studenata čija je ocjena 5
	 * 
	 * @param records - lista studenata
	 * @return listu studenata čija je ocjena 5
	 */
	public static List<StudentRecord> vratiListuOdlikasa(List<StudentRecord> records) {
		return records.stream().filter((s) -> s.getOcjena() == 5).collect(Collectors.toList());
	}

	/**
	 * Vraća listu studenata čija je ocjena 5 i sortirani su
	 * 
	 * @param records - lista studenata
	 * @return listu studenata čija je ocjena 5 i sortirani su
	 */
	public static List<StudentRecord> vratiSortiranuListuOdlikasa(List<StudentRecord> records) {
		return records.stream()
				.sorted((s2, s) -> (Double.valueOf(s.getMiBodovi() + s.getZiBodovi() + s.getLabosBodovi()))
						.compareTo(s2.getMiBodovi() + s2.getZiBodovi() + s2.getLabosBodovi()))
				.filter((s) -> s.getOcjena() == 5).collect(Collectors.toList());
	}

	/**
	 * Vraća listu studenata čija je ocjena 1
	 * 
	 * @param records - lista studenata
	 * @return listu studenata čija je ocjena 1
	 */
	public static List<String> vratiPopisNepolozenih(List<StudentRecord> records) {
		return records.stream().filter((s) -> (s.getMiBodovi() + s.getZiBodovi() + s.getLabosBodovi()) < 50)
				.map((s) -> s.getJmbag()).collect(Collectors.toList());
	}

	/**
	 * Vraća mapu čiji je ključ ocjena a vrijednost lista studenata
	 * 
	 * @param records - lista studenata
	 * @return mapu čiji je ključ ocjena a vrijednost lista studenata
	 */
	public static Map<Integer, List<StudentRecord>> razvrstajStudentePoOcjenama(List<StudentRecord> records) {
		return records.stream().collect(Collectors.groupingBy((s) -> s.ocjena));
	}

	/**
	 * Vraća mapu čiji je ključ ocjena a vrijednost broj studenata s tom ocjenom
	 * 
	 * @param records - lista studenata
	 * @return mapu čiji je ključ ocjena a vrijednost broj studenata s tom ocjenom
	 */
	public static Map<Integer, Integer> vratiBrojStudenataPoOcjenama(List<StudentRecord> records) {
		return records.stream()
				.collect(Collectors.toMap((s) -> s.getOcjena(), value -> 1, (k, value) -> Integer.sum(k, 1)));
	}

	/**
	 * Vraća mapu čiji je ključ true (prolaz) ili false (pad) a vrijednost lista
	 * studenata s tim atributom
	 * 
	 * @param records - lista studenata
	 * @return mapu čiji je ključ true (prolaz) ili false (pad) a vrijednost lista
	 *         studenata s tim atributom
	 */
	public static Map<Boolean, List<StudentRecord>> razvrstajProlazPad(List<StudentRecord> records) {
		return records.stream().collect(
				Collectors.partitioningBy((s) -> (s.getMiBodovi() + s.getZiBodovi() + s.getLabosBodovi()) >= 50));
	}

	/**
	 * Pomoćna metoda koja pretvara ulaznu listu u primjerke klase StudentRecord
	 * 
	 * @param lines - ulazna lista
	 * @return lista primjeraka klase StudentRecord
	 */
	private static List<StudentRecord> convert(List<String> lines) {
		List<StudentRecord> list = new ArrayList<>();
		for (String i : lines) {
			list.add(new StudentRecord(i));
		}
		return list;
	}
}
