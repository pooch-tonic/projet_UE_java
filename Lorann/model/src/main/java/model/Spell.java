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
	
	/**
     * Instantiates a new Spell
     *
     */
    public Spell(final ISpriteSet spriteSet) {
        super(Type.SPELL, spriteSet);
        this.setBounceStrategy(new BounceOpposite());
        this.setDodgeStrategy(new DoNotDodge());
        this.setMoveStrategy(new MoveSimple());
    }

    /**
     * Instantiates a new Spell
     *
     * @param position
     */
    public Spell(final IVector position) {
        super(position, Type.SPELL);
    }
    
    public void update() {
    	super.update();
    	this.getSpriteSet().setNextSprite();
    }
}
