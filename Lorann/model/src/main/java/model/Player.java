/*
 *
 */
package model;

import enums.UnitTypeEnum;
import model.behaviorstrategy.DoNotBounce;
import model.behaviorstrategy.DoNotDodge;
import model.behaviorstrategy.MoveSimple;
import modelinterfaces.IPlayer;
import showboard.ISpriteSet;
import vector.IVector;
import vector.Vector;

/**
 * <h1>The Player class.</h1> The class that represents the player in the game.
 * 
 * @author Ryo SHIINA
 *
 */
public class Player extends Entity implements IPlayer {
	public static int SCORE = 0;

	/**
	 * Instantiates a new Player
	 *
	 */
	public Player(final ISpriteSet spriteSet) {
		super(UnitTypeEnum.PLAYER, spriteSet);
		this.setLastDirection(new Vector(0, 0));
		this.setBounceStrategy(new DoNotBounce());
		this.setDodgeStrategy(new DoNotDodge());
		this.setMoveStrategy(new MoveSimple());
		this.setScoreValue(SCORE);
	}

	/**
	 * Instantiates a new Player
	 *
	 * @param position
	 */
	public Player(final IVector position) {
		super(position, UnitTypeEnum.PLAYER);
		this.setScoreValue(SCORE);
	}

	@Override
	public void update() {
		super.update();
		this.getSpriteSet().setNextSprite();
	}

}
