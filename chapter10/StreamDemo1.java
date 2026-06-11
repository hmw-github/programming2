package chapter10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo1 {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
        		new Person("Anna", 21),
        		new Person("Rajesh", 17),
        		new Person("Neeta", 25));
        
        /**
         * 1. Filter the person of legal age
         * 2. sort by age ascending
         * 3. add persons to a list called "adults"
         * 4. output all persons to the console
         */
        
        // formulate with Stream/Lambdas
        List<Person> adults = 
        persons.stream()
        .filter(p -> p.getAge() >= 18)
        .sorted((p1, p2) -> p1.getAge() - p2.getAge())
        .collect(Collectors.toList());
        adults.stream()
        .forEach(System.out::println);
        
        // formulate without Stream/Lambdas
        List<Person> adults2 = new ArrayList<>();
        for (Person p : persons) {
        	if (p.getAge() >= 18) {
        		adults2.add(p);
        	}
        }
        adults2.sort(new Comparator<Person>() {
        	public int compare(Person p1, Person p2) {
        		return p1.getAge() - p2.getAge();
        	}
        });
        for (Person p : adults2) {
        	System.out.println(p);
        }
    }
}
