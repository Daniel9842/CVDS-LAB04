package hangman.exception;
 
public class InvalidException extends Exception {
	public static final String INVALID="Este argumento es invalido.";

	public InvalidException(String message) {
		super(message);
	}

}