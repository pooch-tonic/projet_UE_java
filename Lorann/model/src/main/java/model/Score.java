package model;

import modelInterfaces.IScore;

/**
 * @author Max Becerro
 *
 */
public class Score implements IScore{
	private int scoreValue;
	/**
	 * 
	 * @return a scoreValue
	 */
	public int getScoreValue() {
		return scoreValue;
	}

	public void setScoreValue(int scoreValue) {
		this.scoreValue = scoreValue;
	}
	
	public void addToScoreValue(int value) {
		this.setScoreValue(this.getScoreValue() + value);
	}
	
	public void resetScoreValue() {
		this.setScoreValue(0);
	}
}
