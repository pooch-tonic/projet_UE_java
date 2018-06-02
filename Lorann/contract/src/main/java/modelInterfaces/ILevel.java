package modelInterfaces;

import java.awt.Dimension;
import java.util.ArrayList;

import showboard.IPawn;
import showboard.ISquare;

public interface ILevel {
	/**
	 * @return the dimension
	 */
	public Dimension getDimension();

	/**
	 * @return the ArrayList of entities
	 */
	public ArrayList<IPawn> getEntities();

	/**
	 * @return the level ID
	 */
	public int getId();

	/**
	 * @return the 2D array of squares
	 */
	public ISquare[][] getSquares();

	/**
	 * @param dimension
	 *            sets the dimension
	 */
	public void setDimension(final Dimension dimension);

	/**
	 * @param squares
	 *            sets the 2D array of squares
	 */
	public void setSquares(final ISquare[][] squares);
}
