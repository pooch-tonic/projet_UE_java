/*
 *
 */
package model;

import enums.Type;
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
		super(Type.ENEMY);
		// this.setEnemyType(enemyName);
		super.setPosition(position);
		// TODO Auto-generated constructor stub
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

}
