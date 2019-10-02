package hr.fer.zemris.java.hw02.demo;

import hr.fer.zemris.java.custom.collections.LinkedListIndexedCollection;

public class LinkedListIndexedCollectionDemo {
	public static void main(String[] args) {
		LinkedListIndexedCollection col = new LinkedListIndexedCollection();
		col.add(1);
		col.add(2);
		col.add(3);
		printCollection(col);
		System.out.println("***********************");
		col.insert(0, 0);
		printCollection(col);
		System.out.println("***********************");
		col.insert(4, 4);
		printCollection(col);
		System.out.println("***********************");
		col.insert("inserted", 2);
		printCollection(col);

	}

	public static void printCollection(LinkedListIndexedCollection col) {
		for (int i = 0; i < col.size(); i++) {
			System.out.println(col.get(i));
		}
	}

}
