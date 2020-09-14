package lambda;

import java.util.Comparator;

public class ComparatorLambda {
	public static void main(String[] args) {
		Comparator<Integer> c1 = new Comparator<Integer>() {

			@Override
			public int compare(Integer x, Integer y) {
				// TODO Auto-generated method stub
				return x.compareTo(y);
			}

		};

		System.out.println("Comparator Basic : " + c1.compare(15, 20));

		// Using Lambda
		Comparator<Integer> c2 = (Integer x, Integer y) -> x.compareTo(y);
		System.out.println("Comparator With Lambda : " + c2.compare(20, 20));

		// Using Lambda It can automatically identify the type from the declaration
		Comparator<Integer> c3 = (x, y) -> x.compareTo(y);
		System.out.println("Comparator With Lambda Adv : " + c3.compare(21, 20));

	}
}
