package showboard;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import vector.IVector;

/**
 * <h1>The Interface ISquare.</h1>
 * <p>
 * A class can implement the ISquare interface when it wants to be show on a
 * IBoard.
 * </p>
 *
 * @author Anne-Emilie DIET
 * @author Aurélien DELLAC
 * @author Ryo SHIINA
 * @version 1.1
 * @see Image
 */
public interface ISquare {
	public IVector getPosition();

	public ISpriteSet getSpriteSet();

	public TypeEnum getType();

	public void setPosition(final IVector position);

	public void setSpriteSet(final ArrayList<BufferedImage> sprites);

	public void setSpriteSet(final ISpriteSet spriteSet);

	public void setType(final TypeEnum type);
	/**
	 * Gets the image.
	 *
	 * @return the image
	 */
	Image getImage();

	/**
	 * @return the placed unit
	 */
	public IPawn getUnit();

	/**
	 * @return true if square is empty, false if square is full
	 */
	public boolean isEmpty();

	/**
	 * removes the placed unit by setting it to null
	 */
	public void removeUnit();

	/**
	 * places unit by testing first if the square is empty
	 *
	 * @param unit
	 */
	public void setUnitIfEmpty(IPawn unit);
}
