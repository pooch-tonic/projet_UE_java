package modelInterfaces;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import showboard.ISpriteSet;
import showboard.ISquare;
import showboard.TypeEnum;
import vector.IVector;

public interface IUnit extends ISquare {
	public IVector getPosition();

	@Override
	public TypeEnum getType();

	public void setPosition(final IVector position);

	public void setSpriteSet(final ArrayList<BufferedImage> sprites);

	public void setSpriteSet(final ISpriteSet spriteSet);

	public void setType(final TypeEnum type);
}
