package chapter6;

import java.util.Set;
import java.util.TreeSet;

public class Lotto {  
    public static void main(String[] args) {     
        Set<Integer> draw = new TreeSet<Integer>(); 
        while(draw.size() < 6) {      
            draw.add((int) (Math.random() * 49) + 1);     
        } 
        System.out.println("Lottery numbers: "+ draw);   
    }
}
