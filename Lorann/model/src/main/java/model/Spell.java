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

/**
 * @author Peyret Romain
 *
 */
public class Spell extends Entity {
    public static int SCORE = 0;

    /**
     * Instantiates a new Spell
     *
     */
    public Spell(final ISpriteSet spriteSet) {
        super(Type.SPELL, spriteSet);
        this.setBounceStrategy(new BounceOpposite());
        this.setDodgeStrategy(new DoNotDodge());
        this.setMoveStrategy(new MoveSimple());
        this.setScoreValue(SCORE);
    }

    /**
     * Instantiates a new Spell
     *
     * @param position
     */
    public Spell(final IVector position) {
        super(position, Type.SPELL);
        this.setScoreValue(SCORE);
    }

    @Override
    public void update() {
        super.update();
        this.setBounceStrategy(new BounceOpposite());
        this.getSpriteSet().setNextSprite();
    }
}
