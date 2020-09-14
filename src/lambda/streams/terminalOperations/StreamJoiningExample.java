package lambda.streams.terminalOperations;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import repo.Person;
import repo.PersonRepo;

public class StreamJoiningExample {

	static String joiningExample() {
		String s = PersonRepo.getAllPersons().stream().map(Person::getName)
				// .collect(Collectors.joining());
				// .collect(Collectors.joining("-"));
				.collect(Collectors.joining("-", "[", "]"));
		return s;
	}

	public static void main(String[] args) {
		char[] ch = { 'a', 'b', 'c', 'd', 'e' };
		String join = Stream.of(ch).map(arr -> new String(arr)).collect(Collectors.joining("-", "[", "]"));
		// System.out.println("Joined Data :"+join);
		System.out.println("Joining Output :" + joiningExample());
	}

}
