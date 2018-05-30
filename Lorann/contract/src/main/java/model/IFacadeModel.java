package model;

public interface IFacadeModel {
	public ILevel getLevel();
	public int getScorValue();
	public void addToScoreValue(final int value);
	public void reset();
}
