package modelInterfaces;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import enums.TypeEnum;
import showboard.ISpriteSet;
import showboard.ISquare;
import vector.IVector;

public interface IUnit extends ISquare {
	public IVector getPosition();

	public ISpriteSet getSpriteSet();

	public TypeEnum getType();

	public void setPosition(final IVector position);

	public void setSpriteSet(final ArrayList<BufferedImage> sprites);

	public void setSpriteSet(final ISpriteSet spriteSet);

	public void setType(final TypeEnum type);
}
