package deloitte.day2;

public class InvalidAgeException extends Exception{
	
	private String message;
	
	public InvalidAgeException(String message) {
		
		super(message);
		
		this.message = message;
	}

}
