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
    public Dead() {
        super(Type.DEAD);
        this.setBounceStrategy(new DoNotBounce());
        this.setDodgeStrategy(new DoNotDodge());
        this.setMoveStrategy(new DoNotMove());
        this.setScoreValue(SCORE);
    }

    /**
     * Instantiates a new Dead entity.
     *
     * @param spriteSet
     */
    public Dead(final ISpriteSet spriteSet) {
        super(Type.DEAD, spriteSet);
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
    }

}
