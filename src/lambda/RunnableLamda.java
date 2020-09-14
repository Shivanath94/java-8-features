package lambda;

public class RunnableLamda {
	public static void main(String[] args) {

		// Normal Execution
		Runnable t1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread 1");
			}
		};

		new Thread(t1).start();

		// Using Lambda
		Runnable t2 = () -> {
			System.out.println("Thread 2");
		};
		new Thread(t2).start();

		// Using Lambda
		new Thread(() -> {
			System.out.println("Thread 3");
		}).start();
	}

}
