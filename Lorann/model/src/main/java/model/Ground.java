package model;

import enums.UnitTypeEnum;
import vector.IVector;

/**
 * <h1>The Ground class.</h1> A simple unit with a black sprite.
 *
 * @author Ryo SHIINA
 *
 */
public class Ground extends Unit {

	/**
	 * Default constructor : instantiates a new Wall.
	 */
	public Ground() {
		super(new SpriteSet(), UnitTypeEnum.GROUND);
		this.getSpriteSet().getSprites().add(null);
	}

	/**
	 * A constructor based on a position vector.
	 *
	 * @param position
	 */
	public Ground(final IVector position) {
		super(UnitTypeEnum.GROUND);
		this.setPosition(position);
	}
}
