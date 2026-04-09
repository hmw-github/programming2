package chapter2;

public class Rectangle {
    double height;
    double width;
    
    // ... Constructor etc.
    public Rectangle(double height, double width) {
		this.height = height;
		this.width = width;
	}    
    
    public Rectangle(double value) {
    	this(value, value);
    }
  
    void setSides (double h, double w) {
        height = h;
        width = w;
    }
    
	void setSides (double l) {
        setSides (l, l);
    }
    
    int setSidesAndSum(double h, double w) {
        height = h;
        width = w;
        return (int) (h + w);
    }

    @Override
    public boolean equals(Object o) {
    	Rectangle other = (Rectangle) o; // type cast
    	
    	return height == other.height && width == other.width;
    }
    
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(3.0, 4.0);
        
        r1.setSides(2., 3.);
        r1.setSides(33.);
     
        Rectangle r2 = new Rectangle(10.0);
        r1.setSides(10.0);
     
        // compare references
        if (r1 == r2) {
        	System.out.println("Refs are equal!");
        } else {
        	System.out.println("Refs are NOT equal!");        	
        }
     
        // compare contents
        if (r1.equals(r2)) {
        	System.out.println("Contents are equal!");
        } else {
        	System.out.println("Contents are NOT equal!");        	
        }
     
     
     
     
        
    }
}
