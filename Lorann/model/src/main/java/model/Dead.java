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
 * @author Max Becerro
 *
 */
public class Dead extends Entity {
    public static int SCORE = 0;

    /**
     * Instantiates a new Dead entity.
     */
    public Dead(final ISpriteSet spriteSet) {
        super(null, spriteSet, UnitTypeEnum.DEAD, 10, SCORE);
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
        super(UnitTypeEnum.DEAD);
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
        super(position, UnitTypeEnum.DEAD);
        this.setScoreValue(SCORE);
        this.setBounceStrategy(new DoNotBounce());
        this.setDodgeStrategy(new DoNotDodge());
    }

    @Override
    public void update() {
        System.out.println(this.getDurability());
        this.decrementDurability();
    }

}
