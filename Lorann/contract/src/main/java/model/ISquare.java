package model;

public interface ISquare {
	public IPawn getUnit();
	public boolean isEmpty();
	public void setUnitEmpty(IPawn unit);
	public void removeUnit();
}
