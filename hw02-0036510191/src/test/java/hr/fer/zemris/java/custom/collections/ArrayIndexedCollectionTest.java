package hr.fer.zemris.java.custom.collections;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayIndexedCollectionTest {

	@Test
	void testFirstKonstruktorLessThanZero() {
		try {
			new ArrayIndexedCollection(-1);
			fail();
		}catch(IllegalArgumentException e) {}
	}
	@Test
	void testFirstKonstruktorNormal() {
		ArrayIndexedCollection probna = new ArrayIndexedCollection(5);
		assertEquals(probna.capacity,5);
	}
	@Test 
	void testSecondKonstruktorNullCollection(){
		try {
			new ArrayIndexedCollection(null,5);
			fail();
		}catch(NullPointerException e) {}
	}	
	@Test
	void testSecondKonstruktorCapacityLessThanCollectionSize(){
			ArrayIndexedCollection probna1 = new ArrayIndexedCollection();
			probna1.add(2);
			probna1.add(3);
			probna1.add(4);
			ArrayIndexedCollection probna = new ArrayIndexedCollection(probna1,2);
			assertEquals(probna.size(),3);
	}
	void testSecondKonstruktorNormal(){
		ArrayIndexedCollection probna1 = new ArrayIndexedCollection();
		probna1.add(2);
		probna1.add(3);
		probna1.add(4);
		ArrayIndexedCollection probna = new ArrayIndexedCollection(probna1,3);
		System.out.println(probna1.toString());
		System.out.println(probna.toString());
		assertEquals(probna.toArray(),probna1.toArray());
}
	@Test 
	void testThirdKonstruktorNull(){
		try {
			new ArrayIndexedCollection(null);
			fail();
		}catch(NullPointerException e) {}
	}	
	@Test
	void testFourthKonstruktorEmpty() {
		ArrayIndexedCollection probna = new ArrayIndexedCollection();
		assertEquals(probna.capacity,16);
	}
	@Test
	void testIsEmptyTrue() {
		assertThrows(IllegalArgumentException.class,() -> new ArrayIndexedCollection(0));
	}
	@Test
	void testIsEmptyFalse() {
		ArrayIndexedCollection probna = new ArrayIndexedCollection();
		probna.add("Element");
		assertFalse(probna.isEmpty());
	}
	@Test
	void testSize() {
		ArrayIndexedCollection probna = new ArrayIndexedCollection();
		probna.add("Element");
		assertEquals(probna.size(),1);
	}
	@Test
	void testAddNull() {
		ArrayIndexedCollection probna = new ArrayIndexedCollection();
		try{
			probna.add(null);
			fail();
		}catch(NullPointerException e) {}
	}
	@Test
	void testAddMoreThanCapacity() {
		ArrayIndexedCollection probna = new ArrayIndexedCollection(2);
		probna.add("Element");
		probna.add("Element1");
		System.out.println(probna.size());
		probna.add("Element2");
		System.out.println(probna.capacity);
		assertEquals(probna.capacity,4);
		assertEquals(probna.get(2),"Element2");
	}
	@Test
	void testAddNormal() {
		ArrayIndexedCollection probna = new ArrayIndexedCollection();
		probna.add("Element");
		assertEquals(probna.get(0),"Element");
	}
	@Test
	void testContainsNull() {
		ArrayIndexedCollection probna = new ArrayIndexedCollection();
		probna.add("Element");
		assertFalse(probna.contains(null));
	}
	@Test
	void testContainsTrue() {
		ArrayIndexedCollection probna = new ArrayIndexedCollection();
		probna.add("Element");
		assertTrue(probna.contains("Element"));
	}
	@Test
	void testContainsFalse() {
		ArrayIndexedCollection probna = new ArrayIndexedCollection();
		probna.add("Element");
		assertFalse(probna.contains("Element2"));
	}
	@Test
	void testRemoveByValueNull() {
		ArrayIndexedCollection probna = new ArrayIndexedCollection();
		probna.add("Element");
		assertFalse(probna.remove(null));
	}
	@Test
	void testRemoveByValueTrue() {
		ArrayIndexedCollection probna = new ArrayIndexedCollection();
		probna.add("Element");
		probna.remove("Element");
		assertFalse(probna.contains("Element"));
	}
	@Test
	void testRemoveByValueFalse() {
		ArrayIndexedCollection probna = new ArrayIndexedCollection();
		probna.add("Element");
		assertFalse(probna.remove("Elements1"));
	}
	@Test
	void testRemoveByIndexOutOfBoundsHigher() {
		ArrayIndexedCollection probna = new ArrayIndexedCollection();
		probna.add("Element");
		try {
			probna.remove(1);
			fail();
		}catch(IndexOutOfBoundsException e) {}
	}
	@Test
	void testRemoveByIndexOutOfBoundsLower() {
		ArrayIndexedCollection probna = new ArrayIndexedCollection();
		probna.add("Element");
		try {
			probna.remove(-1);
			fail();
		}catch(IndexOutOfBoundsException e) {}
	}
	@Test
	void testRemoveNormal() {
		ArrayIndexedCollection probna = new ArrayIndexedCollection();
		probna.add("Element");
		probna.remove(0);
		assertFalse(probna.contains("Element"));
	}
	@Test
	void testToArrayZeroSize() {
		ArrayIndexedCollection probna = new ArrayIndexedCollection();
		try {
			probna.toArray();
			fail();
		}catch(UnsupportedOperationException e) {}
	}
	@Test
	void testToArrayNormal() {
		ArrayIndexedCollection probna = new ArrayIndexedCollection(2);
		probna.add("Element1");
		probna.add("Element2");
		Object[] prva = {"Element1","Element2"};
		Object[] druga = probna.toArray();
		assertArrayEquals(prva,druga);
	}
	@Test
	void testGetIndexOutOfBoundsHigher() {
		ArrayIndexedCollection probna = new ArrayIndexedCollection(1);
		probna.add("Element1");
		try{
			probna.get(2);
			fail();
		}catch(IndexOutOfBoundsException e) {}
	}
	@Test
	void testGetIndexOutOfBoundsLower() {
		ArrayIndexedCollection probna = new ArrayIndexedCollection(1);
		probna.add("Element1");
		try{
			probna.get(-1);
			fail();
		}catch(IndexOutOfBoundsException e) {}
	}
	@Test
	void testGetNormal() {
		ArrayIndexedCollection probna = new ArrayIndexedCollection(1);
		probna.add("Element1");
		assertEquals(probna.get(0),"Element1");
	}
	@Test
	void testClear() {
		ArrayIndexedCollection probna = new ArrayIndexedCollection(1);
		probna.add("Element1");
		probna.clear();
		assertTrue(probna.size()==0);
	}
	@Test
	void testInsertIndexOutOfBoundsHigher() {
		ArrayIndexedCollection probna = new ArrayIndexedCollection(1);
		probna.add("Element1");
		try {
			probna.insert("Inserted", 2);
			fail();
		}catch(IndexOutOfBoundsException e) {}
	}
	@Test
	void testInsertIndexOutOfBoundsLower() {
		ArrayIndexedCollection probna = new ArrayIndexedCollection(1);
		probna.add("Element1");
		try {
			probna.insert("Inserted", -1);
			fail();
		}catch(IndexOutOfBoundsException e) {}
	}
	@Test
	void testInsertNullValue() {
		ArrayIndexedCollection probna = new ArrayIndexedCollection(2);
		probna.add("Element1");
		try {
			probna.insert(null, 1);
			fail();
		}catch(NullPointerException e) {}
	}
	@Test
	void testInsertNormal() {
		ArrayIndexedCollection probna = new ArrayIndexedCollection(4);
		probna.add("Element1");
		probna.add("Element2");
		probna.add("Element3");
		probna.insert("Inserted", 1);
		assertEquals(probna.get(1),"Inserted");
	}
	@Test
	void testIndexOfNull() {
		ArrayIndexedCollection probna = new ArrayIndexedCollection();
		probna.add("Element1");
		try {
			probna.indexOf(null);
		}catch(NullPointerException e) {}
	}
	@Test
	void testIndexOfNotInArray() {
		ArrayIndexedCollection probna = new ArrayIndexedCollection();
		probna.add("Element1");
		assertEquals(probna.indexOf("Element2"),-1);
	}
	@Test
	void testIndexOfNormal() {
		ArrayIndexedCollection probna = new ArrayIndexedCollection();
		probna.add("Element1");
		probna.add("Element2");
		assertEquals(probna.indexOf("Element2"),1);
	}
	@Test
	void testIndexOfNormalSameElements() {
		ArrayIndexedCollection probna = new ArrayIndexedCollection();
		probna.add("Element1");
		probna.add("Element1");
		assertEquals(probna.indexOf("Element1"),0);
	}
	@Test
	void testAddAllNull() {
		ArrayIndexedCollection probna = new ArrayIndexedCollection();
		probna.add("Prvi");
		try {
			probna.addAll(null);
		}catch(NullPointerException e) {}
	}
	@Test
	void testAddAllNormal() {
		ArrayIndexedCollection probna = new ArrayIndexedCollection();
		ArrayIndexedCollection probna2 = new ArrayIndexedCollection();
		probna.add("Element1");
		probna.add("Element2");
		probna.add("Element3");
		probna2.add("Prvi");
		probna2.addAll(probna);
		assertTrue(probna2.size()==4);
		assertTrue(probna2.contains("Element2"));
		assertEquals(probna2.get(1),"Element1");
	}
	@Test
	void testForEach() {
		ArrayIndexedCollection probna = new ArrayIndexedCollection();
		probna.add(1);
		probna.add(2);
		class AddProcessor extends Processor{
			public ArrayIndexedCollection probna2 = new ArrayIndexedCollection();
			@Override
			public void process(Object value) {
				probna2.add(value);
			}
		}
		AddProcessor processor = new AddProcessor();
		probna.forEach(processor);
		assertArrayEquals(probna.toArray(),processor.probna2.toArray());
	}
}
