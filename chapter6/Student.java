package programming2.chapter6;

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