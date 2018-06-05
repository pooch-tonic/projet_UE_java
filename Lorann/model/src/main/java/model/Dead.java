/*
 *
 */
package model;

import enums.Type;
import model.behaviorStrategy.DoNotBounce;
import model.behaviorStrategy.DoNotDodge;
import model.behaviorStrategy.DoNotMove;
import showboard.ISpriteSet;
import vector.IVector;

/**
 * @author Max Becerro
 *
 */
public class Dead extends Entity {
	public static int SCORE = 0;

	/**
	 * Instantiates a new Dead entity.
	 */
	public Dead(final ISpriteSet spriteSet) {
		super(null, spriteSet, Type.DEAD, 10, SCORE);
		this.setBounceStrategy(new DoNotBounce());
		this.setDodgeStrategy(new DoNotDodge());
		this.setMoveStrategy(new DoNotMove());
	}

	/**
	 * Instantiates a new Dead entity.
	 *
	 * @param spriteSet
	 */
	public Dead() {
		super(Type.DEAD);
		this.setBounceStrategy(new DoNotBounce());
		this.setDodgeStrategy(new DoNotDodge());
		this.setScoreValue(SCORE);
	}

	/**
	 * Instantiates a new Dead entity.
	 *
	 * @param position
	 */
	public Dead(final IVector position) {
		super(position, Type.DEAD);
		this.setScoreValue(SCORE);
		this.setBounceStrategy(new DoNotBounce());
		this.setDodgeStrategy(new DoNotDodge());
	}

	@Override
	public void update() {
		this.decrementDurability();
	}

}
