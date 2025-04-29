package programming2.chapter5;

interface Device {
	String getDetails();
}

class Smartphone implements Device {
	private String brand;
	private String model;
	
	public Smartphone(String brand, String model) {
		this.brand = brand;
		this.model = model;
	}

	public String getDetails() {
		return "brand=" + brand + ", model=" + model;
	}
}

class Laptop implements Device {
	private String brand;
	private int ramSize;
	
	public Laptop(String brand, int ramSize) {
		this.brand = brand;
		this.ramSize = ramSize;
	}
	
	public String getDetails() {
		return "brand=" + brand + ", ramSize=" + ramSize;
	}
}

/**
 * Define an interface Device that contains a method String getDetails().
 * Create two classes Smartphone and Laptop that implement Device.
 * - Smartphone should have the properties brand and model.
 * - Laptop should have the properties brand and ramSize (in GB).
 * 
 * Implement the method getDetails() in both classes so that it returns the corresponding details.
 * Write a method printDeviceInfo(Device d) that calls getDetails() and outputs the result.
 * Create a smartphone and a laptop in the main() program and pass them to printDeviceInfo().
 */
public class Devices {

	public static void printDeviceInfo(Device device) {
		System.out.println(device.getDetails());
	}
	
	public static void main(String[] args) {
		printDeviceInfo(new Smartphone("Samsung", "Galaxy S25"));
		printDeviceInfo(new Laptop("Macbook Pro M4", 16));
	}

}
