package chapter6;

import java.util.ArrayList;

public class WeNeedTypeSafety {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Apple");
        list.add("Banana");
        //list.add(Integer.valueOf(42)); // autoboxing
        for (int i = 0; i < list.size(); i++) {
        	String s = list.get(i);
        	System.out.println(s);
        }
    }
}
