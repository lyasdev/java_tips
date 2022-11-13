package myJava.tips.partACollections;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class Item4MapCopyOfTest {

	@Test
	void should_have_different_reference_test() {
		// init
		Map<String, Integer> values = new HashMap<>(){{put("a", 1); put("b", 1);}};
		Map<String, Integer> copiedValues = Map.copyOf(values);
		assertFalse(values == copiedValues);
		assertEquals(values, copiedValues);
		
		values.put("c", 1);
		assertNotEquals(values, copiedValues);
	}
	
	@Test
	void should_have_different_reference_using_unmodifiable_map_test() {
		// init
		Map<String, Integer> values = new HashMap<>(){{put("a", 1); put("b", 1);}};
		Map<String, Integer> copiedValues = Map.copyOf(values);
		assertFalse(values == copiedValues);
		assertEquals(values, copiedValues);
	}
	
	@Test
	void should_have_same_reference_map_test() {
		// init
		Map<String, Integer> values = Map.of("a", 1, "b", 1);
		Map<String, Integer> copiedValues = Map.copyOf(values);
		assertTrue(values == copiedValues);
		assertEquals(values, copiedValues);
	}

}
