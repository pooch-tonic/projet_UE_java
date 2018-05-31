package model;

import enums.TypeEnum;
import model.vector.Vector;
import modelInterfaces.ISpriteSet;
import modelInterfaces.IUnit;
import modelInterfaces.IVector;

/**
 * @author Max Becerro
 *
 */
public abstract class Unit implements IUnit {
	private IVector position;
	private ISpriteSet spriteSet;
	private TypeEnum type;
	private int scoreValue;

	public Unit() {

	}

	public Unit(final IVector position, final ISpriteSet spriteSet, final TypeEnum type) {
		this.setPosition(position);
		this.setSpriteSet(spriteSet);
		this.setType(type);
		this.setScoreValue(0);
	}

	public Unit(final IVector position, final TypeEnum type) {
		this.setPosition(position);
		// this.setSpriteSet(spriteSet); TODO default spriteset required
		this.setType(type);
		this.setScoreValue(0);
	}

	public Unit(final TypeEnum type) {
		this.setPosition(new Vector(0, 0));
		// this.setSpriteSet(spriteSet); TODO default spriteset required
		this.setType(type);
		this.setScoreValue(0);
	}

	@Override
	public IVector getPosition() {
		return this.position;
	}

	public int getScoreValue() {
		return this.scoreValue;
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
}
