/*
 *
 */
package model;

import java.awt.Image;

import enums.UnitTypeEnum;
import model.behaviorstrategy.DoNotBounce;
import model.behaviorstrategy.DoNotDodge;
import model.behaviorstrategy.DoNotMove;
import showboard.ISpriteSet;
import vector.IVector;

/**
 * <h1>The Door class.</h1> The entity which kills the player when closed, and
 * lets it go to the next level when open.
 *
 * @author Ryo SHIINA
 *
 */
public class Door extends Entity {
    public static int SCORE = 0;

    /**
     * Instantiates a new Door
     *
     * @param closed
     */
    public Door(final UnitTypeEnum type, final ISpriteSet spriteSet) {
        super(type, spriteSet);
        this.setBounceStrategy(new DoNotBounce());
        this.setDodgeStrategy(new DoNotDodge());
        this.setMoveStrategy(new DoNotMove());
        this.setScoreValue(SCORE);
    }

    /**
     * Instantiates a new Door
     *
     * @param position
     * @param closed
     */
    public Door(final IVector position, final UnitTypeEnum type) {
        super(type);
        super.setPosition(position);
        this.setScoreValue(SCORE);
    }

	/*
	 * (non-Javadoc)
	 *
	 * @see model.Entity#update()
	 */
	@Override
	public void update() {
		if (this.getType() != UnitTypeEnum.DOOR_OPEN) {
			this.getSpriteSet().setNextSprite();
			if (this.getSpriteSet().getCurrentIndex() == 5) {
				this.getSpriteSet().resetIndex();
			}
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.Unit#getImage()
	 */
	@Override
	public Image getImage() {
		if (this.getType() == UnitTypeEnum.DOOR_OPEN) {
			return this.getSpriteSet().getSpriteByIndex(5);
		} else {
			return this.getSpriteSet().getCurrentSprite();
		}
	}

}
