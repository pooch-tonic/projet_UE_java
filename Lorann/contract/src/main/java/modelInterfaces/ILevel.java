/*
 *
 */
package modelInterfaces;

import java.awt.Dimension;
import java.util.ArrayList;

import vector.IVector;

public interface ILevel {
    public Dimension getDimension();

    public ArrayList<IEntity> getEntities();

    public int getId();

    public IUnit[][] getUnits();

    public void setDimension(final Dimension dimension);

    void setUnits(IUnit[][] units);

    public void addEntity(final IEntity entity);

    public void addUnit(final IUnit unit, final int x, final int y);

    public void setId(final int id);

    public IEntity getEntityOn(final IVector position);
}