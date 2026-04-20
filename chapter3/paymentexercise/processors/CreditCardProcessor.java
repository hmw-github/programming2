package chapter3.paymentexercise.processors;

import java.time.Year;

public class CreditCardProcessor extends PaymentProcessor {
	private String cardNumber;
	private int expiryYear;
	
	public CreditCardProcessor(String ownerName, String cardNumber, int expiryYear) {
		super(ownerName);
		this.cardNumber = cardNumber;
		this.expiryYear = expiryYear;
	}

	@Override
	/*
	 * The card number must be 16 digits long, 
	 * and the expiry year must be ≥ the current year
	 */
	public boolean validate() {
		int currentYear = Year.now().getValue();
		
		// need 16 digits
		if (cardNumber.length() != 16) {
			return false;
		}
		
		// all digits
		for (int i = 0; i < cardNumber.length(); ++i) {
			char c = cardNumber.charAt(i);
			
			if (c < '0' || c > '9') {
				return false;
			}
//			if (!Character.isDigit(c)) {
//				return false;
//			}
		}
		
		if (expiryYear < currentYear) {
			return false;
		}
		
		return true;
	}

	@Override
	public void executePayment(double amount) {
		System.out.printf("[%s] Charging card %s\n", 
				getPaymentMethod(), 
				cardNumber.substring(cardNumber.length()-4));
		
	}

	@Override
	public String getPaymentMethod() {
		return "Credit Card";
	}

	@Override
	public double getTransactionFee(double amount) {
		return amount * 0.035; // 3,5 %
	}

}
