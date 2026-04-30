package chapter5;

import java.util.Arrays;
import java.util.Comparator;

class Student implements Comparable {
	private int nr;
	private String name;
	
	public Student(int nr, String name) {
		this.nr = nr;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Student [nr=" + nr + ", name=" + name + "]";
	}

	@Override
	/**
	 * Compares this student to other student by name and -
	 * on equal names - by nr
	 */
	public int compareTo(Object other) {
		Student otherStudent = (Student) other;
		
		int nameComp = name.compareTo(otherStudent.name);
		
		if (nameComp == 0) {
			// compare nr
			//return nr - otherStudent.nr;
			if (nr > otherStudent.nr) {
				return 1;
			} 
			if (nr < otherStudent.nr) {
				return -1;
			}
			return 0;
		} else {
			return nameComp;
		}
	}
	
	public int getNr() {
		return nr;
	}
	
	public String getName() {
		return name;
	}
}

class NrComparator implements Comparator {
	@Override
	public int compare(Object o1, Object o2) {
		Student s1 = (Student) o1;
		Student s2 = (Student) o2;
		return s1.getNr() - s2.getNr();
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

public class ComparisonExperiment {

	public static void main(String[] args) {
		Student[] students = { 
				new Student(4711, "Anna"), 
				new Student(4712, "Jack"),
				new Student(1111, "Anna") 
		};
		Arrays.sort(students);
		for (Student s : students) {
			System.out.println(s);
		}
		
		Arrays.sort(students, new NrComparator());
		for (Student s : students) {
			System.out.println(s);
		}

		Arrays.sort(students, new NameComparator());
		for (Student s : students) {
			System.out.println(s);
		}
	}

}
