package lambda.function;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryBinaryExample {

	static UnaryOperator<String> u1 = name -> name.toUpperCase();
	static UnaryOperator<Integer> u2 = a -> a + 20;
	static Comparator<Integer> comparator = (a, b) -> a.compareTo(b);

	static BinaryOperator<Integer> b1 = (a, b) -> a + b;
	static BinaryOperator<Integer> b2 = BinaryOperator.maxBy((a, b) -> (a > b) ? 1 : (a == b) ? 0 : -1);
	static BinaryOperator<Integer> b3 = BinaryOperator.maxBy(comparator);
	static BinaryOperator<Integer> b4 = BinaryOperator.minBy(comparator);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(u1.apply("Shiva"));
		System.out.println(u2.apply(10));
		System.out.println(b1.apply(10, 15));
		System.out.println(b2.apply(10, 15));
		System.out.println("Max By");
		System.out.println(b3.apply(10, 15));
		System.out.println("Min By");
		System.out.println(b4.apply(10, 15));
	}

}
