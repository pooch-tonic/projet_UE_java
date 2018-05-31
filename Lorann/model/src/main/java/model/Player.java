package model;

import enums.TypeEnum;
import modelInterfaces.IPlayer;
import modelInterfaces.IVector;

/**
 * @author Max Becerro
 *
 */
public class Player extends Entity implements IPlayer {

	public Player() {
		super(TypeEnum.PLAYER);
		// TODO Auto-generated constructor stub
	}

	public Player(final IVector position) {
		super(position, TypeEnum.PLAYER);
		// TODO Auto-generated constructor stub
	}

}
