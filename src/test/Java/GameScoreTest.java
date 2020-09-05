import hangman.exception.InvalidException;
import hangman.model.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;
 
/*
 * Clases de Equivalencia: 
 * OriginalScore
 * palabrasIncorrectas >=10, entonces el resultado 0.
 * palabrasIncorrectas >= 0 y palabrasIncorrectas <= 10, entonces el resultado = resultadoActual - (10 * palabrasIncorrectas).
 * palabrasCorrectas < 0 || palabrasIncorrectas < 0, entonces el resultado InvalidException.INVALID.
 *
 * BonusScore
 * palabrasCorrectas >=10, entonces el resultado = scoreBonusActual + (palabrasCorrectas * 10);
 * palabrasIncorrectas > 0, entonces (sí scoreBonus < 0, entonces el resultado es 0) ó (si scoreBonus > 0, entonces el resultado = resultadoActual - (10 * palabrasIncorrectas)).
 * palabrasCorrectas < 0 || palabrasIncorrectas < 0, entonces el resultado InvalidException.INVALID.
 *
 * PowerBonus
 * palabrasCorrectas = 0, entonces el resultado = scorePower + (5 ^ palabrasCorrectas).
 * palabrasIncorrectas > 0, entonces (si scorePower < 0, entonces el resultado es 0) ó (si scoreBonus > 0, entonces el resultado = resultadoActual - (incorrectCount * 8)).
 * resultadoActual <= 0, entonces el resultado = 0.
 * resultadoActual >= 500, entonces el resultado = 500.
 * palabrasCorrectas < 0 || palabrasIncorrectas < 0, entonces el resultado InvalidException.INVALID.
 *
 */

public class GameScoreTest {
/*ORIGINAL SCORE*/
	@Test
	public void frontierMaxScore() throws InvalidException {
		OriginalScore score0 = new OriginalScore();
		try {
			assertEquals(100,score0.calculateScore(2, 0));
			assertEquals(50,score0.calculateScore(2, 5));
	    
	    	} catch (InvalidException e) {
		        assertEquals(e.getMessage(),(InvalidException.INVALID));
		}
	}

	@Test
	public void frontierMinScore() throws InvalidException {
		OriginalScore score1 = new OriginalScore();
		try {
			assertEquals(0,score1.calculateScore(0, 24));
			assertEquals(0,score1.calculateScore(0, 11));
	    
	    	} catch (InvalidException e) {
		        assertEquals(e.getMessage(),(InvalidException.INVALID));
		}
	}

	@Test
	public void frontierExceptionOriginal() throws InvalidException {
		OriginalScore score2 = new OriginalScore();
		try {
			assertEquals(70,score2.calculateScore(-1, 3));
			assertEquals(100,score2.calculateScore(0, -3));
			assertEquals(100,score2.calculateScore(-2, -3));
	    
	    	} catch (InvalidException e) {
		        assertEquals(e.getMessage(),(InvalidException.INVALID));
		}
	}

/*BONUS SCORE*/
	@Test
	public void frontierScoreBonus() throws InvalidException {
		BonusScore score3 = new BonusScore();
		try {
			assertEquals(0,score3.calculateScore(0, 0));
			assertEquals(100,score3.calculateScore(10, 0));
			assertEquals(85,score3.calculateScore(10, 3));
	    
	    	} catch (InvalidException e) {
		        assertEquals(e.getMessage(),(InvalidException.INVALID));
		}
	}

	@Test
	public void frontierMinScoreBonus() throws InvalidException {
		BonusScore score4 = new BonusScore();
		try {
			assertEquals(0,score4.calculateScore(0, 10));
			assertEquals(0,score4.calculateScore(4, 14));
	    
	    	} catch (InvalidException e) {
		        assertEquals(e.getMessage(),(InvalidException.INVALID));
		}
	}

	@Test
	public void frontierExceptionBonus() throws InvalidException {
		BonusScore score5 = new BonusScore();
		try {
			assertEquals(0,score5.calculateScore(-1, -6));
			assertEquals(40,score5.calculateScore(4, -14));
			assertEquals(0,score5.calculateScore(-4, 1));
	    
	    	} catch (InvalidException e) {
		        assertEquals(e.getMessage(),(InvalidException.INVALID));
		}
	}

/*POWER SCORE*/
	@Test
	public void frontierScorePower() throws InvalidException {
		PowerScore score6 = new PowerScore();
		try {
			assertEquals(17,score6.calculateScore(2,1));
			assertEquals(101,score6.calculateScore(3,3));
	    
	    	} catch (InvalidException e) {
		        assertEquals(e.getMessage(),(InvalidException.INVALID));
		}
	}

	@Test
	public void frontierMaxScorePower() throws InvalidException {
		PowerScore score6 = new PowerScore();
		try {
			assertEquals(500,score6.calculateScore(12,0));
			assertEquals(500,score6.calculateScore(20,0));
	    
	    	} catch (InvalidException e) {
		        assertEquals(e.getMessage(),(InvalidException.INVALID));
		}
	}

	@Test
	public void frontierMinScorePower() throws InvalidException {
		PowerScore score7 = new PowerScore();
		try {
			assertEquals(0,score7.calculateScore(2,18));
			assertEquals(0,score7.calculateScore(1, 6));
	    
	    	} catch (InvalidException e) {
		        assertEquals(e.getMessage(),(InvalidException.INVALID));
		}
	}

	@Test
	public void frontierExceptionPower() throws InvalidException {
		PowerScore score8 = new PowerScore();
		try {
			assertEquals(0,score8.calculateScore(-3,-1));
			assertEquals(0,score8.calculateScore(-2,0));
			assertEquals(0,score8.calculateScore(-3,2));
	    
	    	} catch (InvalidException e) {
		        assertEquals(e.getMessage(),(InvalidException.INVALID));
		}
	}
}