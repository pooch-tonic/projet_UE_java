/*
 *
 */
package modelInterfaces;

import java.awt.Dimension;
import java.util.ArrayList;

import vector.IVector;

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
     */
    public void setDimension(final Dimension dimension);

    /**
     * Sets an unit
     *
     * @param units
     */
    void setUnits(IUnit[][] units);

    /**
     * Adds an entity
     *
     * @param entity
     */
    public void addEntity(final IEntity entity);

    /**
     * Adds an unit on the position x and y
     *
     * @param unit
     * @param x
     * @param y
     */
    public void addUnit(final IUnit unit, final int x, final int y);

    /**
     * Removes an entity from the level list : entities
     *
     * @param entity
     */
    public void removeEntityFromLevel(IEntity entity);

    /**
     * Sets the id
     *
     * @param id
     */
    public void setId(final int id);

    /**
     * @param position
     * @return the entity on the position.
     */
    public IEntity getEntityOn(final IVector position);

    /**
     * @param entity
     * @return the entity overlapping this one.
     */
    public IEntity getEntityOverlapping(IEntity entity);

    /**
     * Gets the player
     *
     * @return the player
     */
    public IEntity getPlayer();

    /**
     * Sets the player
     *
     * @param player
     */
    public void setPlayer(final IEntity player);

    /**
     * Gets the exit
     *
     * @return the exit
     */
    public IEntity getExit();

    /**
     * Sets the exit
     *
     * @param exit
     */
    public void setExit(final IEntity exit);
    
    
    
    
    public IEntity getSpell();

    
    
    
	public void setSpell(IEntity spell);
}