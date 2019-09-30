package hr.fer.zemris.java.hw01;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testna klasa program Factorial
 * @author Karlo Lochert
 */
import org.junit.jupiter.api.Test;

class FactorialTest {

	@Test
	void testIzracunaj() {
		long a = Factorial.izracunaj(5);
		assertEquals(120,a); 
	}

	@Test
	void testNula() {
		long a = Factorial.izracunaj(0);
		assertEquals(1,a);
	}
	
	@Test
	void testNegativne() {
		try {
			Factorial.izracunaj(-1);
			fail("Nema iznimke!");
		}catch(IllegalArgumentException e){
		}
	}
	

}
