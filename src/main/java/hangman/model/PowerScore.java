package hangman.model;
import hangman.exceptions.HangmanException;

public class PowerScore implements GameScore {
	/**
	* @throws hangman.exceptions.HangmanException
	* @pre Se inicia con 0 puntos.
	* @pos Puntaje no es mayor a 500.
	* @param correctCount - Cantidad de letras acertadas.
	* @param incorrectCount - Cantidad de letras erroneas
	* @return puntaje bonus power de ahorcados.
	*/
	public int calculateScore(int correctCount, int incorrectCount) throws HangmanException {
		int scorePower = 0;	
		if (correctCount > 0) {
			for (int i = 1; i <= correctCount; i++) {
				scorePower = Math.pow(5,i);
			}
		} else if (incorrectCount > 0) {
			if (scorePower < 0) {
				scorePower = 0;
			} else {
				scorePower = scorePower - (incorrectCount * 8);
			}
		} else if (scorePower < 0) {
			scorePower = 0;
		} else if (scorePower > 500) {
			scorePower = 500;
		} else if(correctCount < 0 || incorrectCount < 0) {
			throw new HangmanException(HangmanException.INVALIDARGUMENT);
		}
		return scorePower;
	}
}