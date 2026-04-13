package chapter3;

class Person {
	// protected: private but gets inherited by subclasses
    private String name;

    public Person() {
        this("n/a");
    }
   
    public Person(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public String toString() {
        return "Person: name = " + name;
    }
}

/**
 * To develop: Class Student - a Student has/offers
	a student number, e.g. 4711
	a getter for the student number
	all properties that Person has!
	a way to provide a string representation of its data => toString()
 */
class Student extends Person {
	private int studentNumber;

	public Student(int studentNumber, String name) {
		super(name);
		this.studentNumber = studentNumber;
	}
	
	public int getStudentNumber() {
		return studentNumber;
	}
	
	public String getData() {
		return getName() + ", " + studentNumber;
	}
	
	public String toString() {
		String personToString = super.toString();
		return personToString + ", register number = " + studentNumber;	
	}
}

public class StudentDemo {

	public static void main(String[] args) {
		Student rajesh = new Student(1234, "Rajesh");
		System.out.println(rajesh);

	}

}
