package model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import enums.DirectionsEnum;
import enums.TypeEnum;
import modelInterfaces.IEntity;
import showboard.ISpriteSet;
import vector.IVector;

/**
 * @author Max Becerro
 *
 */
public abstract class Entity extends Unit implements IEntity {

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
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	/**
	 * @return a direction
	 */
	public IVector getDirection() {
		// TODO Auto-generated method stub
		return this.direction;
	}

	@Override
	/**
	 * @return a position
	 */
	public IVector getPosition() {
		// TODO Auto-generated method stub
		return super.getPosition();
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
	/**
	 * @return a type
	 */
	public TypeEnum getType() {
		// TODO Auto-generated method stub
		return super.getType();
	}

	@Override
	public void move(final DirectionsEnum direction) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDirection(final IVector direction) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPosition(final IVector position) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSpriteSet(final ArrayList<BufferedImage> sprites) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setType(final TypeEnum type) {
		// TODO Auto-generated method stub

	}

}
