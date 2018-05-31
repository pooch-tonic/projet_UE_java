package model;

import java.util.Vector;

import enums.TypeEnum;
import modelInterfaces.IPlayer;

/**
 * @author Max Becerro
 *
 */
public class Player extends Entity implements IPlayer{

	public Player(TypeEnum type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	public Player(Vector position, SpriteSet sprites, TypeEnum type) {
		super(position, sprites, type);
		// TODO Auto-generated constructor stub
	}

	public Player(Vector position, TypeEnum type) {
		super(position, type);
		// TODO Auto-generated constructor stub
	}

}
