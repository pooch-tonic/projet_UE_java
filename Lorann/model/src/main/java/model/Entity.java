package model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import enums.DirectionsEnum;
import modelInterfaces.IEntity;
import showboard.IPawn;
import showboard.ISpriteSet;
import showboard.TypeEnum;
import vector.IVector;

/**
 * @author Max Becerro
 *
 */
public class Entity extends Unit implements IPawn {

	private IVector direction;
	
	/**
	 * Instantiates a new Entity
	 * 
	 */
	public Entity() {
		super();
	}

	/**
	 * Instantiates a new Entity
	 * 
	 * @param position
	 * @param spriteSet
	 * @param type
	 */
	public Entity(final IVector position, final ISpriteSet spriteSet, final TypeEnum type) {
		super(position, spriteSet, type);
	}

	/**
	 * Instantiates a new Entity
	 * 
	 * @param position
	 * @param type
	 */
	public Entity(final IVector position, final TypeEnum type) {
		super(position, type);
	}

	/**
	 * Instantiates a new Entity
	 * 
	 * @param type
	 */
	public Entity(final TypeEnum type) {
		super(type);
	}

	@Override
	public void setSpriteSet(ArrayList<BufferedImage> sprites) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}



}
