package lambda.streams;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import repo.Person;
import repo.PersonRepo;

public class SimpleStreamExample {

	static Supplier<List<Person>> personList = () -> PersonRepo.getAllPersons();

	public static void main(String[] args) {
		Stream<Integer> s1 = Stream.of(1, 2, 3, 4, 5, 6);
		s1.forEach(p -> System.out.println(p));
		Stream<Integer> s2 = Stream.of(new Integer[] { 1, 2, 3, 4, 5, 6 });
		s2.forEach(p -> System.out.println(p));

		Predicate<Person> p1 = (per) -> per.getHeight() >= 140;
		Predicate<Person> p2 = (per) -> per.getGender().equals("Male");

		Map<String, List<String>> personMap = personList.get()// List of Persons
				.stream()// Stream Of Persons
				.filter(p1.and(p2))// Stream of Persons
				.collect(Collectors.toMap(Person::getName, Person::getHobbies));

		System.out.println("Person Details: " + personMap);

		List<String> hobbiesList = personList.get()// List of Persons
				.stream()// Stream Of Persons
				.map(Person::getHobbies)// Stream<List<String>>
				.flatMap(List::stream)// Stream<String>
				.distinct()// Distinct Values
				.collect(Collectors.toList());

		System.out.println("Hobbies: " + hobbiesList);
	}

}
