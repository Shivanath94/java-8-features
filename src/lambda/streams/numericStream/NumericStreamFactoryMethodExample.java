package lambda.streams.numericStream;

import java.util.stream.IntStream;

public class NumericStreamFactoryMethodExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntStream intStream1 = IntStream.rangeClosed(0, 6);// Last Element is included
		IntStream intStream2 = IntStream.range(0, 6);// Last Element is not included
		System.out.println("Range Closed :");
		intStream1.forEach(System.out::print);
		System.out.println("\nRange :");
		intStream2.forEach(System.out::print);

	}

}
