package hangman.model;
import hangman.exception.*;

/**
* @throws hangman.exception.InvalidException.
* @param correctCount - Cantidad de letras acertadas.
* @param incorrectCount - Cantidad de letras erroneas.
* @return puntaje de ahorcados.
*/
 
public interface GameScore {
	public int calculateScore(int correctCount,int incorrectCount) throws InvalidException;
	
	public default int getSocreInitial() {
		return 0;
	}
	
}