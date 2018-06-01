package showboard;

import java.awt.Point;

import vector.IVector;

/**
 * <h1>The Interface IPawn.</h1>
 * <p>
 * A class can implement the IPawn interface when it wants to move on a IBoard.
 * </p>
 *
 * @author Anne-Emilie DIET
 * @version 1.1
 * @see IBoard
 * @see ISquare
 * @see Point
 */
public interface IPawn extends ISquare {

	/**
	 * Gets the position Point(int x, int y).
	 *
	 * @return the position
	 * @see Point
	 */
	IVector getPosition();

	/**
	 * Gets the x position.
	 *
	 * @return the x
	 */
	int getX();

	/**
	 * Gets the y position.
	 *
	 * @return the y
	 */
	int getY();
}
