package chapter1;


public class CalculateSum {
	public static void main(String[] args) {
		int number1 = 1;
		int number2;
		
		number2 = 9;
		int n1 = 12, n2 = 33;
		
		int sum;
		
		sum = number1 + number2;
		// print "3 + 4 = 7"
		System.out.printf("%d + %05d = %d\n", 
				number1, number2, sum);
		System.out.println(number1 + " + " + number2 
				+ " = " + sum);
	}
}
