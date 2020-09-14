package lambda.function;

import java.util.function.Function;

public class FunctionExample {
	static Function<String, String> f1 = name -> name.toUpperCase();
	static Function<String, String> f2 = name -> name.toUpperCase() + " features";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(f1.apply("scsc"));
		System.out.println(Function.identity().apply("scsc"));

		// f1 will be processed first and the result will be passed to f2. So the result
		// is JAVA features
		System.out.println(f1.andThen(f2).apply("java"));

		// f2 will be processed first and the result will be passed to f1. So the result
		// is JAVA FEATURES
		System.out.println(f1.compose(f2).apply("java"));

	}

}
