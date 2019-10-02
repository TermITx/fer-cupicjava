package hr.fer.zemris.java.custom.scripting.exec;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ObjectMultistackTest {

	@Test
	void testPush() {
		ObjectMultistack stack = new ObjectMultistack();
		stack.push("stack", new ValueWrapper(1));
		stack.push("stack2", new ValueWrapper(1));
		stack.push("stack3", new ValueWrapper(1));
		
		assertTrue(stack.getMap().containsKey("stack"));
		assertTrue(stack.getMap().containsKey("stack3"));
		assertTrue(stack.getMap().containsKey("stack2"));
	}
	@Test
	void testPop() {
		ObjectMultistack stack = new ObjectMultistack();
		stack.push("stack", new ValueWrapper(1));
		stack.push("stack2", new ValueWrapper(1));
		stack.push("stack3", new ValueWrapper(1));
		
		stack.pop("stack");
		stack.pop("stack3");
		assertTrue(stack.isEmpty("stack"));
		assertTrue(stack.isEmpty("stack3"));
		assertFalse(stack.isEmpty("stack2"));
	}
	@Test
	void testPeek() {
		ObjectMultistack stack = new ObjectMultistack();
		stack.push("stack", new ValueWrapper(1));
		stack.push("stack2", new ValueWrapper(1));
		stack.push("stack3", new ValueWrapper(1));
		
		stack.peek("stack");
		stack.peek("stack3");
		assertTrue(stack.getMap().containsKey("stack"));
		
		assertFalse(stack.isEmpty("stack"));
		assertFalse(stack.isEmpty("stack3"));
		assertFalse(stack.isEmpty("stack2"));
	}
	
	@Test
	void testIsEmpty() {
		ObjectMultistack stack = new ObjectMultistack();
		stack.push("stack", new ValueWrapper(1));
		stack.push("stack2", new ValueWrapper(1));
		stack.push("stack3", new ValueWrapper(1));
		
		stack.pop("stack");
		stack.pop("stack2");
		stack.pop("stack3");
		assertTrue(stack.isEmpty("stack"));
		assertTrue(stack.isEmpty("stack3"));
		assertTrue(stack.isEmpty("stack2"));
	}
}
