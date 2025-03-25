package programming2.chapter1;

import java.util.Scanner;

public class ConsoleInput {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// read Name from console
		System.out.print("Name: ");
		String name = scanner.nextLine();
		
		/**
		 * read student id
		 */
		System.out.print("Id: ");
		int id = scanner.nextInt();
		
		System.out.printf("Name: %s, id: %d/n", name, id);
	}
}
