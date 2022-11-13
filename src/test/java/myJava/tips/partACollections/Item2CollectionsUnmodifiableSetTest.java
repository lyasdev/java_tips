package myJava.tips.partACollections;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class Item2CollectionsUnmodifiableSetTest {

	@Test
	void should_work_as_view_test() {
		// init
		Set<String> values = new HashSet<>(){{add("a"); add("b");}};
		Set<String> view = Collections.unmodifiableSet(values);
		assertEquals(Set.of("a", "b"),  values);
		assertEquals(Set.of("a", "b"),  view);
		// updating initial List
		values.add("c");
		assertEquals(Set.of("a", "b", "c"),  values);
		assertEquals(Set.of("a", "b", "c"),  view);
	}
	
	@Test
	void should_not_modify_resulted_set_test() {
		// init
		Set<String> values = new HashSet<>(){{add("a"); add("b");}};
		Set<String> view = Collections.unmodifiableSet(values);
		// trying modify set
		assertThrows(UnsupportedOperationException.class, () -> view.add("b"));
		assertThrows(UnsupportedOperationException.class, () -> view.remove("b"));
	}

}
