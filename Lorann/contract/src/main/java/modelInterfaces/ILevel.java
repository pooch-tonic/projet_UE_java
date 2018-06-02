/*
 * 
 */
package modelInterfaces;

import java.awt.Dimension;
import java.util.ArrayList;

import showboard.ISquare;

public interface ILevel {
    public Dimension getDimension();

    public ArrayList<IEntity> getEntities();

    public int getId();

    public ISquare[][] getUnits();

    public void setDimension(final Dimension dimension);

    public void setUnits(final ISquare[][] units);
}
