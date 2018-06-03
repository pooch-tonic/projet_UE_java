/*
 *
 */
package model;

import enums.Type;
import showboard.ISpriteSet;
import vector.IVector;

/**
 * @author Max Becerro
 *
 */
public class Door extends Entity {

	/**
	 * Instantiates a new Door
	 *
	 * @param closed
	 */
	public Door(final boolean closed, final ISpriteSet spriteSet) {
		super();
		this.setDoorType(closed);
		super.setSpriteSet(spriteSet);

		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new Door
	 *
	 * @param position
	 * @param closed
	 */
	public Door(final IVector position, final boolean closed) {
		super();
		this.setDoorType(closed);
		super.setPosition(position);

		// TODO Auto-generated constructor stub
	}

	/**
	 * @param closed
	 */
	private void setDoorType(final boolean closed) {
		if (closed) {
			super.setType(Type.ENEMY);
		} else {
			super.setType(Type.DOOR_OPEN);
		}
	}

}
