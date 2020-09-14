package lambda.streams.numericStream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreamBoxingUnBoxingExample {

	static List<Integer> boxingMethod() {
		return IntStream.rangeClosed(1, 50)// Stream of int Elements
				.boxed()// Wrapping int to Integer Objects
				.collect(Collectors.toList());
	}

	static int calculateSum(List<Integer> integerList) {
		return integerList.stream()// Stream of Integer
				.mapToInt(Integer::intValue)// Unboxing Converting Wrapper Integer into int type
				.sum();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Sum of Integer: " + calculateSum(boxingMethod()));
	}

}
