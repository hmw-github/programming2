package programming2.chapter6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class NameComparator implements Comparator<Student> {
	@Override
	public int compare(Student s1, Student s2) {
		return s1.getName().compareTo(s2.getName());
	}
}

class Student implements Comparable<Student> {
    private String name;
    private int matriculationNumber;

    public Student(String name, int matriculationNumber) {
        this.name = name;
        this.matriculationNumber = matriculationNumber;
    }

    public int compareTo(Student s) {
    	//return Integer.compare(matriculationNumber, s.matriculationNumber);
    	return s.matriculationNumber - matriculationNumber;
    }
    
    public String getName() {
        return name;
    }

    public int getMatriculationNumber() {
        return matriculationNumber;
    }

    public String toString() {
        return "Name: " + name + ", Matriculation Number: "
            + matriculationNumber;
    }
}

public class ManageStudentsWithList {
    private List<Student> studentList = new ArrayList<Student>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
    	ManageStudentsWithList management = new ManageStudentsWithList();
        management.run();
    }

    public void run() {
        int choice;
        
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // consume rest of line
            long startTime = System.currentTimeMillis();
            switch (choice) {
                case 1:
                    listStudents();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    findStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    sortStudents();
                    break;
                case 6:
                    generateSampleStudents();
                    break;
                case 0:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            long endTime = System.currentTimeMillis();
            if (choice != 0) {
                System.out.println("Operation took " + (endTime - startTime) 
                    + " milliseconds.");
            }
        } while (choice != 0);
    }

    private void showMenu() {
        System.out.println("\nStudent Management Menu:");
        System.out.println("1. List all students");
        System.out.println("2. Add a student");
        System.out.println("3. Find a student by matriculation number");
        System.out.println("4. Delete a student by matriculation number");
        System.out.println("5. Sort the student list");
        System.out.println("6. Generate 50,000 sample students");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private void listStudents() {
    	for (int i = 0; i < studentList.size(); ++i) {
    		System.out.printf("%d. %s%n", i + 1, studentList.get(i));
    	}
    }

    /**
     * 1. read name and matriculation number from console
     * 2. create student from inputs
     * 3. append student to list
     */
    private void addStudent() {
    	System.out.print("Name: ");
    	String name = scanner.nextLine();
    	System.out.print("Matriculation number: ");
    	int matriculationNumber = scanner.nextInt();
    	
    	Student newStudent = new Student(name, matriculationNumber);
    	studentList.add(newStudent);
    }

    private Student search(int matriculationNumber) {
    	Student found = null;

    	for (int i = 0; i < studentList.size(); ++i) {
    		Student student = studentList.get(i);
    		
    		if (student.getMatriculationNumber() == matriculationNumber) {
    			found = student;
    			break;
    		}
    	}
    	return found;
    }
    
    /**
     * 1. read matriculation number from console
     * 2. iterate over list
     * 3. search for matriculation number: if found, print student else print error message
     */
    private void findStudent() {
    	System.out.print("Matriculation number: ");
    	int matriculationNumber = scanner.nextInt();
    	Student found = search(matriculationNumber);
    	
    	if (found != null) {
    		System.out.println("found: " + found);
    	} else {
    		System.out.println("matriculation number not found!");
    	}
    }

    /**
     * 1. read matriculation number from console
     * 2. iterate over list
     * 3. search for matriculation number: if found, delete student else print error message
     */
    private void deleteStudent() {
    	System.out.print("Matriculation number: ");
    	int matriculationNumber = scanner.nextInt();
    	Student found = search(matriculationNumber);
    	
    	if (found != null) {
    		studentList.remove(found);
    		System.out.println("deleted: " + found);
    	} else {
    		System.out.println("matriculation number not found!");
    	}
    }

    private void sortStudents() {
    	int choice = 1; // or let user make a choice!
    	
    	if (choice == 1) 
    		Collections.sort(studentList);
    	// sort by name
    	else if (choice == 2)
    		Collections.sort(studentList, new NameComparator());
    	//Collections.sort(studentList, (s1, s2) -> s1.getName().compareTo(s2.getName()));
    }

    private void generateSampleStudents() {
    	studentList.clear();
        for (int i = 0; i < 50000; i++) {
            String name = "Student" + (i + 1);
            int matriculationNumber = 100000 + i;
            Student student = new Student(name, matriculationNumber);
            studentList.add(student);
        }
        System.out.println("50,000 sample students generated.");
    }
}


