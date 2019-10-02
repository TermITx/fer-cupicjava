package hr.fer.zemris.java.custom.collections;

/**
 * Exception koji se baca prilikom pokušaja uzimanja elementa s praznog stoga
 */

public class EmptyStackException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EmptyStackException() {
		super();
	}

	public EmptyStackException(String s) {
		super(s);
	}
}
