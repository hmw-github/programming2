package programming2.chapter2;

public class Position {
	
	private double x, y;
	
	// default CTOR
	public Position() {
//		this.x = 0;
//		this.y = 0;		
		this(0, 0); // constructor chaining
	}
	
	public Position(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Position(double init) {
//		this.x = init;
//		this.y = init;		
		this(init, init); // constructor chaining
	}

	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public static void main(String[] args) {
		Position pos1 = new Position(1.0, 2.0);
		System.out.printf("Position(%f, %f)%n",
				pos1.getX(), pos1.getY());
		
		Position pos2 = new Position(2.0);
		System.out.printf("Position(%f, %f)%n",
				pos2.getX(), pos2.getY());		
		Position pos3 = new Position();
		System.out.printf("Position(%f, %f)%n",
				pos3.getX(), pos3.getY());		
	}

}
