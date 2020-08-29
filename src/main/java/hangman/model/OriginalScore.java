package hangman.model;
import hangman.exceptions.*;

public class OriginalScore implements GameScore{
	/**
	* @throws hangman.exceptions.*
	* @pre Se inicia con 100 puntos.
	* @pos Puntaje no es mayor de cien.
	* @param correctCount - Cantidad de letras acertadas.
	* @param incorrectCount - Cantidad de letras erroneas
	* @return puntaje de ahorcados.
	*/
	
	public int calculateScore(int correctCount, int incorrectCount) throws HangmanException {
		int score = 100;
		
		if (incorrectCount >=10) {
			score = 0;
		} else if (incorrectCount > 0) {
			score = score - (10 * incorrectCount);
		} else if (correctCount < 0 || incorrectCount < 0) {
			throw new HangmanException(HangmanException.INVALIDARGUMENT);
		}
		return score;
	}
}