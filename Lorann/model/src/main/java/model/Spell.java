/*
 *
 */
package model;

import enums.Type;
import model.behaviorStrategy.BounceOpposite;
import model.behaviorStrategy.DoNotDodge;
import model.behaviorStrategy.MoveSimple;
import showboard.ISpriteSet;
import vector.IVector;

public class Spell extends Entity {
    public Spell(final ISpriteSet spriteSet) {
        super(Type.SPELL, spriteSet);
        this.setBounceStrategy(new BounceOpposite());
        this.setDodgeStrategy(new DoNotDodge());
        this.setMoveStrategy(new MoveSimple());
    }

    /**
     * Instantiates a new Player
     *
     * @param position
     */
    public Spell(final IVector position) {
        super(Type.SPELL);
        this.setPosition(position);
    }

}
