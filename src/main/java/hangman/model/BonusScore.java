package hangman.model;
import hangman.exception.InvalidException;
 
public class BonusScore implements GameScore {
	/**
	* @throws hangman.exception.InvalidException
	* @pre Se inicia con 0 puntos.
	* @pos Puntaje no es menor a 0.
	* @param correctCount - Cantidad de letras acertadas.
	* @param incorrectCount - Cantidad de letras erroneas.
	* @return puntaje bonus de ahorcados.
	*/
	public int calculateScore(int correctCount, int incorrectCount) throws InvalidException{
		int scoreBonus = 0;
		if (correctCount > 0) {
			scoreBonus = scoreBonus + (correctCount * 10); 
		} if (incorrectCount > 0) {
			if (scoreBonus > 0) {
				scoreBonus = scoreBonus - (incorrectCount * 5);
			} if (scoreBonus < 0) {
				scoreBonus = 0;
			}
		} if (correctCount < 0 || incorrectCount < 0) {
			throw new InvalidException(InvalidException.INVALID);
		}
		return scoreBonus;
	}             
}