package model;

import java.util.Vector;

import enums.TypeEnum;
import modelInterfaces.IPlayer;
import modelInterfaces.IVector;

/**
 * @author Max Becerro
 *
 */
public class Player extends Entity implements IPlayer{

	public Player() {
		super(TypeEnum.PLAYER);
		// TODO Auto-generated constructor stub
	}



	public Player(IVector position) {
		super(position, TypeEnum.PLAYER);
		// TODO Auto-generated constructor stub
	}

}
