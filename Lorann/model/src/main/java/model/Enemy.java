package model;

import java.util.Vector;

import enums.TypeEnum;
import modelInterfaces.IEnemy;
import modelInterfaces.IVector;

/**
 * @author Max Becerro
 *
 */
public class Enemy extends Entity implements IEnemy{

	private void setEnemyType(EnemyName enemyName) {
		switch (enemyName) {
		case KYRACJ: super.setType(TypeEnum.ENEMY_A);
			break;
		case CARGYV:super.setType(TypeEnum.ENEMY_B);
			break;
		case ARRBARR:super.setType(TypeEnum.ENEMY_C);
			break;
		case MAARCG:super.setType(TypeEnum.ENEMY_D);
			break;
		}
	}
		
		
	public Enemy(EnemyName enemyName) {
		super();
		this.setEnemyType(enemyName);
		
		
		// TODO Auto-generated constructor stub
	}


	public Enemy(IVector position, EnemyName enemyName) {
		super();
		this.setEnemyType(enemyName);
		super.setPosition(position);
		// TODO Auto-generated constructor stub
	}
}
