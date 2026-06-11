package chapter10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamDemo2 {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
        		new Person("Anna", 21),
        		new Person("Rajesh", 17),
        		new Person("Neeta", 25));
        
        /**
         * 1. Filter the person of legal age
         * 2. sort by age ascending
         * 3. add persons to a map called "adultsMap"
         * 4. output all persons to the console
         */
        
        // formulate with Stream/Lambdas
        Map<String, Person> adults = 
            persons.stream()
            .filter(p -> p.getAge() >= 18) 
            .collect(Collectors.toMap(
            		p -> p.getName(), // key mapper
            		p -> p)); // value mapper
        adults.values()
        .stream()
        .sorted((p1, p2) -> p1.getAge() - p2.getAge())
        .forEach(System.out::println);
        
        // formulate without Stream/Lambdas
        Map<String, Person> adults2 = new HashMap<>();
        for (Person p : persons) {
        	if (p.getAge() >= 18) {
        		adults2.put(p.getName(), p);
        	}
        }
                
        List<Person> personList = new ArrayList<>(adults2.values());
        personList.sort(new Comparator<Person>() {
        	public int compare(Person p1, Person p2) {
        		return p1.getAge() - p2.getAge();
        	}
        });
        for (Person p : personList) {
        	System.out.println(p);
        }
    }
}
