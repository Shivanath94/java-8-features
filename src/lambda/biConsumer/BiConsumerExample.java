package lambda.biConsumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerExample {
	public static void main(String[] args) {
		BiConsumer<Integer, Integer> addBi = (x, y) -> {
			System.out.println("Add: " + (x + y));
		};
		BiConsumer<Integer, Integer> subBi = (x, y) -> {
			System.out.println("Sub: " + (x - y));
		};
		BiConsumer<Integer, Integer> mulBi = (x, y) -> {
			System.out.println("Multiply: " + (x * y));
		};

		addBi.accept(10, 20);

		List<Integer> list1 = Arrays.asList(new Integer(10), new Integer(20), new Integer(30));
		List<Integer> list2 = Arrays.asList(new Integer(10), new Integer(20));

		BiConsumer<List<Integer>, List<Integer>> checkListBi = (x, y) -> System.out
				.println("Does list contains all elements: " + y.containsAll(x));

		checkListBi.accept(list2, list1);
		checkListBi.accept(list1, list2);

		addBi.andThen(subBi).andThen(mulBi).accept(10, 20);

	}
}
