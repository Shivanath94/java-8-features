package lambda.streams;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Supplier;

import repo.Person;
import repo.PersonRepo;

public class StreamFilterMapReduceExample {

	static Supplier<List<Person>> personList = () -> PersonRepo.getAllPersons();

	static BiPredicate<Integer, String> predicate = (height, gender) -> height.intValue() >= 140
			&& gender.equals("Male");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(
				"Total Number of Kids: " + personList.get().stream().map(Person::getKids).reduce(0, Integer::sum));
		System.out.println("Total Number of Kids: "
				+ personList.get().stream().filter(pre -> predicate.test(new Integer(pre.getHeight()), pre.getGender()))
						.map(Person::getKids).reduce(0, Integer::sum));

	}

}
