package model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Vector;

import enums.TypeEnum;

public interface IUnit {
	public Vector getPosition();
	public void setPosition(Vector position);
	public ArrayList<BufferedImage> getSpriteSet();
	public void setSpriteSet(ArrayList<BufferedImage> sprites);
	public TypeEnum getType();
	public void setType(TypeEnum type);
}
