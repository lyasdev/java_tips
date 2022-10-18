package myJava.tips.partACollections;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class Item1arraysAsListTest {

	@Test
	void should_work_as_view_test() {
		// init
		String[] values = {"a", "c"};
		List<String> view = Arrays.asList(values);
		assertArrayEquals(new String[]{"a", "c"}, values);
		assertEquals(List.of("a", "c"),  view);
		// update initial array
		values[1] = "b";
		assertArrayEquals(new String[]{"a", "b"}, values);
		assertEquals(List.of("a", "b"),  view);
	}
	
	@Test
	void should_update_list_test() {
		// init
		String[] values = {"a", "c"};
		List<String> view = Arrays.asList(values);
		// update list
		view.set(1, "b");
		assertArrayEquals(new String[]{"a", "b"}, values);
		assertEquals(List.of("a", "b"),  view);
	}
	
	@Test
	void should_not_resize_list_test() {
		// init
		String[] values = {"a", "c"};
		List<String> view = Arrays.asList(values);
		// trying resize list
		assertThrows(UnsupportedOperationException.class, () -> view.add("b"));
		assertThrows(UnsupportedOperationException.class, () -> view.remove(0));
	}

}
