package hangman.model;

import java.lang.*;
import hangman.exception.InvalidException;

public class PowerScore implements GameScore {
	/**
	* @throws hangman.exceptions.HangmanException
	* @pre Se inicia con 0 puntos.
	* @pos Puntaje no es mayor a 500.
	* @param correctCount - Cantidad de letras acertadas.
	* @param incorrectCount - Cantidad de letras erroneas
	* @return puntaje bonus power de ahorcados.
	*/
	public int calculateScore(int correctCount, int incorrectCount) throws InvalidException {
		int scorePower = 0;	
		if (correctCount > 0) {
			scorePower = (int)Math.pow(5,correctCount);
		} if (incorrectCount > 0) {
			if (scorePower < 0) {
				scorePower = 0;
			} else {
				scorePower = scorePower - (incorrectCount * 8);
			}
		} if (scorePower <= 0) {
			scorePower = 0;
		} if (scorePower >= 500) {
			scorePower = 500;
		} if(correctCount < 0 || incorrectCount < 0) {
			throw new InvalidException(InvalidException.INVALID);
		}
		return scorePower;
	}
}