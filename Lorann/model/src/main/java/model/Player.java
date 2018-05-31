package model;

import enums.TypeEnum;
import modelInterfaces.IPlayer;
import modelInterfaces.IVector;

/**
 * @author Max Becerro
 *
 */
public class Player extends Entity implements IPlayer {

	/**
	 * Instantiates a new Player
	 * 
	 */
	public Player() {
		super(TypeEnum.PLAYER);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new Player
	 * 
	 * @param position
	 */
	public Player(final IVector position) {
		super(position, TypeEnum.PLAYER);
		// TODO Auto-generated constructor stub
	}

}
