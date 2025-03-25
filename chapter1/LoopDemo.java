package programming2.chapter1;

import java.util.Scanner;

public class LoopDemo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.print("Name: ");
			String name = scanner.nextLine();
			
			if (name.length() == 0) {
				break;
			}
			System.out.println("Name: " + name);
		}
		/**
		 * Python: for i in range(1, 5, 2): print(i) # prints 1 3
		 */
		for (int i = 1; i < 5; ++i) {
			System.out.println(i);
		}

		int j = 1;
		do {
			System.out.println(j);		
		} while (++j < 5);
	}
	
}
