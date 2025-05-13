package programming2.chapter6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ManageStudentsWithMap {
    private Map<Integer, Student> studentList = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
    	ManageStudentsWithMap management = new ManageStudentsWithMap();
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

    /**
     * Output student list ordered by matriculation number ascending
     */
    private void listStudents() {
    	int i = 1;
    	
    	List<Integer> matriculationNumbers = new ArrayList<>();
    	for (Integer nr : studentList.keySet()) {
    		matriculationNumbers.add(nr);
    	}
    	Collections.sort(matriculationNumbers);
    	
    	for (int nr : matriculationNumbers) {
        	System.out.printf("%d. %s%n", i++, studentList.get(nr));    		
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
    	
    	if (search(matriculationNumber) != null) {
    		System.out.println("Error: matriculation number already exists!");
    	} else {
        	Student newStudent = new Student(name, matriculationNumber);
        	studentList.put(matriculationNumber, newStudent);
    	}
    }

    /**
     * Searches for the matriculation number given and returns the student reference.
     * If the matriculation number is not found, null is returned.
     */
    private Student search(int matriculationNumber) {
    	return studentList.get(matriculationNumber);
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
    		studentList.remove(found.getMatriculationNumber());
    		System.out.println("deleted: " + found);
    	} else {
    		System.out.println("matriculation number not found!");
    	}
    }

    private void sortStudents() {
    	System.out.println("Not supported!");
    }

    private void generateSampleStudents() {
    	studentList.clear();
        for (int i = 0; i < 50000; i++) {
            String name = "Student" + (i + 1);
            int matriculationNumber = 100000 + i;
            Student student = new Student(name, matriculationNumber);
            studentList.put(matriculationNumber, student);
        }
        System.out.println("50,000 sample students generated.");
    }
}


