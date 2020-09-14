package lambda.streams.terminalOperations;

import static java.util.stream.Collectors.mapping;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import repo.Person;
import repo.PersonRepo;

public class StreamMappingExample {

	static List<String> mappingName() {
		List<String> names = PersonRepo.getAllPersons().stream().map(Person::getName).collect(Collectors.toList());

		List<String> names1 = PersonRepo.getAllPersons().stream()
				.collect(mapping(Person::getName, Collectors.toList()));
		return names1;
	}

	static Set<String> mappingName1() {
		List<String> names = PersonRepo.getAllPersons().stream().map(Person::getName).collect(Collectors.toList());

		Set<String> names1 = PersonRepo.getAllPersons().stream().collect(mapping(Person::getName, Collectors.toSet()));
		return names1;
	}

	static long countTallPersons() {
		return PersonRepo.getAllPersons().stream().filter(per -> per.getHeight() >= 140).collect(Collectors.counting());
	}

	public static void main(String[] args) {
		mappingName().forEach(System.out::println);
		mappingName1().forEach(System.out::println);
		System.out.println("Total person count :" + countTallPersons());
	}
}
