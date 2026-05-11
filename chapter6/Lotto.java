package chapter6;

import java.util.HashSet;
import java.util.Set;

public class Lotto {  
    public static void main(String[] args) {     
        Set<Integer> draw = new HashSet<Integer>(); 
        
        while(draw.size() < 6) {
        	int n = (int) (Math.random() * 49) + 1;
        	System.out.println("rand: " + n);
            draw.add(n);     
        } 
        
        System.out.println("Lottery numbers: "+ draw);   
    }
}
