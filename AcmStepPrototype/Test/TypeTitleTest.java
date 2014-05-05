import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class TypeTitleTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetTypeTitle() {
		List<String> expected_list=new ArrayList<String>();
		expected_list.add("1005");
		ArrayList<String> actual_list=TypeTitle.getTypeTitle("规律");
		assertEquals(expected_list,actual_list);
		
		expected_list.clear();
		actual_list.clear();
		expected_list.add("1009");
		expected_list.add("1045");
		expected_list.add("1049");
		expected_list.add("1050");
		expected_list.add("1051");
		expected_list.add("1052");
		expected_list.add("1053");
		expected_list.add("1055");
		expected_list.add("1257");
		expected_list.add("1800");
		expected_list.add("2037");
		expected_list.add("2111");
		expected_list.add("2124");
		expected_list.add("2187");
		expected_list.add("2391");
		expected_list.add("2570");
		actual_list=TypeTitle.getTypeTitle("贪心");
		assertEquals(expected_list,actual_list);
		
		actual_list.clear();
		actual_list=TypeTitle.getTypeTitle("模拟");
		assertNotEquals(expected_list,actual_list);
		
		
		
		
		
	}

}
