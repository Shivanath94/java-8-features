package lambda.predicate;

import java.util.function.Predicate;

public class PredicateExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Predicate<Integer> greaterThan = a -> a > 50;
		Predicate<Integer> lessThan = a -> a < 50;
		Predicate<Integer> equal = a -> a == 50;
		System.out.println("Predicate Greater than result: " + greaterThan.test(49));
		System.out.println("Predicate result: " + lessThan.test(49));
		System.out.println("Predicate result: " + equal.test(49));
		System.out.println("Negate Greater than Predicate result: " + greaterThan.negate().test(49));
		System.out.println("OR Greater than or Less than Predicate result: " + greaterThan.or(lessThan).test(49));
		System.out.println("AND Greater than and Less than Predicate result: " + greaterThan.and(lessThan).test(49));

	}

}
