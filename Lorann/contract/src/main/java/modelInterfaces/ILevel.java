package modelInterfaces;

import java.awt.Dimension;
import java.util.ArrayList;

import vector.IVector;

/**
 * <h1>The ILevel interface.</h1> Implemented by level objects containing units
 * and entities.
 * 
 * @author Ryo
 *
 */
public interface ILevel {

	/**
	 * Gets the dimension
	 *
	 * @return the dimension of the map, with x as rows and y as columns
	 */
	public Dimension getDimension();

	/**
	 * Gets the entity
	 *
	 * @return the entity.
	 */
	public ArrayList<IEntity> getEntities();

	/**
	 * Gets the id
	 *
	 * @return the id
	 */
	public int getId();

	/**
	 * Gets the unit
	 *
	 * @return the current level map, contained in a 2D array of ISquare.
	 */
	public IUnit[][] getUnits();

	/**
	 * Gets the unit on x : y
	 *
	 * @return the IUnit.
	 */
	public IUnit getUnitOn(int x, int y);

	/**
	 * Sets the dimension
	 *
	 * @param dimension
	 *            the dimension of the level, in squares
	 */
	public void setDimension(final Dimension dimension);

	/**
	 * Sets an unit
	 *
	 * @param units
	 *            the units to set in the level
	 */
	void setUnits(IUnit[][] units);

	/**
	 * Adds an entity to the level.
	 *
	 * @param entity
	 *            the entity to be added
	 */
	public void addEntity(final IEntity entity);

	/**
	 * Adds an entity to the level at a given index.
	 *
	 * @param index
	 *            the index of the new entity
	 * @param entity
	 *            the entity to be added
	 */
	public void addEntity(final int index, final IEntity entity);

	/**
	 * Adds an unit on the position x and y.
	 *
	 * @param unit
	 *            the unit to be added
	 * @param x
	 *            the x coordinate of the unit
	 * @param y
	 *            the y coordinate of the unit
	 */
	public void addUnit(final IUnit unit, final int x, final int y);

	/**
	 * Removes an entity from the level list : entities.
	 *
	 * @param entity
	 *            the entity to remove
	 */
	public void removeEntityFromLevel(IEntity entity);

	/**
	 * Sets the id of the level.
	 *
	 * @param id
	 *            the id of the level
	 */
	public void setId(final int id);

	/**
	 * Returns the entity placed on a given position.
	 *
	 * @param position
	 *            the position to check
	 * @return the entity on the position.
	 */
	public IEntity getEntityOn(final IVector position);

	/**
	 * Returns the entity overlapping the given one.
	 * <p>
	 * If there is no entity, this returns null.
	 *
	 * @param entity
	 * @return the entity overlapping this one.
	 */
	public IEntity getEntityOverlapping(IEntity entity);

	/**
	 * Gets the player of level.
	 *
	 * @return the player
	 */
	public IEntity getPlayer();

	/**
	 * Sets the player of the level.
	 *
	 * @param player
	 *            the entity that overrides the current player
	 */
	public void setPlayer(final IEntity player);

	/**
	 * Gets the exit portal of the level.
	 *
	 * @return the exit portal entity
	 */
	public IEntity getExit();

	/**
	 * Sets the exit portal of the level.
	 *
	 * @param exit
	 *            the entity that overrides the current exit
	 */
	public void setExit(final IEntity exit);

	/**
	 * Gets the spell of the level.
	 *
	 * @return the spell entity
	 */
	public IEntity getSpell();

	/**
	 * Sets the spell of the level.
	 *
	 * @param spell
	 *            the spell entity that overrides the current spell
	 */
	public void setSpell(IEntity spell);

}