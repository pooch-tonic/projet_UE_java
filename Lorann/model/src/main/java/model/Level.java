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
	 * @return a squares
	 */
	public ISquare[][] getSquares() {
		return this.squares;
	}
	public void setSquares(ISquare[][] squares) {
		this.squares = squares;
	}
	/**
	 * 
	 * @return a dimension
	 */
	public Dimension getDimension() {
		return this.dimension;
	}
	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}
}
