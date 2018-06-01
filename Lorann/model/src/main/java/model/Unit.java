package model;

import enums.TypeEnum;
import modelInterfaces.ISpriteSet;
import modelInterfaces.IUnit;
import vector.IVector;
import vector.Vector;

/**
 * @author Max Becerro
 *
 */
public abstract class Unit implements IUnit {
	private IVector position;
	private ISpriteSet spriteSet;
	private TypeEnum type;
	private int scoreValue;

	/**
	 * Instantiates a new Unit
	 * 
	 */
	public Unit() {

	}

	/**
	 * Instantiates a new Unit
	 * 
	 * @param position
	 * @param spriteSet
	 * @param type
	 */
	public Unit(final IVector position, final ISpriteSet spriteSet, final TypeEnum type) {
		this.setPosition(position);
		this.setSpriteSet(spriteSet);
		this.setType(type);
		this.setScoreValue(0);
	}

	/**
	 * Instantiates a new Unit
	 * 
	 * @param position
	 * @param type
	 */
	public Unit(final IVector position, final TypeEnum type) {
		this.setPosition(position);
		this.setType(type);
		this.setScoreValue(0);
	}

	/**
	 * Instantiates a new Unit
	 * 
	 * @param type
	 */
	public Unit(final TypeEnum type) {
		this.setPosition(new Vector(0, 0));
		this.setType(type);
		this.setScoreValue(0);
	}


	@Override
	public IVector getPosition() {
		return this.position;
	}


	@Override
	public ISpriteSet getSpriteSet() {
		return this.spriteSet;
	}

	@Override
	public TypeEnum getType() {
		return this.type;
	}

	@Override
	public void setPosition(final IVector position) {
		this.position = position;
	}

	public void setScoreValue(final int scoreValue) {
		this.scoreValue = scoreValue;
	}

	@Override
	public void setSpriteSet(final ISpriteSet spriteSet) {
		this.spriteSet = spriteSet;
	}

	@Override
	public void setType(final TypeEnum type) {
		this.type = type;
	}

	/**
	 * Gets the scoreValue
	 * 
	 * @return the scoreValue
	 */
	public int getScoreValue() {
		return scoreValue;
	}
}
