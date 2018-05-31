package model;

import java.awt.Dimension;

import showboard.ISquare;

public class Level {
	private ISquare[][] squares;
	private Dimension dimension;
	

	
	
	public ISquare[][] getSquares() {
		return this.squares;
	}
	public void setSquares(ISquare[][] squares) {
		this.squares = squares;
	}
	public Dimension getDimension() {
		return this.dimension;
	}
	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}
}
