package programming2.chjapter11;

public class JoinDemo {

	public static void main(String[] args) throws InterruptedException {
		Runnable r = () -> {
			try {
				long n = (long) (Math.random()*10.0) * 1000;
				Thread.sleep(n);
				System.out.println("Thread " + Thread.currentThread().getName() + " finished.");
			} catch (Exception e) {
			}
		};
		Thread[] threads = {
				new Thread(r), new Thread(r), new Thread(r)
		};
		
		for (Thread t : threads) {
			t.start();
		}
		for (Thread t : threads) {
			System.out.println("joining " + t.getName());
			t.join();
			System.out.println("joined " + t.getName());
		}
		System.out.println("all done!");
	}

}
