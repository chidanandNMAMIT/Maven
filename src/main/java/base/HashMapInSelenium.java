package base;

import java.util.HashMap;
import java.util.Map;

public class HashMapInSelenium {

	public static Map<String, Integer> Quantity_select() {
		
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("One", 1);
		map.put("Two", 2);
		map.put("Three", 3);
		map.put("Four", 4);
		map.put("Five", 5);
		map.put("Six", 6);
		map.put("Seven", 7);
		map.put("Eight", 8);
		map.put("Nine", 9);
		map.put("Ten", 10);
		return map;

	}

}
