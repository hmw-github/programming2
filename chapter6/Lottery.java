package programming2.chapter6;

import java.util.*;

public class Lottery {

	static public void draw(Set<Integer> numbers) {
		while (numbers.size() < 6) {
			int n = (int) ((Math.random() * 49) + 1);
			numbers.add(n); // adds only if n not already present!
		}
		System.out.println(numbers);
	}
	
	public static void main(String[] args) {
		Set<Integer> numbers = new HashSet<Integer>();
		draw(numbers);
	}

}
