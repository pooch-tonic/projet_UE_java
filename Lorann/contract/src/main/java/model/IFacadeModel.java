package model;

public interface IFacadeModel {
	public ILevel getLevel();
	public int getScorValue();
	public void addToScoreValue(int value);
	public void reset();
}
