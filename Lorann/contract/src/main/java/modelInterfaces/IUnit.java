package modelInterfaces;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Vector;

import enums.TypeEnum;

public interface IUnit {
	public IVector getPosition();
	public void setPosition(final IVector position);
	public ArrayList<BufferedImage> getSpriteSet();
	public void setSpriteSet(final ArrayList<BufferedImage> sprites);
	public TypeEnum getType();
	public void setType(final TypeEnum type);
}
