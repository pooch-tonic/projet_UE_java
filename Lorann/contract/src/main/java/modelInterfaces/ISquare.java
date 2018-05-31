package modelInterfaces;

public interface ISquare {
	public IPawn getUnit();
	public boolean isEmpty();
	public void setUnitEmpty(final IPawn unit);
	public void removeUnit();
}
