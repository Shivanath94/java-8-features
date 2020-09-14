package lambda.methodReference;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class MethodReferenceExample {

	static Function<String, String> f1 = name -> name.toUpperCase();
	static Function<String, String> f2 = String::toUpperCase;

	static Predicate<Integer> p1 = a -> a > 50;
	static Predicate<Integer> p2 = MethodReferenceExample::checkValue;
	static BiPredicate<Integer, Integer> p3 = MethodReferenceExample::checkBothValue;

	public static void main(String[] args) {
		System.out.println("Traditional Way");
		System.out.println(MethodReferenceExample.compare(10, 20));
		System.out.println("Using Static Reference");
		Comparator<Integer> comp = MethodReferenceExample::compare;
		System.out.println(comp.compare(10, 20));
		System.out.println("Traditional Way Function Implementation");
		System.out.println(f1.apply("Shiva"));
		System.out.println("Using Static Reference in Function");
		System.out.println(f2.apply("Shiva"));
		System.out.println("Traditional Way Predicate Implementation");
		System.out.println(p1.test(10));
		System.out.println("Using Static Reference in Predicate");
		System.out.println(p2.test(10));
		System.out.println("Using Static Reference in BiPredicate");
		System.out.println(p3.test(50, 40));
	}

	public static int compare(Integer x, Integer y) {
		return Integer.compare(x, y);
	}

	public static boolean checkValue(Integer x) {
		return x > 50;
	}

	public static boolean checkBothValue(Integer x, Integer y) {
		return x > y;
	}
}
