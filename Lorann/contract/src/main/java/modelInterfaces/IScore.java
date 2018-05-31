package modelInterfaces;

public interface IScore {
	public int getScoreValue();
	public void setScoreValue(int scoreValue);
	public void addToScoreValue(int value);
	public void resetScoreValue();
}
