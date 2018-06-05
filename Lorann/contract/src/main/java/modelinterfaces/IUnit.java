/*
 *
 */
package modelinterfaces;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import enums.UnitTypeEnum;
import showboard.ISpriteSet;
import showboard.ISquare;
import vector.IVector;

public interface IUnit extends ISquare {

	/**
	 * Gets a position
	 * 
	 * @return a position
	 */
	public IVector getPosition();

	/**
	 * @return a spriteSet
	 */
	public ISpriteSet getSpriteSet();

	/**
	 * @return
	 */
	public UnitTypeEnum getType();

	/**
	 * @param position
	 */
	public void setPosition(final IVector position);

	/**
	 * @param sprites
	 */
	public void setSpriteSet(final ArrayList<BufferedImage> sprites);

	/**
	 * @param image
	 */
	public void setSpriteSet(final BufferedImage image);

	/**
	 * @param spriteSet
	 */
	public void setSpriteSet(final ISpriteSet spriteSet);

	/**
	 * @param type
	 */
	public void setType(final UnitTypeEnum type);
}
