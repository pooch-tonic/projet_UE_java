package model;

import enums.Type;
import vector.IVector;

public class Ground extends Unit {

	/**
	 * Default constructor : instantiates a new Wall.
	 */
	public Ground() {
		super(Type.GROUND);
		// this.setSpriteSet(); TODO finir �a
		this.setType(Type.GROUND);
	}

	/**
	 * A constructor based on a position vector.
	 *
	 * @param position
	 */
	public Ground(final IVector position) {
		super(Type.GROUND);
		this.setPosition(position);
	}
}
