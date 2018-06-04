package model;

import enums.Type;
import vector.IVector;

public class Ground extends Unit {

	/**
	 * Default constructor : instantiates a new Wall.
	 */
	public Ground() {
		super(new SpriteSet(), Type.GROUND);
		this.getSpriteSet().getSprites().add(null);
	}

	/**
	 * A constructor based on a position vector.tt
	 *
	 * @param position
	 */
	public Ground(final IVector position) {
		super(Type.GROUND);
		this.setPosition(position);
	}
}
