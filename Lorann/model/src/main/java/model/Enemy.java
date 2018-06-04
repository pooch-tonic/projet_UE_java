/*
 *
 */
package model;

import enums.Type;
import model.behaviorStrategy.BounceTowardsPlayer;
import model.behaviorStrategy.DodgeAside;
import model.behaviorStrategy.DodgeBackwards;
import model.behaviorStrategy.MoveSimple;
import showboard.ISpriteSet;
import vector.IVector;

/**
 * @author Max Becerro
 *
 */
public class Enemy extends Entity {

    /**
     * Instantiates a new Enemy
     *
     * @param enemyName
     */
    public Enemy(final EnemyName enemyName, final ISpriteSet spriteSet) {
        super(Type.ENEMY, spriteSet);
        this.setType(Type.ENEMY);
        this.setEnemyStrategies(enemyName);
    }

    /**
     * Instantiates a new Enemy
     *
     * @param position
     * @param enemyName
     */
    public Enemy(final IVector position, final EnemyName enemyName) {
        super(Type.ENEMY);
        // this.setEnemyType(enemyName);
        super.setPosition(position);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param enemyName
     */
    private void setEnemyStrategies(final EnemyName enemyName) {
        switch (enemyName) {
        case KYRACJ:
            this.setBounceStrategy(new BounceTowardsPlayer());
            this.setDodgeStrategy(new DodgeAside());
            break;
        case CARGYV:
            this.setBounceStrategy(new BounceTowardsPlayer());
            this.setDodgeStrategy(new DodgeAside());
            break;
        case ARRBARR:
            this.setBounceStrategy(new BounceTowardsPlayer());
            this.setDodgeStrategy(new DodgeBackwards());
            break;
        case MAARCG:
            this.setBounceStrategy(new BounceTowardsPlayer());
            this.setDodgeStrategy(new DodgeBackwards());
            break;
        }
        this.setMoveStrategy(new MoveSimple());
    }

}
