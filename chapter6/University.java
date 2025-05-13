package programming2.chapter6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class UniversityIterator implements Iterator<Student> {
	private int index;
	private List<Student> students;
	
	public UniversityIterator(List<Student> students) {
		List<Student> list = new ArrayList<>();
		
		for (Student s : students)
			list.add(s);
		Collections.sort(list);
		
		this.index = 0;
		this.students = list;
	}

	public boolean hasNext() {
		return index < students.size();
	}

	public Student next() {
		if (hasNext()) {
			return students.get(index++);
		}
		return null;
	}
	
	
}

public class University implements Iterable<Student> {
	private List<Student> students;
	
	public University(List<Student> students) {
		this.students = students;
	}
	
	public Iterator<Student> iterator() {
		return new UniversityIterator(students);
	}
	
	public List<Student> getStudents() {
		return students;
	}
	
	public static void main(String[] args) {
		List<Student> students = Arrays.asList(
				new Student("Hugo", 1234), 
				new Student("Anna", 9876), 
				new Student("Rajesh", 4321));
		
		University uni = new University(students);
		
		for (Student s : uni) {
			System.out.println(s);
		}
		
		// => compiler turns for-each loop into this:
		Iterator<Student> iterator = uni.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		// with iterator of list
		Iterator<Student> iterator2 = uni.getStudents().iterator();
		while (iterator2.hasNext()) {
			System.out.println(iterator2.next());
		}		
	}

}
