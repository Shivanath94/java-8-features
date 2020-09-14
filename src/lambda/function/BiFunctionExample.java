package lambda.function;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import repo.Person;
import repo.PersonRepo;

public class BiFunctionExample {
	static Predicate<Person> equal140Height = per -> per.getHeight() == 140;
	static BiFunction<String, String, String> biFunction = (a, b) -> (a + " " + b);
	static Predicate<Person> isMale = per -> per.getGender().equals("Male");
	static BiFunction<List<Person>, Predicate<Person>, Map<String, Double>> maleSalaryFunction = (personList,
			predicate) -> {
		Map<String, Double> salaryMap = new HashMap<String, Double>();
		personList.forEach(person -> {
			if (isMale.test(person))
				salaryMap.put(person.getName(), person.getSalary());
		});
		return salaryMap;
	};

	static BiFunction<List<Person>, Predicate<Person>, Map<String, Double>> maleWith140HeightBiFunction = (personList,
			predicate) -> {
		Map<String, Double> salaryMap = new HashMap<String, Double>();
		personList.forEach(person -> {
			if (equal140Height.and(predicate).test(person))
				salaryMap.put(person.getName(), person.getSalary());
		});
		return salaryMap;
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Person> personList = PersonRepo.getAllPersons();
		System.out.println("Simple Bi Function");
		System.out.println(biFunction.apply("Java", "features"));
		System.out.println("\nMale Salary Details Bi Function");
		System.out.println(maleSalaryFunction.apply(personList, isMale));
		System.out.println("\nMale with 140 Height Salary Details Bi Function");
		System.out.println(maleWith140HeightBiFunction.apply(personList, isMale));
	}

}
