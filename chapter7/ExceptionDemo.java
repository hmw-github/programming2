package programming2.chapter7;

import java.io.IOException;

public class ExceptionDemo {

	public static void operation1(int n) throws Exception, IOException {
		if (n == 13) {	
			throw new Exception("O my: its 13!");
		}
	}
	
	public static void operation2(int n)  {
		if (n == 13) {	
			throw new RuntimeException("O my: its 13!");
		}
	}
	
	public static void main(String[] args) {
		try {
			operation1(13);
			operation2(13);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("error: " + e.getMessage());
		}
	}

}
