package model;

import java.awt.Dimension;
import java.util.ArrayList;

import modelInterfaces.IEntity;
import modelInterfaces.ILevel;
import modelInterfaces.IUnit;
import showboard.IPawn;
import showboard.ISquare;

/**
 * @author Max Becerro
 *
 */
public class Level implements ILevel {
	private ISquare[][] units;
	private ArrayList<IPawn> entities;
	private Dimension dimension;
	private int id;

	public void addEntity(final IEntity entity) {
		this.getEntities().add(entity);
	}

	public void addUnit(final IUnit unit, final int x, final int y) {
		this.getUnits()[x][y] = unit;
	}

	/**
	 *
	 * @return the dimension of the map, with x as rows and y as columns
	 */
	@Override
	public Dimension getDimension() {
		return this.dimension;
	}

	@Override
	public ArrayList<IPawn> getEntities() {
		// TODO Auto-generated method stub
		return this.entities;
	}

	/**
	 * Gets the id
	 *
	 * @return the id
	 */
	@Override
	public int getId() {
		return this.id;
	}

	/**
	 *
	 * @return the current level map, contained in a 2D array of ISquare.
	 */
	@Override
	public ISquare[][] getUnits() {
		return this.units;
	}

	/**
	 * @param dimension
	 */
	@Override
	public void setDimension(final Dimension dimension) {
		this.dimension = dimension;
	}

	/**
	 * @param entities
	 *            the entities to set
	 */
	private void setEntities(final ArrayList<IPawn> entities) {
		this.entities = entities;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(final int id) {
		this.id = id;
	}

	/**
	 * @param squares
	 */
	@Override
	public void setUnits(final ISquare[][] units) {
		this.units = units;
	}

}