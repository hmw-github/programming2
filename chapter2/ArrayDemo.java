package programming2.chapter2;

import java.util.Arrays;

public class ArrayDemo {
    public static void main(String[] args) {
        // Create array for 4 integers, automatically pre-assigned with 0!
        int[] intArray = new int[4];
    	
        // Assignment of the array: first element should be 10
        intArray[0] = 10;
        // the rest with the double of the predecessor - use loop!
        for (int i = 1; i < intArray.length; ++i) {
        	intArray[i] = intArray[i-1] * 2;
        }
        
        // then: output array in loop (println does not work!)
        for (int intElement : intArray) {
        	System.out.println(intElement);
        }
    
        // 2nd array for 3 double values with static initialisation
        double[] doubles = { 11.0, -2.0, 3.0 };
        
        // output array after initialization
        Arrays.sort(doubles);
        
        for (int i = 0; i < doubles.length; ++i) {
        	System.out.printf("%d: %f%n", i, doubles[i]);
        }
    }
}
