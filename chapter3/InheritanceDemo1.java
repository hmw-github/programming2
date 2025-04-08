package programming2.chapter3;

class Person {
    private String name;
    
    public Person() {
        this("n/a"); // call other CTOR
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
 * Use all non-private attributes and methods of Person
 */
class Student extends Person {
    private int studentNumber;

    public Student(String name, int studentNumber) {
        super(name);
        this.studentNumber = studentNumber;
    }
    public Student() {
        //super();
        //this.studentNumber = -1;
        this("aaa", -1);
    }
    
    public int getStudentNumber() {
        return studentNumber;
    }

    public void printName() {
    	System.out.println("name = " + getName());
    }
    
    public String toString() {
        return "Student: " + super.toString() + ", studentNumber = " +
            studentNumber;
    }
}

public class InheritanceDemo1 {

    public static void main(String[] args) {
        Student anna = new Student("Anna", 4711);
        System.out.println(anna);
        anna.printName();
    }

}
