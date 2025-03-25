package programming2.chapter1;

import java.util.Scanner;

public class IfDemo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
				
		System.out.print("n = ");
		int n = scanner.nextInt();
		
		if (n > 0) {
			System.out.println("positive");
		} else  {
			if (n == 0) {
				System.out.println("0");							
			} else {
				System.out.println("negative");			
			}
		}		

		if (n == 42) {
			System.out.println("42");							
		} else if (n > 0) {
			System.out.println("positive");
		} else if (n == 0) {
			System.out.println("0");							
		} else {
			System.out.println("negative");			
		}

		switch (n) { // for int and String
		case 0:
			System.out.println("0");
			break;
		case 42:
			System.out.println("42");
			break;
		default:
			System.out.println("default branch!");
		}
		
		scanner.close();
	}

}
