package modelInterfaces;

import showboard.IPawn;

public interface ISquare {
	public IPawn getUnit();
	void setUnit(IPawn unit);
	public boolean isEmpty();
	public void setUnitIfEmpty(IPawn unit);
	public void removeUnit();
}
