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
		super(Type.PLAYER, spriteSet);
	}

	/**
	 * Instantiates a new Player
	 *
	 * @param position
	 */
	public Player(final IVector position) {
		super(position, Type.PLAYER);
	}
	
	@Override
	public void update() {
		super.update();
		this.getSpriteSet().setNextSprite();
	}

}
