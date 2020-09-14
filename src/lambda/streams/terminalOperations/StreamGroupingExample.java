package lambda.streams.terminalOperations;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import repo.Person;
import repo.PersonRepo;

public class StreamGroupingExample {

	static void groupByGender() {
		Map<String, List<Person>> groupedData = PersonRepo.getAllPersons().stream()
				.collect(Collectors.groupingBy(Person::getGender));
		groupedData.entrySet().forEach(val -> System.out.println("Key :" + val.getKey() + "/Value :" + val.getValue()));
	}

	static void groupByHeight() {
		Map<String, List<Person>> groupedData = PersonRepo.getAllPersons().stream()
				.collect(Collectors.groupingBy(per -> per.getHeight() >= 140 ? "Shortest" : "Tallest"));
		groupedData.entrySet().forEach(val -> System.out.println("Key :" + val.getKey() + "/Value :" + val.getValue()));
	}

	static void twoLevelGrouping() {
		Map<String, Map<String, List<Person>>> groupedData = PersonRepo.getAllPersons().stream().collect(Collectors
				.groupingBy(Person::getGender, groupingBy(per -> per.getHeight() >= 140 ? "Shortest" : "Tallest")));
		groupedData.entrySet().forEach(val -> System.out.println("Key :" + val.getKey() + "/Value :" + val.getValue()));
	}

	static void twoLevelGroupingCount() {
		Map<String, Integer> groupedData = PersonRepo.getAllPersons().stream()
				.collect(Collectors.groupingBy(Person::getName, summingInt(Person::getKids)));
		groupedData.entrySet().forEach(val -> System.out.println("Key :" + val.getKey() + "/Value :" + val.getValue()));
	}

	static void threeLevelGrouping() {
		Map<String, List<Person>> groupedData = PersonRepo.getAllPersons().stream()
				.collect(Collectors.groupingBy(Person::getName, HashMap::new, Collectors.toList()));
		groupedData.entrySet().forEach(val -> System.out.println("Key :" + val.getKey() + "/Value :" + val.getValue()));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		groupByGender();
		groupByHeight();
		twoLevelGrouping();
		twoLevelGroupingCount();
		threeLevelGrouping();

	}

}
