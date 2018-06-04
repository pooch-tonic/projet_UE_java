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
public class Key extends Entity {

    /**
     * Instantiates a new Key
     *
     */
    public Key(final ISpriteSet spriteSet) {
        super(Type.KEY, spriteSet);
        this.setBounceStrategy(new DoNotBounce());
        this.setDodgeStrategy(new DoNotDodge());
        this.setMoveStrategy(new DoNotMove());
    }

    /**
     * Instantiates a new Key
     *
     * @param position
     */
    public Key(final IVector position) {
        super(position, Type.KEY);
        // TODO Auto-generated constructor stub
    }

}
