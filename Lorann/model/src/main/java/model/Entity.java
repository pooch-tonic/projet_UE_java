package model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import enums.DirectionsEnum;
import enums.TypeEnum;
import modelInterfaces.IEntity;
import showboard.ISpriteSet;
import vector.IVector;
import vector.Vector;

/**
 * @author Max Becerro
 *
 */
public abstract class Entity implements IEntity {
	private IVector position;
	private ISpriteSet spriteSet;
	private TypeEnum type;
	private int scoreValue;
	private IVector direction;

	/**
	 * Instantiates a new Entity
	 *
	 */
	public Entity() {
		
	}

	/**
	 * Instantiates a new Entity
	 *
	 * @param position
	 * @param spriteSet
	 * @param type
	 */
	public Entity(final IVector position, final ISpriteSet spriteSet, final TypeEnum type) {
		this.setPosition(position);
		this.setSpriteSet(spriteSet);
		this.setType(type);
		this.setScoreValue(0);
	}

	/**
	 * Instantiates a new Entity
	 *
	 * @param position
	 * @param type
	 */
	public Entity(final IVector position, final TypeEnum type) {
		this.setPosition(position);
		this.setType(type);
		this.setScoreValue(0);
	}

	/**
	 * Instantiates a new Entity
	 *
	 * @param type
	 */
	public Entity(final TypeEnum type) {
		this.setPosition(new Vector(0, 0));
		this.setType(type);
		this.setScoreValue(0);
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
	public void move(final DirectionsEnum direction) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDirection(final IVector direction) {
		// TODO Auto-generated method stub

	}

	@Override
	public IVector getPosition() {
		return this.position;
	}

	/**
	 * Gets the scoreValue
	 *
	 * @return the scoreValue
	 */
	public int getScoreValue() {
		return this.scoreValue;
	}

	@Override
	public ISpriteSet getSpriteSet() {
		return this.spriteSet;
	}


	public TypeEnum getType() {
		return this.type;
	}


	public void setPosition(final IVector position) {
		this.position = position;
	}

	public void setScoreValue(final int scoreValue) {
		this.scoreValue = scoreValue;
	}


	public void setSpriteSet(final ArrayList<BufferedImage> sprites) {
		// TODO Auto-generated method stub

	}


	public void setSpriteSet(final ISpriteSet spriteSet) {
		this.spriteSet = spriteSet;
	}


	public void setType(final TypeEnum type) {
		this.type = type;
	}

}
