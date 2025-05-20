package programming2.chapter6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class UniversityIterator implements Iterator<Student> {
	private int index;
	private List<Student> students;
	
	public UniversityIterator(List<Student> studentsOriginal, String filter, boolean sorting) {
		// apply filter, copy into local list		
		this.index = 0;
		this.students = new ArrayList<>();
		for (Student s : studentsOriginal) {
			if (filter == null || filter.length() == 0 || s.getName().indexOf(filter) != -1) {
				students.add(s);
			}
		}
		
		// sort 
		if (sorting) {
			Collections.sort(students);
		}
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
	private String filter = "";
	private boolean sorting = false;
	
	public University(List<Student> students) {
		this.students = students;
	}
	
	public void setFilter(String filter) {
		this.filter = filter;
	}
	
	public void setSorting(boolean sorting) {
		this.sorting = sorting;
	}
	
	public Iterator<Student> iterator() {
		return new UniversityIterator(students, filter, sorting);
	}
	
	public List<Student> getStudents() {
		return students;
	}
	
	public static void main(String[] args) {
		List<Student> students = Arrays.asList(
				new Student("Hugo", 1234), 
				new Student("Anna", 1111), 
				new Student("Anna-Maria", 4321));
		
		University uni = new University(students);
		
		uni.setFilter("Anna");
		uni.setSorting(true);		
		for (Student s : uni) {
			System.out.println(s);
		}
		System.out.println("\n---");
		
		// => compiler turns for-each loop into this:
		uni.setFilter("Anna");
		uni.setSorting(false);
		Iterator<Student> iterator = uni.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("\n---");
		
		// with iterator of list
		Iterator<Student> iterator2 = uni.getStudents().iterator();
		while (iterator2.hasNext()) {
			System.out.println(iterator2.next());
		}		
	}

}
