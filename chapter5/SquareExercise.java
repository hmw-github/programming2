package chapter5;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Each square has side length and color
 * Square objects should be comparable; color is used 
 * 		if the side length is the same:
 * 		Square(10, "red") is therefore greater than Square(10, "blue")
 */

class Square implements Comparable {
	private int sideLength;
	private String color;
	
	public Square(int sideLength, String color) {
		this.sideLength = sideLength;
		this.color = color;
	}

	@Override
	/**
	 * compare by sideLength; 
	 * color is used if the side length is the same
	 */
	public int compareTo(Object o) {
		Square other = (Square) o;
		
		if (sideLength == other.sideLength) {
			// compare colors
			return color.compareTo(other.color);
		}
		return sideLength - other.sideLength;
	}

	@Override
	public String toString() {
		return "Square [sideLength=" + sideLength + ", color=" + color + "]";
	}

	public int getSideLength() {
		return sideLength;
	}

	public String getColor() {
		return color;
	}
	
	
}

class ColorSideLengthComparator implements Comparator {

	@Override
	/**
	 * Compare squares by color first and then by side length descending
	 */
	public int compare(Object o1, Object o2) {
		Square sq1 = (Square) o1;
		Square sq2 = (Square) o2;
		
		int colorComp = sq1.getColor().compareTo(sq2.getColor());
		
		if (colorComp == 0) {
			// compare by side length
			return -(sq1.getSideLength() - sq2.getSideLength());
		}
		return colorComp;
	}
	
}

public class SquareExercise {
	static public void main(String[] args) {
		Square[] squares = {
                new Square(3, "red"),
                new Square(9, "blue"),
                new Square(3, "blue")
		};
		Arrays.sort(squares);
		System.out.println("after sorting:");
		for (Square q: squares) {
			System.out.println(q);
		}

		// compare by color and sideLength
		Arrays.sort(squares, new ColorSideLengthComparator());
		System.out.println("after sorting:");
		for (Square q: squares) {
			System.out.println(q);
		}

	}
}
