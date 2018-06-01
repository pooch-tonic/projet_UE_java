package model;

import java.awt.Dimension;

import showboard.ISquare;

/**
 * @author Max Becerro
 *
 */
public class Level {
	private ISquare[][] squares;
	private Dimension dimension;

	/**
	 *
	 * @return the dimension of the map, with x as rows and y as columns
	 */
	public Dimension getDimension() {
		return this.dimension;
	}

	/**
	 *
	 * @return the current level map, contained in a 2D array of ISquare.
	 */
	public ISquare[][] getSquares() {
		return this.squares;
	}

	/**
	 * @param dimension
	 */
	public void setDimension(final Dimension dimension) {
		this.dimension = dimension;
	}

	/**
	 * @param squares
	 */
	public void setSquares(final ISquare[][] squares) {
		this.squares = squares;
	}
}