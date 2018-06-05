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

    /**
     * Set door type between enemy if the door is closed or door_open
     *
     * @param closed
     */
    @Override
    public void setType(final UnitTypeEnum type) {
        super.setType(type);
        if (this.getType() == UnitTypeEnum.DOOR_OPEN) {
            System.out.println("ok");
            this.getSpriteSet().setNextSprite();
        }
    }

}
