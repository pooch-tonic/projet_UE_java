/*
 * 
 */
package model;

import java.awt.Image;

import enums.TypeEnum;
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
    public Enemy(final EnemyName enemyName) {
        super();
        this.setEnemyType(enemyName);

        // TODO Auto-generated constructor stub
    }

    /**
     * Instantiates a new Enemy
     *
     * @param position
     * @param enemyName
     */
    public Enemy(final IVector position, final EnemyName enemyName) {
        super();
        this.setEnemyType(enemyName);
        super.setPosition(position);
        // TODO Auto-generated constructor stub
    }

    @Override
    public int getX() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getY() {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * @param enemyName
     */
    private void setEnemyType(final EnemyName enemyName) {
        switch (enemyName) {
        case KYRACJ:
            super.setType(TypeEnum.ENEMY_A);
            break;
        case CARGYV:
            super.setType(TypeEnum.ENEMY_B);
            break;
        case ARRBARR:
            super.setType(TypeEnum.ENEMY_C);
            break;
        case MAARCG:
            super.setType(TypeEnum.ENEMY_D);
            break;
        }
    }

    @Override
    public Image getImage() {
        // TODO Auto-generated method stub
        return null;
    }
}
