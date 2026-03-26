package chapter2;

public class ParameterDemo {

	private int count = 19;
	
	public void setCount(int value) {
		count = value;
	}
	
	public int getCount() {
		return count;
	}
	
	public int f(int n, ParameterDemo p) {
		n = 999;
		p.setCount(666);
		
		return n + p.getCount();
	}
		
	public static void main(String[] args) {
		ParameterDemo pd = new ParameterDemo();
		
		int n = 17;
		int result = pd.f(n, pd);
		System.out.println(n + ", " + pd.getCount());
	}

}
