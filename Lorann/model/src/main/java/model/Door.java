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
public class Door extends Entity {

    /**
     * Instantiates a new Door
     *
     * @param closed
     */
    public Door(final Type type, final ISpriteSet spriteSet) {
        super(type, spriteSet);
        this.setBounceStrategy(new DoNotBounce());
        this.setDodgeStrategy(new DoNotDodge());
        this.setMoveStrategy(new DoNotMove());
    }

    /**
     * Instantiates a new Door
     *
     * @param position
     * @param closed
     */
    public Door(final IVector position, final Type type) {
        super(type);
        super.setPosition(position);
    }

    /**
     * Set door type between enemy if the door is closed or door_open
     *
     * @param closed
     */
    @Override
    public void setType(final Type type) {
        super.setType(type);
        if (this.getType() == Type.DOOR_OPEN) {
            System.out.println("ok");
            this.getSpriteSet().setNextSprite();
        }
    }
    
    
}
