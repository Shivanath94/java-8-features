package lambda.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import repo.Person;
import repo.PersonRepo;

public class StreamMinMaxByExample {

	static Supplier<List<Person>> personList = () -> PersonRepo.getAllPersons();

	static Optional<Person> getTallestPerson() {
		return personList.get().stream().collect(Collectors.maxBy(Comparator.comparing(Person::getHeight)));
	}

	static Optional<Person> getMinSalaryPerson() {
		return personList.get().stream().collect(Collectors.minBy(Comparator.comparing(Person::getSalary)));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Tallest Person Detail :\n" + getTallestPerson().get());
		System.out.println("Minimum Salary Person Detail :\n" + getMinSalaryPerson().get());
	}

}
