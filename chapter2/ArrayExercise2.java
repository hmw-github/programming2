package programming2.chapter2;

class Square {
    private int side;
    
    public Square(int side) {
        this.side = side;
    }
    public void print() {
        System.out.printf("Square (side=%d)\n", side);
    }
    public int getSide() {
        return side;
    }
}

/**
 * Given a simple class Square with attribute "side".
 * 1. Create an array with three squares, 
 * 2. then output each element to the console 
 * 3. and determine the average side length.
 */
public class ArrayExercise2 {
    public static void main(String[] args) {
        // 1.
    	Square[] squares = {
    		new Square(1), new Square(3), new Square(5)
    	};
    	
    	// 2.
    	for (Square element : squares) {
    		element.print();
    	}
    	
    	// 3.
    	int sum = 0;
    	
    	for (Square element : squares) {
    		sum += element.getSide();
    	}
    	double average = sum / squares.length;
    	System.out.println("Average: " + average);
    }
}

