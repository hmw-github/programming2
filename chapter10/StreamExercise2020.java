package programming2.chapter10;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Process a given list of file names as follows:
 * - eliminate invalid names. A file name is valid if it
 *   either has no dot and is not empty or it contains a dot 
 *   and both parts (left and right) are not empty
 * - output each file name like this: file=<file>, ext=<ext>
 */
public class StreamExercise2020 {
    public static void main(String[] args) {
        String[] filenames = { 
            "file.mp3", ".mp3", "b.c", "a.", "abc", "42.txt" };
        // solution with Streams/Lambdas...
        Predicate<String> validFilename = filename -> {
        	boolean valid = true;
        	int lastPoint = filename.lastIndexOf(".");
        	String file = filename, ext = "";
        	
        	if (lastPoint == -1 && filename.length() == 0) {
        		valid = false;
        	} else if (lastPoint >= 0 
        			&& (lastPoint == 0 || lastPoint == filename.length()-1)) {
        		valid = false;
        	} 	
        	return valid;
        };
        		
        Consumer<String> printFilename = filename -> {
        	int lastPoint = filename.lastIndexOf(".");
        	String file = filename, ext = "";

        	if (lastPoint != -1) {
    			file = filename.substring(0, lastPoint);
    			ext = filename.substring(lastPoint+1);
    		}
    		System.out.printf("file=%s, ext=%s\n", file, ext);
        };
        
        Arrays.stream(filenames)
        .filter(validFilename)
        .forEach(printFilename);

        // solution without Streams/Lambdas...
        for (String filename : filenames) {
        	boolean valid = true;
        	int lastPoint = filename.lastIndexOf(".");
        	String file = filename, ext = "";
        	
        	if (lastPoint == -1 && filename.length() == 0) {
        		valid = false;
        	} else if (lastPoint >= 0 
        			&& (lastPoint == 0 || lastPoint == filename.length()-1)) {
        		valid = false;
        	} 
        	
        	if (valid) {
        		if (lastPoint != -1) {
        			file = filename.substring(0, lastPoint);
        			ext = filename.substring(lastPoint+1);
        		}
        		System.out.printf("file=%s, ext=%s\n", file, ext);
        	}
        }
    }
}
