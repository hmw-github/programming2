package programming2.chapter3;

abstract class Base {
	private int id;
	private String tableName;
	
	public Base(int id, String tableName) {
		this.id = id;
		this.tableName = tableName;
	}
	
	abstract public double price();
	
	public void print(boolean printNewline) {
		String end = printNewline ? "\n" : "";
		
		System.out.printf("id=%d, table=%s, price=%.2f%s", 
				id, tableName, price(), end);
		
//		String s;
//		if (printNewline) {
//			s = "\n";
//		} else {
//			s = "";
//		}
//		System.out.print(s);
	}
}

class Car extends Base {
	private String numberPlate;
	private double price;
	
	public Car(int id, String tableName, String numberPlate, double price) {
		super(id, tableName);
		this.numberPlate = numberPlate;
		this.price = price;
	}
	
	public void print(boolean printNewline) {
		super.print(false);
		System.out.println(", numberPlate=" + numberPlate);
	}
	
	public double price() {
		return price;
	}
}

class Apple extends Base {
	private String type;
	
	public Apple(int id, String tableName, String type) {
		super(id, tableName);
		this.type = type;
	}
	
	public void print(boolean printNewline) {
		super.print(false);
		System.out.println(", type=" + type);
	}
	
	public double price() {
		return 0.75;
	}
}

class Smartphone extends Base {

	public Smartphone(int id, String tableName) {
		super(id, tableName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double price() {
		// TODO Auto-generated method stub
		return 999;
	}
	
}

public class DataManagement {

	public static void main(String[] args) {
		// Example of substition principle: instead of superclass ref. you can use a
		// subclass reference!
		Base o = new Car(1, "cars", "number plate", 111111.1);
		
		Base[] objects = {
			new Car(4711, "cars", "IN - BX 1234", 15000.0),
			new Apple(1234, "apples", "Pink Lady"),
			new Smartphone(11, "smartphones")
			//new Base(1111, "foo") not possible - Base is abstract!
		};

		for (Base b : objects) {
			b.print(true);
		}
	}

}
