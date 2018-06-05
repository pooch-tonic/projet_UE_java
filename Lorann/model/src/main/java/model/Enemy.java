/*
 *
 */
package model;

import enums.UnitTypeEnum;
import model.behaviorstrategy.BounceTowardsPlayer;
import model.behaviorstrategy.DodgeAside;
import model.behaviorstrategy.DodgeBackwards;
import model.behaviorstrategy.MoveSimple;
import showboard.ISpriteSet;
import vector.IVector;

/**
 * @author Max Becerro
 *
 */
public class Enemy extends Entity {
    public static int SCORE = 100;

    /**
     * Instantiates a new Enemy
     *
     * @param enemyName
     */
    public Enemy(final EnemyNameEnum enemyName, final ISpriteSet spriteSet) {
        super(UnitTypeEnum.ENEMY, spriteSet);
        this.setType(UnitTypeEnum.ENEMY);
        this.setEnemyStrategies(enemyName);
        this.setScoreValue(SCORE);
    }

    /**
     * Instantiates a new Enemy
     *
     * @param position
     * @param enemyName
     */
    public Enemy(final IVector position, final EnemyNameEnum enemyName) {
        super(UnitTypeEnum.ENEMY);
        // this.setEnemyType(enemyName);
        super.setPosition(position);
        this.setScoreValue(SCORE);
    }

    /**
     * @param enemyName
     */
    private void setEnemyStrategies(final EnemyNameEnum enemyName) {
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
