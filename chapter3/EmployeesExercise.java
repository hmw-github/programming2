package chapter3;

class Employee {
	private String name;
	private int id;
	protected float baseSalary;
	
	public Employee(String name, int id, float baseSalary) {
		this.name = name;
		this.id = id;
		this.baseSalary = baseSalary;
	}
	
	public float calculateSalary() {
		throw new RuntimeException("implement in subclass!");
	}
}

class Manager extends Employee {
	private float bonus;
	
	public Manager(String name, int id, float baseSalary, float bonus) {
		super(name, id, baseSalary);
		this.bonus = bonus;
	}
	
	public float calculateSalary() {
		return baseSalary + bonus;
	}

	@Override
	public String toString() {
		return "Manager [bonus=" + bonus + ", baseSalary=" + baseSalary + "]";
	}
}

class Developer extends Employee {
	private int projectsCount;

	public Developer(String name, int id, float baseSalary, int projectsCount) {
		super(name, id, baseSalary);
		this.projectsCount = projectsCount;
	}

	public float calculateSalary() {
		return baseSalary + 500 * projectsCount;
	}

	@Override
	public String toString() {
		return "Developer [projectsCount=" + projectsCount + ", baseSalary=" + baseSalary + "]";
	}
	
	
}


public class EmployeesExercise {
    public static void main(String[] args) {
        Employee anna = new Manager("Anna", 1, 5000, 500);
        Employee max = new Developer("Max", 2, 3500, 2);
        Employee[] employees = { anna, max };
        
        for (Employee e : employees) {
            System.out.println(e);
            System.out.println("Salary: " + e.calculateSalary());
            System.out.println();
        }
    }
}
