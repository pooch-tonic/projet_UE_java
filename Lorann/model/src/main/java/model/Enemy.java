package model;

import enums.TypeEnum;
import modelInterfaces.IEnemy;
import modelInterfaces.IVector;

/**
 * @author Max Becerro
 *
 */
public class Enemy extends Entity implements IEnemy {

	public Enemy(final EnemyName enemyName) {
		super();
		this.setEnemyType(enemyName);

		// TODO Auto-generated constructor stub
	}

	public Enemy(final IVector position, final EnemyName enemyName) {
		super();
		this.setEnemyType(enemyName);
		super.setPosition(position);
		// TODO Auto-generated constructor stub
	}

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
}
