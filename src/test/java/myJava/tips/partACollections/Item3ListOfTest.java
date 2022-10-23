package myJava.tips.partACollections;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class Item3ListOfTest {

	@Test
	void should_be_immutable_test() {
		// init
		List<String> values = List.of("a", "c");
		// trying modify list
		assertThrows(UnsupportedOperationException.class, () -> values.add("b"));
		assertThrows(UnsupportedOperationException.class, () -> values.remove(0));
		assertThrows(UnsupportedOperationException.class, () -> values.set(1, "c"));
	}

}
