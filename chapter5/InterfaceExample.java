package chapter5;

interface InfoProvider {
    String getInfo();    
}

class Bike implements InfoProvider {
	private String name;
	private float price;
	
	public Bike(String name, float price) {
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Bike [name=" + name + ", price=" + price + "]";
	}
	
	public String getInfo() {
		return toString();
	}
}

class Car implements InfoProvider {
    private String name = "Tesla Model Y", number = "IN - XY 1234";
    public String getInfo() {
        return "name=" + name + ", number=" + number;
    }    
}

class Pet implements InfoProvider {
    private String name = "Charlie", type = "Cat";
    public String getInfo() {
        return "name=" + name + ", type=" + type;
    }    
}

class Strawberry implements InfoProvider {
    public String getInfo() {
        return "I am a strawberry!";
    }
}

public class InterfaceExample {
    private static void printInfo(InfoProvider p) {
        System.out.println(p.getInfo());
    }
    
    public static void main(String[] args) {
        Car myCar = new Car();
        Pet myPet = new Pet();
        printInfo(myCar);
        printInfo(myPet);
        printInfo(new Strawberry());
        printInfo(new Bike("Superbike", 1000.0f));
    }
}
