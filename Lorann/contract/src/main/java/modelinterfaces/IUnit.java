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

	public IVector getPosition();

	public ISpriteSet getSpriteSet();

	public UnitTypeEnum getType();

	public void setPosition(final IVector position);

	public void setSpriteSet(final ArrayList<BufferedImage> sprites);

	public void setSpriteSet(final BufferedImage image);

	public void setSpriteSet(final ISpriteSet spriteSet);

	public void setType(final UnitTypeEnum type);
}
