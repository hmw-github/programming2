package chapter2;

import java.util.Arrays;

/**
 * Class to demonstrate the use of
 * - arrays
 * - strings
 * - comparisons
 */
public class ArrayStringComparisonDemo {

	public static void arrays() {
		// Array for 3 int values
		int[] integers; // reference to null
		integers = new int[3]; // static size of 3, all zero
		
		// store 3 values 
		integers[0] = 333;
		integers[1] = -2;
		integers[2] = 300;
		
		Arrays.sort(integers);
				
		// loop over array
		for (int i = 0; i < integers.length; ++i) {
			System.out.printf("integers[%d] = %d\n", i, integers[i]);
		}
		
		// array with static init.
		String[] strings = { 
				"Hello",
				"World"
		};
		
		int index = 0;
		for (String s : strings) {
			System.out.println(index++ + ": " + s);
		}
	}
	
	public static void strings() {
		String s1 = "Hi!"; // create String object with String "Hi!"
		String s2 = new String("Hi!");
		int l = s1.length(); 
		
		// 1. comparison
		if (s1 == s2) {
			System.out.println("s1 equals s2!");
		} else {
			System.out.println("s1 different from s2!");			
		}
		
		if (s1.equals(s2)) {
			System.out.println("content: s1 equals s2!");
		} else {
			System.out.println("content: s1 different from s2!");			
		}
		
		String s3 = "     \tThis is a demo string\t    \n";
		s3 = s3.trim();
		
		// concatenation
		String s4 = s3 + ": Hi!";
		
		System.out.println("s4: " + s4);
		// loop over string
		String s5 = "";
		for (int i = 0; i < s4.length(); ++i) {
			char c = s4.charAt(i);
			//System.out.println(c);
			s5 = s5 + c;
		}
		System.out.println("s5: " + s5);

		// finding a string within string
		int pos = s5.indexOf("Hi!");
		if (pos == -1) {
			// not found
		} else {
			// found: cut Hi! out of string
			String s6 = s5.substring(0, pos);
			System.out.println(s6);
			
			// replace demo by Java
			s6 = s6.replace("demo", "java");
			System.out.println(s6);
		}
	}
	
	public static void main(String[] args) {
		arrays();
		strings();
		
	}

}
