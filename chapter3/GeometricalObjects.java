package chapter3;

abstract class GeometricalObject {
    private String name;
    
    public GeometricalObject(String name) {
    	this.name = name;
    }
    
    abstract public double perimeter();
    
    public String getName() {
    	return name;
    }
}

class Rectangle extends GeometricalObject {
	private double a, b;

	public Rectangle(String name, double a, double b) {
		super(name);
		this.a = a;
		this.b = b;
	}
	
	public double perimeter() {
		return 2 * (a+b);
	}
}

class Circle extends GeometricalObject {
	private double r;
	
	public Circle(String name, double r) {
		super(name);
		this.r = r;
	}
	
	public double perimeter() {
		return 2*r*Math.PI;
	}
}

class Triangle extends GeometricalObject {
    private double a, b, c;

	public Triangle(String name, double a, double b, double c) {
		super(name);
		this.a = a;
		this.b = b;
		this.c = c;
	}
    
    public double perimeter() {
    	return a + b + c;
    }
}

public class GeometricalObjects {
    public static void main(String[] args) {
        GeometricalObject[] objects = {
            new Rectangle("rectangle 1", 2.0, 4.0),
            new Circle("circle 2", 4.0),
            new Triangle("triangle 3", 1.0, 2.0, 3.0)
        };
        for (GeometricalObject o : objects) {
            System.out.printf("Name: %s, perimeter: %f\n", 
                o.getName(), o.perimeter());
        }
    }
}
