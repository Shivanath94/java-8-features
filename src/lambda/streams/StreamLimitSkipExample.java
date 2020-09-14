package lambda.streams;

import java.util.Arrays;
import java.util.List;

public class StreamLimitSkipExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> fruitsList = Arrays.asList("apple", "orange", "pineapple", "guaua", "banana");
		List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6);
		System.out.println("Limited List:");
		fruitsList.stream().limit(2).forEach(System.out::println);

		int limitedSum = numberList.stream().limit(4).reduce(0, (x, y) -> (x + y));
		System.out.println("\nLimited Sum:" + limitedSum);// Sum of 1, 2, 3 and 4

		int skipSum = numberList.stream().skip(4).reduce(0, (x, y) -> (x + y));
		System.out.println("\nSkip Sum:" + skipSum);// Sum of 6 and 5

	}

}
