package hr.fer.zemris.java.custom.collections;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class LinkedListIndexedCollectionTest {

	@Test
	void testFirstKonstruktor() {
		LinkedListIndexedCollection probna = new LinkedListIndexedCollection();
		assertTrue(probna.size() == 0);
	}

	@Test
	void testSecondKonstruktorNullCollection() {
		try {
			new LinkedListIndexedCollection(null);
			fail();
		} catch (NullPointerException e) {
		}
	}

	@Test
	void testSecondtKonstruktorNormal() {
		LinkedListIndexedCollection probna1 = new LinkedListIndexedCollection();
		probna1.add(2);
		probna1.add(3);
		probna1.add(4);
		LinkedListIndexedCollection probna = new LinkedListIndexedCollection(probna1);
		assertArrayEquals(probna.toArray(), probna1.toArray());
	}

	@Test
	void testIsEmptyTrue() {
		assertTrue(new LinkedListIndexedCollection().isEmpty());
	}

	@Test
	void testIsEmptyFalse() {
		LinkedListIndexedCollection probna = new LinkedListIndexedCollection();
		probna.add("Element");
		assertFalse(probna.isEmpty());
	}

	@Test
	void testSize() {
		LinkedListIndexedCollection probna = new LinkedListIndexedCollection();
		probna.add("Element");
		assertEquals(probna.size(), 1);
	}

	@Test
	void testAddNull() {
		LinkedListIndexedCollection probna = new LinkedListIndexedCollection();
		try {
			probna.add(null);
			fail();
		} catch (NullPointerException e) {
		}
	}

	@Test
	void testAddNormal() {
		LinkedListIndexedCollection probna = new LinkedListIndexedCollection();
		probna.add("Element");
		probna.add("Element2");
		assertEquals(probna.get(0), "Element");
	}

	@Test
	void testContainsNull() {
		LinkedListIndexedCollection probna = new LinkedListIndexedCollection();
		probna.add("Element");
		assertFalse(probna.contains(null));
	}

	@Test
	void testContainsTrue() {
		LinkedListIndexedCollection probna = new LinkedListIndexedCollection();
		probna.add("Element");
		assertTrue(probna.contains("Element"));
	}

	@Test
	void testContainsFalse() {
		LinkedListIndexedCollection probna = new LinkedListIndexedCollection();
		probna.add("Element");
		assertFalse(probna.contains("Element2"));
	}

	@Test
	void testRemoveByValueNull() {
		LinkedListIndexedCollection probna = new LinkedListIndexedCollection();
		probna.add("Element");
		try {
			probna.remove(null);
			fail();
		} catch (NullPointerException e) {
		}
	}

	@Test
	void testRemoveByValueTrue() {
		LinkedListIndexedCollection probna = new LinkedListIndexedCollection();
		probna.add("Element");
		probna.add("Elemen2");
		probna.add("Element3");
		probna.remove("Elemen2");
		assertFalse(probna.contains("Elemen2"));
	}

	@Test
	void testRemoveByValueFalse() {
		LinkedListIndexedCollection probna = new LinkedListIndexedCollection();
		probna.add("Element");
		assertFalse(probna.remove("Elements1"));
	}

	@Test
	void testRemoveByIndexTrue() {
		LinkedListIndexedCollection probna = new LinkedListIndexedCollection();
		probna.add("Element");
		probna.add("Elemen2");
		probna.add("Element3");
		probna.remove(1);
		assertFalse(probna.contains("Elemen2"));
	}

	@Test
	void testRemoveByIndexOutOfBounds() {
		LinkedListIndexedCollection probna = new LinkedListIndexedCollection();
		probna.add("Element");
		try {
			probna.remove(1);
			fail();
		} catch (IllegalArgumentException e) {
		}
	}

	@Test
	void testToArrayZeroSize() {
		LinkedListIndexedCollection probna = new LinkedListIndexedCollection();
		try {
			probna.toArray();
			fail();
		} catch (UnsupportedOperationException e) {
		}
	}

	@Test
	void testToArrayNormal() {
		LinkedListIndexedCollection probna = new LinkedListIndexedCollection();
		probna.add("Element1");
		probna.add("Element2");
		Object[] prva = { "Element1", "Element2" };
		Object[] druga = probna.toArray();
		assertArrayEquals(prva, druga);
	}

	@Test
	void testGetIndexOutOfBoundsHigher() {
		LinkedListIndexedCollection probna = new LinkedListIndexedCollection();
		probna.add("Element1");
		try {
			probna.get(2);
			fail();
		} catch (IndexOutOfBoundsException e) {
		}
	}

	@Test
	void testGetIndexOutOfBoundsLower() {
		LinkedListIndexedCollection probna = new LinkedListIndexedCollection();
		probna.add("Element1");
		try {
			probna.get(-1);
			fail();
		} catch (IndexOutOfBoundsException e) {
		}
	}

	@Test
	void testGetNormal() {
		LinkedListIndexedCollection probna = new LinkedListIndexedCollection();
		probna.add("Element1");
		probna.add("Element2");
		assertEquals(probna.get(0), "Element1");
	}

	@Test
	void testClear() {
		LinkedListIndexedCollection probna = new LinkedListIndexedCollection();
		probna.add("Element1");
		probna.add("Element2");
		probna.add("Elemente");
		probna.clear();
		assertFalse(probna.contains("Element2"));
		assertTrue(probna.size() == 0);
	}

	@Test
	void testInsertNullValue() {
		LinkedListIndexedCollection probna = new LinkedListIndexedCollection();
		probna.add("Element1");
		try {
			probna.insert(null, 1);
			fail();
		} catch (NullPointerException e) {
		}
	}

	@Test
	void testInsertNormal() {
		LinkedListIndexedCollection probna = new LinkedListIndexedCollection();
		probna.add("Element1");
		probna.add("Element2");
		probna.add("Element3");
		probna.insert("Inserted", 1);
		assertEquals(probna.get(1), "Inserted");
		assertEquals(probna.get(0), "Element1");
		assertEquals(probna.get(2), "Element2");
	}

	@Test
	void testIndexOfNull() {
		LinkedListIndexedCollection probna = new LinkedListIndexedCollection();
		probna.add("Element1");
		try {
			probna.indexOf(null);
		} catch (NullPointerException e) {
		}
	}

	@Test
	void testIndexOfNotInArray() {
		LinkedListIndexedCollection probna = new LinkedListIndexedCollection();
		probna.add("Element1");
		assertEquals(probna.indexOf("Element2"), -1);
	}

	@Test
	void testIndexOfNormal() {
		LinkedListIndexedCollection probna = new LinkedListIndexedCollection();
		probna.add("Element1");
		probna.add("Element2");
		assertEquals(probna.indexOf("Element1"), 0);
		assertEquals(probna.indexOf("Element2"), 1);
	}

	@Test
	void testIndexOfNormalSameElements() {
		LinkedListIndexedCollection probna = new LinkedListIndexedCollection();
		probna.add("Element1");
		probna.add("Element1");
		assertEquals(probna.indexOf("Element1"), 0);
	}

	@Test
	void testAddAllNull() {
		LinkedListIndexedCollection probna = new LinkedListIndexedCollection();
		probna.add("Prvi");
		try {
			probna.addAll(null);
		} catch (NullPointerException e) {
		}
	}

	@Test
	void testAddAllNormal() {
		LinkedListIndexedCollection probna = new LinkedListIndexedCollection();
		LinkedListIndexedCollection probna2 = new LinkedListIndexedCollection();
		probna.add("Element1");
		probna.add("Element2");
		probna.add("Element3");
		probna2.add("Prvi");
		probna2.addAll(probna);
		assertTrue(probna2.size() == 4);
		assertTrue(probna2.contains("Element2"));
		assertEquals(probna2.get(1), "Element1");
	}

	@Test
	void testForEach() {
		LinkedListIndexedCollection probna = new LinkedListIndexedCollection();
		probna.add(1);
		probna.add(2);
		class AddProcessor extends Processor {
			public LinkedListIndexedCollection probna2 = new LinkedListIndexedCollection();

			@Override
			public void process(Object value) {
				probna2.add(value);
			}
		}
		AddProcessor processor = new AddProcessor();
		probna.forEach(processor);
		assertArrayEquals(probna.toArray(), processor.probna2.toArray());
	}

	@Test
	void testInsertFirst() {
		LinkedListIndexedCollection probna = new LinkedListIndexedCollection();
		probna.add("Element1");
		probna.add("Element2");
		probna.add("Element3");
		probna.insert("Inserted", 0);
		assertEquals(probna.get(0), "Inserted");
		assertEquals(probna.get(1), "Element1");
		assertEquals(probna.get(2), "Element2");
		assertEquals(probna.get(3), "Element3");

	}

	@Test
	void testInsertLast() {
		LinkedListIndexedCollection probna = new LinkedListIndexedCollection();
		probna.add("Element1");
		probna.add("Element2");
		probna.add("Element3");
		probna.insert("Inserted", 3);
		assertEquals(probna.get(3), "Inserted");
		assertEquals(probna.get(0), "Element1");
		assertEquals(probna.get(1), "Element2");
		assertEquals(probna.get(2), "Element3");

	}
}
