package programming2.chapter1;

public class HelloWorld {

	public static void main(String[] args) {
		System.out.println("Hallo World!");
		
		int sum;
		sum = 4 + 9;
		System.out.println(sum);
		System.out.printf("The sum is %d, and again: %d%n", sum, sum);
		
		String name = "Anna";
		int studentId = 4711;
		
		System.out.printf("I am %s, my student number is %d.", 
				name, studentId);
	}

}
