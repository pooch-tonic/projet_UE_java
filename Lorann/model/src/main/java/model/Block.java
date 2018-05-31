package model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import enums.TypeEnum;
import modelInterfaces.IBlock;
import modelInterfaces.ISpriteSet;
import modelInterfaces.IVector;
import showboard.ISquare;

/**
 * @author Max Becerro
 *
 */
public class Block extends Unit implements ISquare, IBlock {

	public Block() {
		super();
	}

	public Block(final IVector position, final ISpriteSet spriteSet, final TypeEnum type) {
		super(position, spriteSet, type);
		// TODO Auto-generated constructor stub
	}

	public Block(final IVector position, final TypeEnum type) {
		super(position, type);
		// TODO Auto-generated constructor stub
	}

	public Block(final TypeEnum type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ISpriteSet getSpriteSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSpriteSet(final ArrayList<BufferedImage> sprites) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSpriteSet(final ISpriteSet spriteSet) {
		// TODO Auto-generated method stub

	}

}
