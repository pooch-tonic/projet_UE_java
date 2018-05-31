package model;

public class Score {
	private int scoreValue;

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
