package programming2.chapter2;

class Account {
	int accountNumber;
	int pin;
	float accountBalance;

	void deposit(float amount) {
		// add amount to balance
		accountBalance += amount;
	}
	
	void print() {
		System.out.println("Account: accountNumber = " 
				+ accountNumber + ", pin = "
				+ pin + ", accountBalance = " + accountBalance);
	}

	// Constructor
	Account(int accountNumber, int pin, float initialBalance) {
		this.accountNumber = accountNumber;
		this.pin = pin;
		accountBalance = initialBalance;
	}
}

public class AccountDemo {
	public static void main(String[] args) {
		Account annasAccount = new Account(4711, 1234, 50.0f);
		annasAccount.deposit(100.0f);
		Account rajeshsAccount = new Account(4712, 9876, 50.0f);
		rajeshsAccount.deposit(200.0f);
		rajeshsAccount.print();
		rajeshsAccount.accountNumber = 1111;
	}
}
