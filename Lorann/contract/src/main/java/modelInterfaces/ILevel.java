package modelInterfaces;

import java.awt.Dimension;
import java.util.ArrayList;

import showboard.IPawn;
import showboard.ISquare;

public interface ILevel {
	public ISquare[][] getSquare();
	public void setSquares(final ISquare[][] squares);
	public Dimension getDimension();
	public void setDimension(final Dimension dimension);
	public int getId();
	public ArrayList<IPawn> getEntities();
}
