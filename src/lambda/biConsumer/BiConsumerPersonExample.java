package lambda.biConsumer;

import java.util.List;
import java.util.function.BiConsumer;

import repo.Person;
import repo.PersonRepo;

public class BiConsumerPersonExample {

	static void printPersonDetails() {
		BiConsumer<String, List<String>> personConsumer = (name, hobbies) -> System.out.println(name + " " + hobbies);
		BiConsumer<String, Double> personSalary = (name, salary) -> System.out.println(name + "'s Salary " + salary);
		List<Person> personList = PersonRepo.getAllPersons();
		// personList.forEach(person -> personConsumer.accept(person.getName(),
		// person.getHobbies()));
		personList.forEach(person -> {
			// We cannot use andThen since both the consumers does not have same parameters
			personConsumer.accept(person.getName(), person.getHobbies());
			personSalary.accept(person.getName(), person.getSalary());
		});
	}

	public static void main(String[] args) {
		printPersonDetails();
		// TODO Auto-generated method stub

	}

}
