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
     * @param dimension
     */
    public void setDimension(final Dimension dimension);
    
    
    /**
     * Set an unit
     * 
     * @param units
     */
    void setUnits(IUnit[][] units);

    /**
     * Add an entity
     * 
     * @param entity
     */
    public void addEntity(final IEntity entity);

    /**
     * Add an unit on the position x and y
     * 
     * @param unit
     * @param x
     * @param y
     */
    public void addUnit(final IUnit unit, final int x, final int y);

    /**
     * @param id
     *            the id to set
     */
    public void setId(final int id);

    /**
     * @param position
     * @return the entity on the position.
     */
    public IEntity getEntityOn(final IVector position);
}