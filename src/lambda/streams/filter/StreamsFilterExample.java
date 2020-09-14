package lambda.streams.filter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamsFilterExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> nameList = Arrays.asList("Shiva", "Ram", "Raaaju", "Ragu");

		Stream<String> nameStream = nameList.stream();
		System.out.println("All Name List: ");
		nameStream.forEach(System.out::println);
		Stream<String> filteredNameStream = nameList.stream().filter(val -> val.length() > 3);
		System.out.println("\nFiltered Name List: ");
		filteredNameStream.forEach(System.out::println);

	}

}
