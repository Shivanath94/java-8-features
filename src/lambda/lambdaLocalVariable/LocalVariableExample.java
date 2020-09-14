package lambda.lambdaLocalVariable;

import java.util.function.Consumer;

public class LocalVariableExample {
	static int k = 15;

	public static void main(String[] args) {
		int i = 10;
		Consumer<Integer> con = j -> {
			// i local variable cannot be incremented
			// i++;

			// k class variable or instance variable can be accessed and modified
			k = k + j;
			System.out.println(k);
			// i can be accessed
			System.out.println(i);
		};
		con.accept(50);
	}
}
