package myJava.tips.partACollections;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

class Item2CollectionsUnmodifiableListTest {

	@Test
	void should_work_as_view_test() {
		// init
		List<String> values = new ArrayList<>(){{add("a"); add("b");}};
		List<String> view = Collections.unmodifiableList(values);
		assertEquals(List.of("a", "b"),  values);
		assertEquals(List.of("a", "b"),  view);
		// updating initial List
		values.add("c");
		assertEquals(List.of("a", "b", "c"),  values);
		assertEquals(List.of("a", "b", "c"),  view);
	}
	
	@Test
	void should_not_modify_resulted_list_test() {
		// init
		List<String> values = new ArrayList<>(){{add("a"); add("b");}};
		List<String> view = Collections.unmodifiableList(values);
		// trying modify list
		assertThrows(UnsupportedOperationException.class, () -> view.add("b"));
		assertThrows(UnsupportedOperationException.class, () -> view.remove(0));
		assertThrows(UnsupportedOperationException.class, () -> view.set(1, "c"));
	}

}
