package hr.fer.zemris.java.hw01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import hr.fer.zemris.java.hw01.UniqueNumbers.*;

class UniqueNumbersTest {

	@Test
	void testAddNode() {
		TreeNode node = null;
		node = UniqueNumbers.addNode(node,1);
		node = UniqueNumbers.addNode(node,2);
		assertTrue(node.value == 1);
		assertTrue(node.right.value == 2);
		
	}

	@Test
	void testAddNodeSameValue() {
		TreeNode node = null;
		node = UniqueNumbers.addNode(node,1);
		node = UniqueNumbers.addNode(node,1);
		assertEquals(1,UniqueNumbers.treeSize(node));
	}

	@Test
	void testContainsValueTrue() {
		TreeNode node = null;
		node = UniqueNumbers.addNode(node,1);
		assertTrue(UniqueNumbers.containsValue(node,1));
	}

	@Test
	void testContainsValueFalse() {
		TreeNode node = null;
		assertFalse(UniqueNumbers.containsValue(node,1));
	}

	@Test
	void testTreeSize() {
		TreeNode node = null;
		node = UniqueNumbers.addNode(node,1);
		assertEquals(1,UniqueNumbers.treeSize(node));
	}

	@Test
	void testTreeSizeNull() {
		TreeNode node = null;
		assertEquals(0,UniqueNumbers.treeSize(node));
	}

}
