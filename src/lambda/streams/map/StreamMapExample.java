package lambda.streams.map;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import repo.Person;
import repo.PersonRepo;

public class StreamMapExample {

	static List<String> toUpperTransform(List<Person> personsList) {
		return personsList.stream().map(Person::getName).map(String::toUpperCase).collect(Collectors.toList());

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> fruits = Arrays.asList("apple", "orange", "pineapple", "banana");
		System.out.println(fruits.stream().map(String::length).collect(Collectors.toList()));
		System.out.println("Uppercase Names: " + toUpperTransform(PersonRepo.getAllPersons()));
	}

}
