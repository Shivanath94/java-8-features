package lambda.streams;

import java.util.function.Predicate;

import repo.Person;
import repo.PersonRepo;

public class StreamFindAnyFindFirstExample {
	static Predicate<String> namePredicate = name -> name.length() >= 4;
	static Predicate<Person> heightPredicate = person -> person.getHeight() >= 140;
	static Predicate<Person> genderPredicate = person -> person.getGender().equals("Male");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Find Any Person With Height >= 140: "
				+ PersonRepo.getAllPersons().stream().filter(heightPredicate).findAny());

		System.out.println("Find First Female Person With Height >= 140: "
				+ PersonRepo.getAllPersons().stream().filter(heightPredicate.and(genderPredicate)).findFirst());
	}

}
