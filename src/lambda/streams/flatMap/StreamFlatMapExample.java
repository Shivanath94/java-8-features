package lambda.streams.flatMap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import repo.Person;
import repo.PersonRepo;

public class StreamFlatMapExample {

	static Supplier<List<Person>> personList = () -> PersonRepo.getAllPersons();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> oddNumber = Arrays.asList(1, 3, 5, 7, 9);
		List<Integer> evenNumber = Arrays.asList(2, 4, 6, 8);

		List<List<Integer>> numberList = Arrays.asList(oddNumber, evenNumber);
		System.out.println("Before Flattening" + numberList);
		System.out.println(
				"After Flattening" + numberList.stream().flatMap(list -> list.stream()).collect(Collectors.toList()));

		System.out.println("\nHobbies in Person Repo:" + personList.get()// Geting value from supplier
				.stream()// Stream of Persons
				.map(Person::getHobbies)// Getting only the Hobbies List of a Person
				.flatMap(List::stream)// Converting List<String> to Stream<String>
				.distinct()// Removing Duplicate Hobbies
				.collect(Collectors.toList()));

		System.out.println("\nHobbies Sorted in Person Repo:" + personList.get()// Geting value from supplier
				.stream()// Stream of Persons
				.map(Person::getHobbies)// Getting only the Hobbies List of a Person
				.flatMap(List::stream)// Converting List<String> to Stream<String>
				.sorted()// Sorting the Hobbies
				.distinct()// Removing Duplicate Hobbies
				.collect(Collectors.toList()));

		System.out.println("\nHobbies Count in Person Repo:" + personList.get()// Geting value from supplier
				.stream()// Stream of Persons
				.map(Person::getHobbies)// Getting only the Hobbies List of a Person
				.flatMap(List::stream)// Converting List<String> to Stream<String>
				.sorted()// Sorting the Hobbies
				.distinct()// Removing Duplicate Hobbies
				.count());

		System.out.println("\nSorting Person based on Name:");
		personList.get()// Geting value from supplier
				.stream()// Stream of Persons
				.sorted(Comparator.comparing(Person::getName))// Sorting Based on Name
				.forEach(System.out::println);// Printing Each Person

		System.out.println("\nSorting Person based on Height:");
		personList.get()// Geting value from supplier
				.stream()// Stream of Persons
				.sorted(Comparator.comparing(Person::getHeight))// Sorting Based on Height
				.forEach(System.out::println);// Printing Each Person

		System.out.println("\nSorting Person based on Height:");
		personList.get()// Geting value from supplier
				.stream()// Stream of Persons
				.sorted(Comparator.comparing(Person::getHeight).reversed())// Sorting Based on Height in reverse
				.forEach(System.out::println);// Printing Each Person
	}
}
