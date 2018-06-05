package model;

import modelinterfaces.IScore;

/**
 * <h1>The Score class.</h1> Allows the user to store its score.
 * 
 * @author Ryo SHIINA
 *
 */
public class Score implements IScore {
	private int scoreValue;

	/**
	 *
	 * @return a scoreValue
	 */
	@Override
	public int getScoreValue() {
		return this.scoreValue;
	}

	@Override
	public void setScoreValue(final int scoreValue) {
		this.scoreValue = scoreValue;
	}

	@Override
	public void addToScoreValue(final int value) {
		this.setScoreValue(this.getScoreValue() + value);
	}

	@Override
	public void resetScoreValue() {
		this.setScoreValue(0);
	}
}
