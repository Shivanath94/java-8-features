package lambda.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import repo.Person;
import repo.PersonRepo;

public class StreamAllMatchAnyMatchExample {

	static Predicate<String> predicate = fruit -> fruit.length() > 5;
	static Predicate<Person> genderPredicate = person -> person.getGender().equals("Male");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> fruitsList = Arrays.asList("apple", "orange", "pineapple", "guaua", "banana");
		System.out.println("All Match result: " + fruitsList.stream().allMatch(predicate));
		System.out.println("Any Match result: " + fruitsList.stream().anyMatch(predicate));

		System.out.println("Person Any Match result: " + PersonRepo.getAllPersons().stream().anyMatch(genderPredicate));
		System.out.println("Person All Match result: " + PersonRepo.getAllPersons().stream().allMatch(genderPredicate));

	}

}
