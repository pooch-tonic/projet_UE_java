package model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import enums.TypeEnum;
import modelInterfaces.IBlock;
import modelInterfaces.ISpriteSet;
import modelInterfaces.IVector;
import showboard.IPawn;
import showboard.ISquare;

/**
 * @author Max Becerro
 *
 */
public class Block extends Unit implements ISquare, IBlock {
	
	/**
	 * Instantiates a new Block
	 * 
	 */
	public Block() {
		super();
	}

	/**
	 * Instantiates a new Block
	 * 
	 * @param position
	 * @param spriteSet
	 * @param type
	 */
	public Block(final IVector position, final ISpriteSet spriteSet, final TypeEnum type) {
		super(position, spriteSet, type);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param position
	 * @param type
	 */
	public Block(final IVector position, final TypeEnum type) {
		super(position, type);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param type
	 */
	public Block(final TypeEnum type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see showboard.ISquare#getImage()
	 */
	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	/**
	 * @return a spriteSet
	 */
	public ISpriteSet getSpriteSet() {
		// TODO Auto-generated method stub
		return super.getSpriteSet();
	}

	@Override
	public void setSpriteSet(final ArrayList<BufferedImage> sprites) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSpriteSet(final ISpriteSet spriteSet) {
		// TODO Auto-generated method stub

	}

	@Override
	public IPawn getUnit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeUnit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUnitIfEmpty(IPawn unit) {
		// TODO Auto-generated method stub
		
	}

}
