package myJava.tips.partACollections;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class Item4SetCopyOfTest {

	@Test
	void should_have_different_reference_test() {
		// init
		Set<String> values = new HashSet<>(){{add("a"); add("b");}};
		Set<String> copiedValues = Set.copyOf(values);
		assertFalse(values == copiedValues);
		assertEquals(values, copiedValues);
		
		values.add("c");
		assertNotEquals(values, copiedValues);
	}
	
	@Test
	void should_have_different_reference_using_unmodifiable_set_test() {
		// init
		Set<String> values = Collections.unmodifiableSet(new HashSet<>(){{add("a"); add("b");}});
		Set<String> copiedValues = Set.copyOf(values);
		assertFalse(values == copiedValues);
		assertEquals(values, copiedValues);
	}
	
	@Test
	void should_have_same_reference_set_test() {
		// init
		Set<String> values = Set.of("a", "b");
		Set<String> copiedValues = Set.copyOf(values);
		assertTrue(values == copiedValues);
		assertEquals(values, copiedValues);
	}

}
