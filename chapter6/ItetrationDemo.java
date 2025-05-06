package programming2.chapter6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ItetrationDemo {

	public static void main(String[] args) {
		List<String> l = new ArrayList<>();
		l.add("Hello");
		l.add("World");
		
		for (String s : l) {
			System.out.println(s);
		}
		
		// use an iterator
		Iterator<String> iterator = l.iterator();
		while (iterator.hasNext()) { // ask: is there one more element?
			String s = iterator.next(); // get next element
			System.out.println(s);			
		}

	}

}
