package myJava.tips.partACollections;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;

class Item3SetOfTest {

	@Test
	void should_be_immutable_test() {
		// init
		var values = Set.of("a", "b");
		// trying modify list
		assertThrows(UnsupportedOperationException.class, () -> values.add("c"));
		assertThrows(UnsupportedOperationException.class, () -> values.remove("b"));
	}

}
