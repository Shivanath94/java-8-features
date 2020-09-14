package lambda.consumer;

import java.util.function.Consumer;

public class ConsumerExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Consumer<String> c1 = (s) -> {
			System.out.println(s.toUpperCase());
		};
		// c1.accept("Shiva");

		Consumer<String> c2 = (s) -> System.out.println(s.toLowerCase());
		// c2.accept("Shiva");

		/*
		 * andThen() method is used to perform multiple implementation of accept for
		 * same input
		 */
		c1.andThen(c2).accept("ShiVaa");
	}

}
