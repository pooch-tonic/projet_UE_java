package model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Vector;

import enums.TypeEnum;
import modelInterfaces.IVector;
import showboard.ISquare;

/**
 * @author Max Becerro
 *
 */
public class Block extends Unit implements ISquare{


	public Block() {
		super();
	}

	public Block(TypeEnum type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	public Block(IVector position, SpriteSet sprites, TypeEnum type) {
		super(position, sprites, type);
		// TODO Auto-generated constructor stub
	}

	public Block(IVector position, TypeEnum type) {
		super(position, type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BufferedImage> getSpriteSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSpriteSet(ArrayList<BufferedImage> sprites) {
		// TODO Auto-generated method stub
		
	}

}
