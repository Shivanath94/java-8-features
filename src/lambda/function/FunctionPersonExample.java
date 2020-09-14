package lambda.function;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import repo.Person;
import repo.PersonRepo;

public class FunctionPersonExample {

	static Predicate<Person> equal140Height = per -> per.getHeight() == 140;
	static Predicate<Person> isMale = per -> per.getGender().equals("Male");

	static Function<String, Integer> nameLengthFn = name -> name.length();

	static BiConsumer<Person, Map<String, Double>> biConsumer = (person, salaryMap) -> {
		if (isMale.and(equal140Height).test(person)) {
			salaryMap.put(person.getName(), person.getSalary());
		}
	};

	static Consumer<Person> nameLengthConsumer = person -> {
		System.out.println(nameLengthFn.apply(person.getName()));
	};

	static Consumer<Person> nameConsumer = person -> {
		System.out.print(person.getName() + " ");
	};

	static Function<List<Person>, Map<String, Double>> salaryFunction = personList -> {
		Map<String, Double> salaryMap = new HashMap<>();
		personList.forEach(person -> biConsumer.accept(person, salaryMap));
		return salaryMap;
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Person> personList = PersonRepo.getAllPersons();
		personList.forEach(nameConsumer.andThen(nameLengthConsumer));
		System.out.println("Salary Of Male with height 140: " + salaryFunction.apply(personList));
	}

}
