package lambda.function;

import java.util.List;
import java.util.function.Supplier;

import repo.Person;
import repo.PersonRepo;

public class SupplierExample {

	static Supplier<List<Person>> personListSupplier = () -> PersonRepo.getAllPersons();
	static Supplier<Person> personSupplier = () -> PersonRepo.getPerson();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Person> personList = PersonRepo.getAllPersons();
		System.out.println(personListSupplier.get());
	}

}
