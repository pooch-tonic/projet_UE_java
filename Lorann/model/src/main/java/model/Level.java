package model;

import java.awt.Dimension;
import java.util.ArrayList;


import modelInterfaces.ILevel;
import showboard.IPawn;
import showboard.ISquare;

/**
 * @author Max Becerro
 *
 */
public class Level implements ILevel{
	private ISquare[][] squares;
	private Dimension dimension;
	private int id;
	private ArrayList<IPawn> entities;
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

	/**
	 * Gets the id
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public ISquare[][] getSquare() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<IPawn> getEntities() {
		// TODO Auto-generated method stub
		return entities;
	}

	/**
	 * @param entities the entities to set
	 */
	private void setEntities(ArrayList<IPawn> entities) {
		this.entities = entities;
	}
}