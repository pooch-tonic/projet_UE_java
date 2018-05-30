package model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Vector;

import enums.TypeEnum;

public interface IUnit {
	public Vector getPosition();
	public void setPosition(final Vector position);
	public ArrayList<BufferedImage> getSpriteSet();
	public void setSpriteSet(final ArrayList<BufferedImage> sprites);
	public TypeEnum getType();
	public void setType(final TypeEnum type);
}
