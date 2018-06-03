/*
 *
 */
package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;

import enums.DirectionEnum;
import enums.Type;
import enums.TypeEnum;
import model.dao.QueryDAO;
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
        this.setType(Type.ENEMY);
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

    public Image getImage(EnemyName enemy) throws IOException, SQLException {
    	Image image = null;
    	switch (enemy) {
        case KYRACJ:
            image = ImageLoader.getImageByPath(TypeEnum.ENEMY_A, 0);
            break;
        case CARGYV:
            image = ImageLoader.getImageByPath(TypeEnum.ENEMY_B, 0);
            break;
        case ARRBARR:
            image = ImageLoader.getImageByPath(TypeEnum.ENEMY_C, 0);
            break;
        case MAARCG:
            image = ImageLoader.getImageByPath(TypeEnum.ENEMY_D, 0);
            break;
        }
        return image;
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
            // super.setType(TypeEnum.ENEMY_A);
            break;
        case CARGYV:
            // super.setType(TypeEnum.ENEMY_B);
            break;
        case ARRBARR:
            // super.setType(TypeEnum.ENEMY_C);
            break;
        case MAARCG:
            // super.setType(TypeEnum.ENEMY_D);
            break;
        }
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub

    }

	@Override
	public void move(DirectionEnum direction) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setType(TypeEnum type) {
		// TODO Auto-generated method stub
		
	}
}
