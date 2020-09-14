package lambda.streams.reduce;

import java.util.Arrays;
import java.util.List;

import repo.Person;
import repo.PersonRepo;

public class StreamReduceExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println("\nSum Result " + integerList.stream().mapToInt(i -> i).sum());
		System.out.println("\nCount " + integerList.stream().mapToInt(i -> i).count());

		System.out.println("\nProduct " + integerList.stream().reduce(1, (a, b) -> a * b));
		System.out.println("\nSum using Reduce " + integerList.stream().reduce(0, (a, b) -> a + b));
		System.out.println("\nSum using Reduce First Value is used from reduce (i.e) 1 "
				+ integerList.stream().reduce(1, (a, b) -> a + b));

		System.out.println("\nNames in Person Repo" + PersonRepo.getAllPersons().stream().map(Person::getName)
				.reduce("", (a, b) -> a.concat("\n").concat(b)));

		System.out.println("\nTallest in Person Repo\n"
				+ PersonRepo.getAllPersons().stream().reduce((x, y) -> x.getHeight() > y.getHeight() ? x : y));

	}

}
