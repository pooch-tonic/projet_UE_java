/*
 *
 */
package model;

import enums.Type;
import model.behaviorStrategy.DoNotBounce;
import model.behaviorStrategy.DoNotDodge;
import model.behaviorStrategy.MoveSimple;
import modelInterfaces.IPlayer;
import showboard.ISpriteSet;
import vector.IVector;
import vector.Vector;

/**
 * @author Max Becerro
 *
 */
public class Player extends Entity implements IPlayer {
    public static int SCORE = 0;

    /**
     * Instantiates a new Player
     *
     */
    public Player(final ISpriteSet spriteSet) {
        super(Type.PLAYER, spriteSet);
        this.setLastDirection(new Vector(0, 0));
        this.setBounceStrategy(new DoNotBounce());
        this.setDodgeStrategy(new DoNotDodge());
        this.setMoveStrategy(new MoveSimple());
        this.setScoreValue(SCORE);
    }

    /**
     * Instantiates a new Player
     *
     * @param position
     */
    public Player(final IVector position) {
        super(position, Type.PLAYER);
        this.setScoreValue(SCORE);
    }

    @Override
    public void update() {
        super.update();
        this.getSpriteSet().setNextSprite();
    }

}
