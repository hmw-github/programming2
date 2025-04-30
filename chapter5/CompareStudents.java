package programming2.chapter5;

import java.util.Arrays;
import java.util.Comparator;

class Student implements Comparable {
	private int studentNumber;
	private String name;
	private double salary;
	
	public Student(int studentNumber, String name, double salary) {
		this.studentNumber = studentNumber;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Student [studentNumber=" + studentNumber + ", name=" + name + ", salary=" + salary + "]";
	}

	public int compareTo(Object o) {
		if (o instanceof Student) {
			Student s = (Student) o; // may produce ClassCast Exception!
			//return studentNumber - s.studentNumber;
			//return -Integer.compare(studentNumber, s.studentNumber);
			//return name.compareTo(s.name);
			
			// compare by salary descending then by student number
	//		if (salary < s.salary) {
	//			return 1;
	//		} else if (salary > s.salary) {
	//			return -1;
	//		} else {
	//			// salaries are equal: compare by student number
	//			return studentNumber - s.studentNumber;
	//		}
			
			int comparison = Double.compare(salary, s.salary);
			if (comparison == 0) {
				return studentNumber - s.studentNumber;
			} else {
				return comparison;
			}
		} else {
			return 1; // student object always greater than obj. of other type!
		}
	}
	
	public String getName() {
		return name;
	}
	
	public int getStudentNumber() {
		return studentNumber;
	}
}

class NameComparator implements Comparator {
	@Override
	public int compare(Object o1, Object o2) {
		Student s1 = (Student) o1;
		Student s2 = (Student) o2;
		return s1.getName().compareTo(s2.getName());
	}
}

public class CompareStudents {

	public static void main(String[] args) {
		Student[] students = {
				new Student(4711, "Hugo", 1500.12),
				new Student(4711, "Arisha", 9999.50),
				new Student(4713, "Sebastian", 500.30),
				new Student(4000, "Susie", 500.30)
		};
		
		for (Student s : students) {
			System.out.println(s);
		}
		Arrays.sort(students);
		for (Student s : students) {
			System.out.println(s);
		}		
		
		Arrays.sort(students, new NameComparator());
		// Arrays.sort(students, (s1, s2) -> s1.getStudentNumber() - s2.getStudentNumber());
		for (Student s : students) {
			System.out.println(s);
		}		
		
		// avoid exception
		int c = new Student(123, "Charlie", 123.12).compareTo("some string");
		
	}

}
