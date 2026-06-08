package chapter10;

import java.util.Arrays;
import java.util.Comparator;

interface Test<T, R> {
	R op(T t);
}

public class LambdaDemo {

	public static void main(String[] args) {
		
		Test<Integer, String> l1 = i -> String.valueOf(i);
		
		String s = l1.op(3);
		
		Comparator<Integer> intComparator = (Integer i1, Integer i2) -> {
//			if (i1 < i2) {
//				return -1;
//			} else if (i1 > i2) {
//				return 1;
//			}
//			return 0;
			//return i1.compareTo(i2);
			return i1 - i2;
		};
		
		Integer[] ints = { 4, 2, 1, -99 };
		Arrays.sort(ints, intComparator);
		for (int i : ints) {
			System.out.println(i);
		}
	}

}
