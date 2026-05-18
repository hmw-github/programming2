package chapter7;

import java.util.ArrayList;
import java.util.List;

class Student {
	private int nr;
	private String name;
	public Student(int nr, String name) {
		this.nr = nr;
		this.name = name;
	}
	public int getNr() {
		return nr;
	}
	public void setNr(int nr) {
		this.nr = nr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "(" + nr + ", " + name + ")";
	}
}

public class StudentenDB {
    private List<Student> studentList = new ArrayList<>();
    
    public StudentenDB() {
        /* fill list with 3 Student-Objects, omitted here */
    	studentList.add(new Student(1, "Paul")); /* 0 */
    	studentList.add(new Student(2, "Anna")); /* 1 */
    	studentList.add(new Student(3, "Peter")); /* 2 */
    }
    
    public Student getStudentForIndex(int index) {	
    	try {
            return studentList.get(index);
    	} catch (IndexOutOfBoundsException e) {
    		if (index >= studentList.size()) {
    			return null;
    		} else {
	    		// index is negative
	    		throw new IndexOutOfBoundsException();
    		}
    	}
    }
    
    public static void main(String[] args) {
        try {
            StudentenDB db = new StudentenDB();
            System.out.println(db.getStudentForIndex(2));
            System.out.println(db.getStudentForIndex(12));
            System.out.println(db.getStudentForIndex(-1));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException: Index negative");
        }
    }
}

