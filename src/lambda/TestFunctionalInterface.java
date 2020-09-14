package lambda;

//Optional Annotation
@FunctionalInterface
public interface TestFunctionalInterface {

	/*
	 * Even if we doesn't add annotation it works but it acts as normal interface
	 * i.e it can have more than one abstract function i.e subtract method is
	 * allowed
	 */
	// One abstract method
	public void add();

	/*
	 * Throws error if we add Annotation bcoz a fn interface can have one abstract
	 * method
	 */
	// public void subtract();

	default String sayHi() {
		return "Hi";
	}

	static boolean isTrue() {
		return true;
	}
}
