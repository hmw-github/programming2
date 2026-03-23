package chapter2;

class Account {
	private int nr;

	public Account(int nr) {
		this.nr = nr;
	}

	public void print() {
		System.out.println("Account: nr=" + nr);
	}
}

public class Demo {
	public static void main(String[] args) {
		Account account1 = new Account(4711);
		account1.print();
		Account account2 = new Account(4712);
		account2.print();
	}
}