package hr.fer.zemris.java.hw02;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class ComplexNumberTest {

	@Test
	void testKonstruktor() {
		ComplexNumber z = new ComplexNumber(1, 2);
		assertTrue(z.getReal() == 1 && z.getImaginary() == 2);
	}

	@Test
	void testFromReal() {
		ComplexNumber z = ComplexNumber.fromReal(2);
		assertTrue(z.getReal() == 2 && z.getImaginary() == 0);
	}

	@Test
	void testFromImaginary() {
		ComplexNumber z = ComplexNumber.fromImaginary(2);
		assertTrue(z.getReal() == 0 && z.getImaginary() == 2);
	}

	@Test
	void testFromMagnitudeAndAngle() {
		ComplexNumber z = ComplexNumber.fromMagnitudeAndAngle(2.0, Math.PI / 2);
		assertTrue(z.equals(new ComplexNumber(0, 2)));
	}

	@Test
	void testParseZeroReal() {
		ComplexNumber z = new ComplexNumber(0, 1);
		assertTrue(ComplexNumber.parse("0+1i").equals(z));
	}

	@Test
	void testParseNoReal() {
		assertTrue(ComplexNumber.parse("1i").getImaginary() == 1 && ComplexNumber.parse("1i").getReal() == 0);
	}

	@Test
	void testParseNoRealOnlyI() {
		assertTrue(ComplexNumber.parse("i").getImaginary() == 1 && ComplexNumber.parse("-i").getImaginary() == -1);
	}

	@Test
	void testParseNoImaginaryNegativeImaginary() {
		assertTrue(ComplexNumber.parse("-1.1i").getImaginary() == -1.1 && ComplexNumber.parse("-1.1i").getReal() == 0);
	}

	@Test
	void testParseZeroImaginary() {
		ComplexNumber z = new ComplexNumber(1.0, 0.0);
		assertTrue(ComplexNumber.parse("1").equals(z));
	}

	@Test
	void testParseDoubleSign() {
		try {
			ComplexNumber.parse("1+-2i");
		} catch (IllegalArgumentException e) {
		}
	}

	@Test
	void testParseNotComplexNumber() {
		try {
			ComplexNumber.parse("banana");
		} catch (IllegalArgumentException e) {
		}
	}

	@Test
	void testParseNoImaginary() {
		assertTrue(ComplexNumber.parse("1").getImaginary() == 0 && ComplexNumber.parse("1").getReal() == 1);
	}

	@Test
	void testParseNoImaginaryNegativeReal() {
		assertTrue(ComplexNumber.parse("-1.1").getImaginary() == 0 && ComplexNumber.parse("-1.1").getReal() == -1.1);
	}

	@Test
	void testParseNeagitveBoth() {
		assertTrue(ComplexNumber.parse("-1-1i").getImaginary() == -1 && ComplexNumber.parse("-1-1i").getReal() == -1);
	}

	@Test
	void testParsePositiveBoth() {
		assertTrue(ComplexNumber.parse("1+1i").getImaginary() == 1 && ComplexNumber.parse("1+1i").getReal() == 1);
	}

	@Test
	void testGetReal() {
		ComplexNumber z = new ComplexNumber(1, 1);
		assertEquals(z.getReal(), 1);
	}

	@Test
	void testGetImaginary() {
		ComplexNumber z = new ComplexNumber(1, 1);
		assertEquals(z.getImaginary(), 1);
	}

	@Test
	void testGetMagnitudeNegative() {
		ComplexNumber z = new ComplexNumber(0, -4);
		assertEquals(z.getMagnitude(), 4);
	}

	@Test
	void testGetMagnitudeZeroReal() {
		ComplexNumber z = new ComplexNumber(0, 4);
		assertEquals(z.getMagnitude(), 4);
	}

	@Test
	void testGetMagnitudeZeroImaginary() {
		ComplexNumber z = new ComplexNumber(4, 0);
		assertEquals(z.getMagnitude(), 4);
	}

	@Test
	void testGetMagnitude() {
		ComplexNumber z = new ComplexNumber(3, 4);
		assertEquals(z.getMagnitude(), 5);
	}

	@Test
	void testGetAnglePositive() {
		ComplexNumber z = new ComplexNumber(1, 1);
		assertEquals(z.getAngle(), Math.PI / 4);
	}

	@Test
	void testGetAngleNegative() {
		ComplexNumber z = new ComplexNumber(-1, -1);
		assertEquals(z.getAngle(), 5 * Math.PI / 4);
	}

	@Test
	void testGetAngleImaginaryZero() {
		ComplexNumber z = new ComplexNumber(0, 1);
		assertEquals(z.getAngle(), Math.PI / 2);
	}

	@Test
	void testAddNull() {
		try {
			ComplexNumber z = new ComplexNumber(1, 1);
			z.add(null);
			fail();
		} catch (NullPointerException e) {
		}
	}

	@Test
	void testAddNormal() {
		ComplexNumber z = new ComplexNumber(1, 2);
		ComplexNumber z2 = new ComplexNumber(1, 1);
		ComplexNumber z3 = z.add(z2);
		assertTrue(z3.getReal() == 2 && z3.getImaginary() == 3);
	}

	@Test
	void testSubNull() {
		try {
			ComplexNumber z = new ComplexNumber(1, 1);
			z.sub(null);
			fail();
		} catch (NullPointerException e) {
		}
	}

	void testSubNormal() {
		ComplexNumber z = new ComplexNumber(2, 3);
		ComplexNumber z2 = new ComplexNumber(1, 1);
		z.sub(z2);
		assertTrue(z.getReal() == 1 && z.getImaginary() == 2);
	}

	@Test
	void testMulNull() {
		try {
			ComplexNumber z = new ComplexNumber(1, 1);
			z.mul(null);
			fail();
		} catch (NullPointerException e) {
		}
	}

	@Test
	void testMulNormal() {
		ComplexNumber z = new ComplexNumber(1, 2);
		ComplexNumber z2 = new ComplexNumber(2, -3);
		ComplexNumber z3 = z.mul(z2);
		assertEquals(8, z3.getReal());
		assertEquals(1, z3.getImaginary());
	}

	@Test
	void testDivNull() {
		try {
			ComplexNumber z = new ComplexNumber(1, 1);
			z.div(null);
			fail();
		} catch (NullPointerException e) {
		}
	}

	@Test
	void testDivNormal() {
		ComplexNumber z = new ComplexNumber(3, 4);
		ComplexNumber z2 = new ComplexNumber(1, -1);
		ComplexNumber z3 = z.div(z2);
		assertTrue(z3.equals(new ComplexNumber(-0.5, 3.5)));
	}

	@Test
	void testPowerLessThanZero() {
		ComplexNumber z = new ComplexNumber(1, 1);
		try {
			z.power(-1);
			fail();
		} catch (IllegalArgumentException e) {
		}
	}

	@Test
	void testPowerZero() {
		ComplexNumber z = new ComplexNumber(1, 1);
		ComplexNumber z2 = z.power(0);
		assertTrue(z2.getReal() == 1 && z2.getImaginary() == 0);
	}

	@Test
	void testPowerNormal() {
		ComplexNumber z = new ComplexNumber(3, 4);
		ComplexNumber z2 = z.power(2);
		assertTrue(z2.equals(new ComplexNumber(-7, 24)));
	}

	@Test
	void tesrRootLessThanZero() {
		ComplexNumber z = new ComplexNumber(1, 1);
		try {
			z.root(-1);
			fail();
		} catch (IllegalArgumentException e) {
		}
	}

	@Test
	void testRootZero() {
		ComplexNumber z = new ComplexNumber(1, 1);
		try {
			z.root(0);
			fail();
		} catch (IllegalArgumentException e) {
		}
	}

	@Test
	void testRootNormal() {
		ComplexNumber z = new ComplexNumber(4, 0);
		ComplexNumber[] z2 = z.root(2);
		assertTrue(z2[1].equals(new ComplexNumber(-2, 0)));
	}
}
