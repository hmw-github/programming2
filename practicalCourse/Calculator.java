package practicalCourse;

public class Calculator {

	public int add(int x, int y) {
		return x + y;
	}

	public int sub(int x, int y) {
		return x - y;
	}
	
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		
		int sum = calculator.add(10, 20);
		int sub = calculator.sub(20, 10);
		
		System.out.printf("10 + 20 = %d\n", sum);
	}

}
