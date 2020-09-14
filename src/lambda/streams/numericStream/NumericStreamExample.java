package lambda.streams.numericStream;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;

public class NumericStreamExample {

	static BinaryOperator<Integer> operator = (x, y) -> x + y;

	static int calculateSum(List<Integer> intList) {
		// Not Effective Since Unboxing of Every Integer element will reduce the
		// performance
		return intList.stream().reduce(0, operator);
	}

	static int calculateSumWithStream(IntStream intStream) {
		return intStream.sum();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> integerList = Arrays.asList(4, 5, 6, 7, 8, 9, 7);
		System.out.println("Sum Of Integer List: " + calculateSum(integerList));

		IntStream intStream = IntStream.rangeClosed(1, 6);
		System.out.println("Sum Of Integer List using IntStream: " + calculateSumWithStream(intStream));
	}

}
