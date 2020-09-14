package lambda.predicate;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

import repo.Person;
import repo.PersonRepo;

public class PredicatePersonExample {

	static Predicate<Person> equal140Height = per -> per.getHeight() == 140;
	static Predicate<Person> isMale = per -> per.getGender().equals("Male");

	static Predicate<Person> greaterThan = per -> per.getHeight() > 100;
	static Predicate<Person> lessThan = per -> per.getHeight() < 150;

	static Consumer<Person> consumer = person -> System.out.println(person);
	static BiConsumer<String, List<String>> biConsumer = (name, hobbies) -> System.out.println(name + " " + hobbies);

	static Consumer<Person> consumerWithPredicate = person -> {
		if (greaterThan.and(lessThan).test(person)) {
			biConsumer.accept(person.getName(), person.getHobbies());
		}
	};

	static BiPredicate<Double, String> male140Height = (height, gender) -> height == 140 && gender.equals("Male");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Person> personList = PersonRepo.getAllPersons();
		System.out.println("All Male Details: ");
		personList.stream().filter(isMale).forEach(consumer);
		System.out.println("\nAll Persons Details with Height 140: ");
		personList.stream().filter(equal140Height).forEach(consumer);
		System.out.println("\nAll Persons with Height in range 100 and 140: ");
		personList.stream().filter(greaterThan.and(lessThan)).forEach(consumer);
		System.out.println("\nAll Male Details and Hobbies: ");
		personList.stream().filter(isMale).forEach(person -> biConsumer.accept(person.getName(), person.getHobbies()));
		System.out.println("\nAll Persons with Height in range 100 and 140 using Consumer & Predicate: ");
		personList.forEach(consumerWithPredicate);
		System.out.println("\nMale Detail with height 140 Using BiPredicate: ");
		personList.stream().filter(pre -> male140Height.test(new Double(pre.getHeight()), pre.getGender()))
				.forEach(consumer);

	}

}
