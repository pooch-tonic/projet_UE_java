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
 * <h1>The Dead class.</h1> The entity which is briefly summoned on a dead
 * entity to show its death.
 *
 * @author Ryo SHIINA
 * @author Max Becerro
 *
 */
public class Dead extends Entity {
    public static int SCORE = 0;


	/**
	 * Instantiates a new Dead entity.
	 *
	 * @param spriteSet
	 *            the spriteSet to load
	 */
	public Dead(final ISpriteSet spriteSet) {
		super(null, spriteSet, UnitTypeEnum.DEAD, 16, SCORE);
		this.setBounceStrategy(new DoNotBounce());
		this.setDodgeStrategy(new DoNotDodge());
		this.setMoveStrategy(new DoNotMove());
	}

    /**
     * Instantiates a new Dead entity.
     *
     */
    public Dead() {
        super(UnitTypeEnum.DEAD);
        this.setBounceStrategy(new DoNotBounce());
        this.setDodgeStrategy(new DoNotDodge());
        this.setMoveStrategy(new DoNotMove());
        this.setScoreValue(SCORE);
    }

    /**
     * Instantiates a new Dead entity.
     *
     * @param position
     *            the position of the dead entity
     */
    public Dead(final IVector position) {
        super(position, UnitTypeEnum.DEAD);
        this.setScoreValue(SCORE);
        this.setBounceStrategy(new DoNotBounce());
        this.setDodgeStrategy(new DoNotDodge());
        this.setMoveStrategy(new DoNotMove());
    }


	/*
	 * (non-Javadoc)
	 *
	 * @see model.Entity#update()
	 */
	@Override
	public void update() {
		this.decrementDurability();
		if (this.getDurability() < 8) {
			this.getSpriteSet().setNextSprite();
		}
	}

}
