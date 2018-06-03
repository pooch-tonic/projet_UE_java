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
public class Key extends Entity {

	/**
	 * Instantiates a new Key
	 *
	 */
	public Key(final ISpriteSet spriteSet) {
		super(Type.KEY);
		super.setSpriteSet(spriteSet);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new Key
	 *
	 * @param position
	 */
	public Key(final IVector position) {
		super(position, Type.KEY);
		// TODO Auto-generated constructor stub
	}

}
