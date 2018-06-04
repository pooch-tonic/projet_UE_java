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
    public Door(final boolean closed, final ISpriteSet spriteSet) {
        super(Type.ENEMY, spriteSet);
        this.setDoorType(closed);
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
    public Door(final IVector position, final boolean closed) {
        super(Type.ENEMY);
        this.setDoorType(closed);
        super.setPosition(position);

        // TODO Auto-generated constructor stub
    }

    /**
     * Set door type between enemy if the door is closed or door_open
     * 
     * @param closed
     */
    private void setDoorType(final boolean closed) {
        if (closed) {
            super.setType(Type.ENEMY);
        } else {
            super.setType(Type.DOOR_OPEN);
        }
    }

}
