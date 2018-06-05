/*
 *
 */
package model;

import enums.UnitTypeEnum;
import model.behaviorstrategy.DoNotBounce;
import model.behaviorstrategy.DoNotDodge;
import model.behaviorstrategy.DoNotMove;
import showboard.ISpriteSet;
import vector.IVector;

/**
 * <h1>The Key class.</h1> Allows the player to open the door when picked up.
 * 
 * @author Ryo SHIINA
 *
 */
public class Key extends Entity {
	public static int SCORE = 0;

	/**
	 * Instantiates a new Key
	 *
	 */
	public Key(final ISpriteSet spriteSet) {
		super(UnitTypeEnum.KEY, spriteSet);
		this.setBounceStrategy(new DoNotBounce());
		this.setDodgeStrategy(new DoNotDodge());
		this.setMoveStrategy(new DoNotMove());
		this.setScoreValue(SCORE);
	}

	/**
	 * Instantiates a new Key
	 *
	 * @param position
	 */
	public Key(final IVector position) {
		super(position, UnitTypeEnum.KEY);
		this.setScoreValue(SCORE);
	}

	@Override
	public void update() {
		super.update();
		this.getSpriteSet().setNextSprite();
	}
}
