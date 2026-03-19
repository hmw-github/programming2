package chapter1;


import java.util.Scanner;

public class LoopDemo {

	public static void main(String[] args) {
		/**
		 * Transfer the following Python code to Java:
		 * 
		 * while True:
			....name = input('Name: ')
			....if len(name) == 0:
			......break
			...print("Hello", name)
		 */
		Scanner scanner = new Scanner(System.in);
		boolean terminated = false;
		
		while (!terminated) {
			//name = input('Name: ')
			System.out.print("Name: ");
			String name = scanner.nextLine();
			//if len(name) == 0:
			//	......break
//			if (name.length() == 0) {
//				System.out.println("breaking...");
//				break;
//			}
			if (name.length() == 0) {
				terminated = true;
				continue;
			}
			// ...print("Hello", name)
			System.out.printf("Hello %s\n", name);
		}
		
	}

}
