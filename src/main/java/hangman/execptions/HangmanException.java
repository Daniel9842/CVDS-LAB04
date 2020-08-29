  
package hangman.exceptions;

public class HangmanException extends Exception {
	public static final String INVALIDARGUMENT="the argument is invalid";

	public HangmanException(String message) {
		super(message);
	}

}