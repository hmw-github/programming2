package chapter2;

import static org.junit.Assert.assertThrows;

/**
 * An account can also...
 * - change the PIN, the old and the new PIN must be specified
 * - return its description as a string.
 */
class Account {
	// Attributes
	private int nr;
	private double balance;
	private int pin;

	// Constructor (CTOR)
	public Account(int nr) {
		this(nr, 50.0, -1); // CTOR chaining
	}
	
	public Account(int nr, double balance, int pin) {
		this.nr = nr;
		this.balance = balance;
		this.pin = pin;
	}
	
	public void print() {
		System.out.printf("nr=%06d, bal=%.2f, secret=%d\n", 
				nr, balance, pin);
	}
	
	// check if withdrawal would exceed limit of 1000
	public void withdraw(double amount) {
		if (balance - amount < 1000.0) {
			System.out.println("Balance not high enough!");
		} else {
			balance -= amount;			
		}
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public void changePin(int oldPin, int newPin) {
		if (pin == -1 || oldPin == pin) {
			pin = newPin;
		} else {
			throw new RuntimeException("Old pin not valid!");
		}
	}
	
	@Override
	public String toString() {
		String s = String.format("Account [nr=%06d, bal=%.2f, secret=%d]", 
				nr, balance, pin);
		return s;
	}
}

public class AccountDemo {
	public static void main(String[] args) {
		Account account1 = new Account(4711, 100.0, 1234);
		account1.print();
		Account account2 = new Account(4712, 10000.0, 5432);
		account2.print();
		Account account3 = new Account(4713);
		account3.print();
		account2.changePin(5432, 9999);
		account2.print();
		
		System.out.println(account2.toString());
		System.out.println(account2);
	}
}