package programming2.chapter10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

class Person {
	private String name;
	private int age;
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}

public class PersonProcessing {
    private static void processPersons(List<Person> list, 
            Predicate<Person> isValid, Consumer<Person> consumer) {
        for (Person person : list) {
            if (isValid.test(person)) {
                consumer.accept(person);
            }
        }
    }
    
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
            new Person("Hugo Maier", 21), 
            new Person("Anna Müller", 16), 
            new Person("Charlie Schmidt", 30));
        // print only persons of legal 
        Predicate<Person> ofLegalAge = person -> person.getAge() >= 18;
        Consumer<Person> printPerson = p -> System.out.println(p);
        processPersons(persons, 
            ofLegalAge, 
            printPerson);
        // print persons whose name ends with ‘Müller’
        processPersons(persons, 
            person -> person.getName().endsWith("Müller"), 
            printPerson);
        // create a list of persons of legal age
        List<Person> adults = new ArrayList<>();
        processPersons(persons, 
            ofLegalAge, 
            p -> adults.add(p));
        // print persons whose name ends with ‘Müller’
        // use η-conversion!
        processPersons(persons, 
            person -> person.getName().endsWith("Müller"), 
            System.out::println);
    }
}