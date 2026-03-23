package chapter1;

import java.util.Scanner;

/**
 * Define a method that is passed a name and 
 * that outputs "Hello <name>!". 
 * Test the method with a loop 
 */
public class MethodDemo {

	// static method
	private static void sayHello(String name) {
		System.out.printf("Hello %s!\n", name);
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String name;

		/**
		 * i++: post increment
		 * ++i: pre increment
		 * 
		 * int i = 2;
		 * arr[++i] <> arr[i++]
		 * arr[3]   <> arr[2]
		 */
		for (int i = 0; i < 10; ++i) {
			System.out.println(i);
		}
		
		for (;;) { // endless loop
			// read a name from console
			
			System.out.print("Name (empty string to exit): ");
			name = scanner.nextLine();
			
			if (name.equals("")) {
				break;
			}
			
			MethodDemo.sayHello(name);
		}
	}

}
