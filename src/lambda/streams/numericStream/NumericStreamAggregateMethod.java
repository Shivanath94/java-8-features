package lambda.streams.numericStream;

import java.util.stream.IntStream;

public class NumericStreamAggregateMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntStream intStream1 = IntStream.rangeClosed(1, 50);
		// System.out.println("Sum :" + intStream1.sum());
		// System.out.println("Min :" + intStream1.min());
		// System.out.println("Max :" + intStream1.max().getAsInt());
		System.out.println("Average :" + intStream1.average().getAsDouble());
	}

}
