package modelInterfaces;

import showboard.IPawn;

public interface IUnitContainer {
	/**
	 * @return the placed unit
	 */
	public IPawn getUnit();

	/**
	 * @return true if square is empty, false if square is full
	 */
	public boolean isEmpty();

	/**
	 * removes the placed unit by setting it to null
	 */
	public void removeUnit();

	/**
	 * places unit by testing first if the square is empty
	 *
	 * @param unit
	 */
	public void setUnitIfEmpty(IPawn unit);
}
