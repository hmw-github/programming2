package chapter1;

public class Hello {
	public static void main(String[] args) {
		System.out.println("Hello, World!");
		// print without new line, supply it in string
		System.out.print("Hello, World!\n");
		
		String name = "World";
		int age = 21;
		/**
		 * Placeholders
		 * %s: String
		 * %d: integer numbers: int, short, long
		 * %f: float or double
		 * %b: boolean
		 */
		System.out.printf(
				"Hello, %s!\nI am %d\nMy cash: %.2f, i like Java: %b", 
				name, age, 100.50, true);		
	}
}
