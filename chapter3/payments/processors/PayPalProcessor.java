package chapter3.payments.processors;

public class PayPalProcessor extends PaymentProcessor {
	private String email;
	
	public PayPalProcessor(String ownerName, String email) {
		super(ownerName);
		this.email = email;
	}

	@Override
	// only check if email contains "@"
	public boolean validate() {
		return email.contains("@");
	}

	@Override
	public void executePayment(double amount) {
		System.out.printf("[%s] Sending payment request to %s...\n", 
				getPaymentMethod(), email);
	}

	@Override
	public String getPaymentMethod() {
		return "PayPal";
	}

	@Override
	public double getTransactionFee(double amount) {
		// add 2.5%
		return amount * 0.025;
	}

}
