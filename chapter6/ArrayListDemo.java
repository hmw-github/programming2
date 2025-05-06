package programming2.chapter6;

import java.util.ArrayList;

public class ArrayListDemo {
	// Simple hash function
	static public int h(String s) {
		int sum = 0;
		int HT_SIZE = 100;
		
		for (int i = 0; i < s.length(); ++i) {
			sum += s.charAt(i);
		}
		return sum % HT_SIZE;
	}
	
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("Apple");
        list.add("Banana");
        list.add(42); //int - autoboxing -> Integer
        for (int i = 0; i < list.size(); ++i) {
            String s = (String) list.get(i);
            System.out.println(s);
        }
    }
}