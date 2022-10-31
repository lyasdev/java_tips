package myJava.tips.partACollections;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

class Item4ListCopyOfTest {

	@Test
	void should_have_different_reference_test() {
		// init
		List<String> values = new ArrayList<>(){{add("a"); add("b");}};
		List<String> copiedValues = List.copyOf(values);
		assertFalse(values == copiedValues);
		assertEquals(values, copiedValues);
		
		values.add("c");
		assertNotEquals(values, copiedValues);
	}
	
	@Test
	void should_have_different_reference_using_unmodifiable_list_test() {
		// init
		List<String> values = Collections.unmodifiableList(new ArrayList<>(){{add("a"); add("b");}});
		List<String> copiedValues = List.copyOf(values);
		assertFalse(values == copiedValues);
		assertEquals(values, copiedValues);
	}
	
	@Test
	void should_have_same_reference_list_test() {
		// init
		List<String> values = List.of("a", "b");
		List<String> copiedValues = List.copyOf(values);
		assertTrue(values == copiedValues);
		assertEquals(values, copiedValues);
	}

}
