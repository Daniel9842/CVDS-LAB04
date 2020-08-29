package hangman.model;
import hangman.exceptions.*;

public class BonusScore implements GameScore {
	/**
	* @throws hangman.exceptions.*
	* @pre Se inicia con 0 puntos.
	* @pos Puntaje no es menor a 0.
	* @param correctCount - Cantidad de letras acertadas.
	* @param incorrectCount - Cantidad de letras erroneas
	* @return puntaje bonus de ahorcados.
	*/
	public int calculateScore(int correctCount, int incorrectCount) throws HangmanException{
		int scoreBonus = 0;	
		if (correctCount > 0) {
			scoreBonus = scoreBonus + (correctCount * 10); 
		} else if (incorrectCount > 0) {
			if (scoreBonus < 0) {
				scoreBonus = 0;
			} else {
				scoreBonus = scoreBonus - (incorrectCount * 5);
			}
		} else if(correctCount < 0 || incorrectCount < 0) {
			throw new HangmanException(HangmanException.INVALIDARGUMENT);
		}
		return scoreBonus;
	}             
}