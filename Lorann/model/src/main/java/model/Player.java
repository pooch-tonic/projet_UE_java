/*
 *
 */
package model;

import enums.Type;
import modelInterfaces.IPlayer;
import showboard.ISpriteSet;
import vector.IVector;

/**
 * @author Max Becerro
 *
 */
public class Player extends Entity implements IPlayer {

	/**
	 * Instantiates a new Player
	 *
	 */
	public Player(final ISpriteSet spriteSet) {
		super(Type.PLAYER);
		super.setSpriteSet(spriteSet);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new Player
	 *
	 * @param position
	 */
	public Player(final IVector position) {
		super(position, Type.PLAYER);
	}

}
