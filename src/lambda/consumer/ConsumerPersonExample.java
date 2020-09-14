package lambda.consumer;

import java.util.List;
import java.util.function.Consumer;

import repo.Person;
import repo.PersonRepo;

public class ConsumerPersonExample {

	static List<Person> personList = PersonRepo.getAllPersons();
	static Consumer<Person> c1 = p -> System.out.println(p);
	static Consumer<Person> c2 = p -> System.out.println(p.getName().toUpperCase());
	static Consumer<Person> c3 = p -> System.out.println(p.getHobbies());

	static void printName(Person person) {
		c2.accept(person);
	}

	static void printNameAndHobbies(Person person) {
		c2.andThen(c3).accept(person);
	}

	static void printPersonDetails(Person person) {
		c1.accept(person);
	}

	static void printAllPersonDetails() {
		// Accepts Parameter as Consumer
		personList.forEach(c1);
	}

	static void printMaleDetails() {
		personList.forEach(p -> {
			if (p.getGender().equals("Male")) {
				c1.accept(p);
			}
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Person> personList = PersonRepo.getAllPersons();
		Person person = PersonRepo.getPerson();
		// c1.accept(person);
		// c1.andThen(c2).accept(person);
		// c1.andThen(c2).andThen(c3).accept(person);
		System.out.print("Person Details: ");
		printPersonDetails(person);
		System.out.print("Person Name: ");
		printName(person);
		System.out.print("Person Name and Hobbies: ");
		printNameAndHobbies(person);
		System.out.print("All Person Details: ");
		printAllPersonDetails();
		System.out.println("Male Details: ");
		printMaleDetails();
	}

}
