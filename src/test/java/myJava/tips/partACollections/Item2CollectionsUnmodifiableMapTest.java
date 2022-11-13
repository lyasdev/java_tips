package myJava.tips.partACollections;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class Item2CollectionsUnmodifiableMapTest {

	@Test
	void should_work_as_view_test() {
		// init
		Map<String, Integer> values = new HashMap<>(){{put("a", 1); put("b", 1);}};
		Map<String, Integer> view = Collections.unmodifiableMap(values);
		assertEquals(Map.of("a", 1, "b", 1),  values);
		assertEquals(Map.of("a", 1, "b", 1),  view);
		// updating initial map
		values.put("c", 1);
		assertEquals(Map.of("a", 1, "b", 1, "c", 1),  values);
		assertEquals(Map.of("a", 1, "b", 1, "c", 1),  view);
	}
	
	@Test
	void should_not_modify_resulted_map_test() {
		// init
		Map<String, Integer> values = new HashMap<>(){{put("a", 1); put("b", 1);}};
		Map<String, Integer> view = Collections.unmodifiableMap(values);
		// trying modify list
		assertThrows(UnsupportedOperationException.class, () -> view.put("b", 1));
		assertThrows(UnsupportedOperationException.class, () -> view.remove("b"));
	}

}
