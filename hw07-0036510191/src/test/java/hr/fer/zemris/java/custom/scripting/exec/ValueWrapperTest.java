package hr.fer.zemris.java.custom.scripting.exec;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValueWrapperTest {

	@Test
	void testGetValue() {
		ValueWrapper value = new ValueWrapper(1);
		assertEquals(value.getValue(),1);
	}
	
	@Test
	void testAdd() {
		ValueWrapper value = new ValueWrapper(1);
		ValueWrapper value2 = new ValueWrapper(2);
		value.add(value2.getValue());
		assertEquals(value.getValue(),3);
	}
	@Test
	void testAddNull() {
		ValueWrapper value = new ValueWrapper(1);
		ValueWrapper value2 = new ValueWrapper(null);
		value.add(value2.getValue());
		assertEquals(value.getValue(),1);
	}
	@Test
	void testSub() {
		ValueWrapper value = new ValueWrapper(3);
		ValueWrapper value2 = new ValueWrapper(2);
		value.subtract(value2.getValue());
		assertEquals(value.getValue(),1);
	}
	@Test
	void testMul() {
		ValueWrapper value = new ValueWrapper(3);
		ValueWrapper value2 = new ValueWrapper(2);
		value.multiply(value2.getValue());
		assertEquals(value.getValue(),6);
	}
	@Test
	void testDiv() {
		ValueWrapper value = new ValueWrapper(6);
		ValueWrapper value2 = new ValueWrapper(2);
		value.divide(value2.getValue());
		assertEquals(value.getValue(),3);
	}
	@Test
	void testDivNull() {
		ValueWrapper value = new ValueWrapper(null);
		ValueWrapper value2 = new ValueWrapper(2);
		value.divide(value2.getValue());
		assertEquals(value.getValue(),0);
	}
	@Test
	void testCompareGreater() {
		ValueWrapper value = new ValueWrapper(6);
		ValueWrapper value2 = new ValueWrapper(2);
		assertEquals(value.numCompare(value2.getValue()),1);
	}
	@Test
	void testCompareLesser() {
		ValueWrapper value = new ValueWrapper(2);
		ValueWrapper value2 = new ValueWrapper(3);
		assertEquals(value.numCompare(value2.getValue()),-1);
	}
	@Test
	void testCompareEqual() {
		ValueWrapper value = new ValueWrapper(2);
		ValueWrapper value2 = new ValueWrapper(2);
		assertEquals(value.numCompare(value2.getValue()),0);
	}
}
