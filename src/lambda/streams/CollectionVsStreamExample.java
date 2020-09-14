package lambda.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import repo.Person;
import repo.PersonRepo;

public class CollectionVsStreamExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> names = Arrays.asList("Shiva", "Raaja", "Mani", "Kumar");

		for (String name : names) {
			System.out.println("Iteration 1: " + name);
		}

		for (String name : names) {
			System.out.println("Iteration 2: " + name);
		}

		Stream<String> streamList = names.stream();
		streamList.forEach(p -> System.out.println("<<<<<< :" + p));
		// Cannot Iterate more than once, will throw Illegal State Exception
		// streamList.forEach(p -> System.out.println("<<<<<< :" + p));

		List<String> personNames = PersonRepo.getAllPersons().stream()// Stream of Persons
				.peek(p -> System.out.println(p))/*
													 * Debug element in Streams which is used to see the value of
													 * element in Iterator
													 * 
													 * We can use multiple peeks
													 */
				.map(Person::getName).peek(System.out::println).collect(Collectors.toList());
		System.out.println(personNames);

	}

}
