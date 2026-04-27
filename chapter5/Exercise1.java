package chapter5;

/**
 * Define an interface Device that contains a method getDetails().
 * - Create two classes Smartphone and Laptop that implement Device.
 * - Smartphone should have the properties brand and model.
 * - Laptop should have the properties brand and ramSize (in GB).
 * - Implement the method getDetails() in both classes so that it 
 * 		returns the corresponding details.
 * - Write a method printDeviceInfo(Device d) that calls getDetails() and outputs the result.
 * - Create a smartphone and a laptop in the main() program and pass them to printDeviceInfo().
 */

interface Device {
	String getDetails();
	double getPrice();
}

class Smartphone implements Device {
	private String brand, model;
	
	public Smartphone(String brand, String model) {
		this.brand = brand;
		this.model = model;
	}

	@Override
	public String getDetails() {
		return brand + ", " + model;
	}
	
	public double getPrice() {
		return 100.0;
	}
}

class Laptop implements Device {
	private String brand;
	private double ramSizeInGB;
	
	public Laptop(String brand, double ramSizeInGB) {
		this.brand = brand;
		this.ramSizeInGB = ramSizeInGB;
	}

	@Override
	public String getDetails() {
		return brand + ", " + ramSizeInGB;
	}
		
	public double getPrice() {
		return 600.0;
	}
}

public class Exercise1 {

	static void printDeviceInfo(Device d) {
		System.out.println(d.getDetails() + " - " + d.getPrice());
	}
	
	public static void main(String[] args) {
		printDeviceInfo(new Laptop("Macbook Neo", 8));
		printDeviceInfo(new Smartphone("Google Pixel", "8"));
	}

}
