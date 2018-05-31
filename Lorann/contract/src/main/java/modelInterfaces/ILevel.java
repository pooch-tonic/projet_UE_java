package modelInterfaces;

import java.awt.Dimension;

public interface ILevel {
	public ISquare[][] getSquare();
	public void setSquares(final ISquare[][] squares);
	public Dimension getDimension();
	public void setDimension(final Dimension dimension);
}
