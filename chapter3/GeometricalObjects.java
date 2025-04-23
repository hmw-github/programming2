package programming2.chapter3;

abstract class GeometricalObject {
    private String name;

	public GeometricalObject(String name) {
		this.name = name;
	}
    
    public String getName() {
    	return name;
    }
    
    public abstract double perimeter();
}

class Square extends GeometricalObject {
    private double side;

	public Square(String name, double side) {
		super(name);
		this.side = side;
	}
    
    public double perimeter() {
    	return 4 * side;
    }
}

class Circle {
    
}

class Triangle {
    
}

public class GeometricalObjects {
    public static void main(String[] args) {
        GeometricalObject[] objects = {
            new Square("Square 1", 2.0),
            //new Circle("Circle 1", 4.0),
            //new Triangle("Triangle 1", 1.0, 2.0, 3.0)
        };
        for (GeometricalObject o : objects) {
            System.out.printf("Name: %s, perimeter: %f\n", 
                o.getName(), o.perimeter());
        }
    }
}