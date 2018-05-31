package modelInterfaces;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import enums.TypeEnum;

public interface IUnit {
	public IVector getPosition();

	public ISpriteSet getSpriteSet();

	public TypeEnum getType();

	public void setPosition(final IVector position);

	public void setSpriteSet(final ArrayList<BufferedImage> sprites);

	public void setSpriteSet(final ISpriteSet spriteSet);

	public void setType(final TypeEnum type);
}
