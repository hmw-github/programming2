package chapter7;

/**
 * Define an exception called ApplicationException, 
 * which stores an error message (‘message’) as well as a message 
 * that can be shown to the user (‘userMessage’). 
 * The toString method should output all attributes.
 */
public class ApplicationException extends Exception {
    // Attributes
	private String userMessage;

    // Constructor
	public ApplicationException(String message, String userMessage, Throwable cause) {
        super(message, cause);
        this.userMessage = userMessage;
	}
	
	public String getUserMessage() {
		return userMessage;
	}
	
	public String toString() {
		return "message = " + getMessage() + ", userMessage = " + userMessage;
	}
	
	static public void main(String[] args) {
		try {
			throw new ApplicationException("error 4711, we're hacked!", 
					"Don't worry, i got you covered!", 
					new NullPointerException());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
}
