package myJava.tips.partACollections;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

class Item3MapOfTest {

	@Test
	void should_be_immutable_test() {
		// init
		Map<String, Integer> values = Map.of("a", 1, "b", 1);
		// trying modify list
		assertThrows(UnsupportedOperationException.class, () -> values.put("c", 1));
		assertThrows(UnsupportedOperationException.class, () -> values.remove("b"));
	}

}
