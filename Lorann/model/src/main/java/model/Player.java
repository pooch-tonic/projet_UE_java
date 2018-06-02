/*
 *
 */
package model;

import java.awt.Image;

import enums.TypeEnum;
import modelInterfaces.IPlayer;
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
	}

	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getX() {
		return this.getPosition().getX();
	}

	@Override
	public int getY() {
		return this.getPosition().getY();
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
