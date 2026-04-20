package chapter3.paymentexercise.processors;

abstract public class PaymentProcessor {
	protected final String ownerName;
	
	public PaymentProcessor(String ownerName) {
		this.ownerName = ownerName;
	}
	
	// subclasses need to implement these methods
	abstract public boolean validate();
	abstract public void executePayment(double amount);
	abstract public String getPaymentMethod();
	abstract public double getTransactionFee(double amount);
	
	/**
	 * Steps:
	 * 1. Validation of source data (e.g. IBAN)
	 * 2. Process payment – here: just a dummy output to the console
	 * 3. Issuing a confirmation containing the underlying data
	 * @param amount
	 */
	final public void process(double amount) {
		if (!validate()) {
			String msg = "Validation failed for " 
					+ getPaymentMethod() + " (Owner: " + ownerName + " )";
			throw new RuntimeException(msg);
		}
		executePayment(amount);
		printReceipt(amount);
	}
	
	public void printReceipt(double amount) {
		double fee = getTransactionFee(amount);

		System.out.println("=== Receipt ===");
		System.out.printf("Owner:   %s%n", ownerName);
		System.out.printf("Method:  %s%n", getPaymentMethod());
		System.out.printf("Amount:  €%.2f%n", amount);
		System.out.printf("Fee:     €%.2f%n", fee);
		System.out.printf("Total:   €%.2f%n", amount + fee);
		System.out.println("Status:  Success");
		System.out.println();
	}

}
