/*
 *
 */
package modelInterfaces;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import enums.Type;
import showboard.ISpriteSet;
import showboard.ISquare;
import vector.IVector;

public interface IUnit extends ISquare {

	public IVector getPosition();

	public int getScoreValue();

	public ISpriteSet getSpriteSet();

	public Type getType();

	public void setPosition(final IVector position);

	public void setScoreValue(final int scoreValue);

	public void setSpriteSet(final ArrayList<BufferedImage> sprites);

	public void setSpriteSet(final BufferedImage image);

	public void setSpriteSet(final ISpriteSet spriteSet);

	public void setType(final Type type);
}
