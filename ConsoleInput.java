

import java.util.Scanner;

public class ConsoleInput {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Name: ");
		String name = scanner.nextLine();

		System.out.print("Student Id: ");
		int studentId = scanner.nextInt();
		
		System.out.printf("Hi my name is %s, my id is %d\n", 
				name, studentId);
	}

}
