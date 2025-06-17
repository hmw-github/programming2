package programming2.exampreparation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public final class Person {
	private final String name;
	private final Date dateOfBirth;
	private final List<String> hobbies;
	
	public Person(String name, Date dateOfBirth, List<String> hobbies) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.hobbies = hobbies;
	}

	public String getName() {
		return name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public List<String> getHobbies() {
		List<String> copy = new ArrayList<>();
		for (String s : hobbies)
			copy.add(s);
		return copy;
	}

	public String toString() {
		return "Person [name=" + name + ", dateOfBirth=" + dateOfBirth + ", hobbies=" + hobbies + "]";
	}
	
	private boolean equalHobbies(Person p) {
		List<String> l1 = getHobbies();
		List<String> l2 = p.getHobbies();
		Collections.sort(l1);
		Collections.sort(l2);
		// TODO
		return true;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Person) {
			Person p = (Person) o;
			
			return name.equals(p.name) 
					&& dateOfBirth.equals(p.dateOfBirth) 
					&& equalHobbies(p);
		}
		return false;
	}

	public Person withAdditionalHobby(String hobby) {
		List<String> newHobbies = getHobbies();
		newHobbies.add(hobby);
		return new Person(name, dateOfBirth, newHobbies);
	}
	
	public static void main(String[] args) {
		Person hugo = new Person("Hugo", new Date(), new ArrayList<>());
		hugo.getHobbies().add("Swimming");
		System.out.println(hugo);
		Person anna = new Person("Anna", new Date(), Arrays.asList());
		boolean personsEqual = hugo.equals(anna);
		Person anna2 = anna.withAdditionalHobby("Eating");
		System.out.println(anna2);		
	}

}
