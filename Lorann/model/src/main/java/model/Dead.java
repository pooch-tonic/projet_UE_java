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
public class Dead extends Entity {

	/**
	 * Instantiates a new Dead entity.
	 */
	public Dead() {
		super(Type.DEAD);
	}

	/**
	 * Instantiates a new Dead entity.
	 * 
	 * @param spriteSet
	 */
	public Dead(final ISpriteSet spriteSet) {
		super(Type.DEAD, spriteSet);
	}

	/**
	 * Instantiates a new Dead entity.
	 *
	 * @param position
	 */
	public Dead(final IVector position) {
		super(position, Type.DEAD);
	}

}
