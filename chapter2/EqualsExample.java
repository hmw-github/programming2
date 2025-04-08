package programming2.chapter2;

class Square2 {
    private int side;
    
    public Square2(int side) {
        this.side = side;
    }
    
    // Method for comparing two squares
    @Override
    public boolean equals(Object sq) {
    	// can i cast safely?
    	if (! (sq instanceof Square2)) {
    		return false;
    	}
    	// do the cast
    	Square2 sq2 = (Square2) sq;
    	// compare content
    	return side == sq2.side;
    }
}

public class EqualsExample {
    public static void main(String[] args) {
        Square2 q1 = null;
        Square2 q2 = new Square2(42);
        Square2 q3 = new Square2(42);
        
        // Compare content od q2 and q3
        boolean b = q2.equals("aaaa");
        if (q2.equals(q3)) {
        	System.out.println("equal!");
        } else { 
        	System.out.println("not equal!");        	
        }
        
    }
}

