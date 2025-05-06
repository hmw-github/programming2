package programming2.chapter6;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

	public static void main(String[] args) {
		//    key    value
		Map<String, Integer> colors = new HashMap<String, Integer>();
		
		colors.put("red", 0xff0000);
		colors.put("blue", 0x0000ff);

		Integer blue = colors.get("blue");
		if (blue != null) {
			System.out.println("blue=" + blue);
		}
	}

}
