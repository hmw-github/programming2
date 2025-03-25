package programming2.chapter1;

public class CarInfo {
	public static void main(String[] args) {
		int year;

		year = 2009;
		String color = "red";
		double price = 3999.99;
		float consumption = 6.5f;

		// Create your output after this line
		System.out.printf("The car is from %d, has the color %-20s, consumes %f l/100km and costs %.2f Euros.", year,
				color, consumption, price);
	}
}
