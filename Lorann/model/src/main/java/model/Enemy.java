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

	public Enemy(EnemyName enemyName) {
		super();
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
		// TODO Auto-generated constructor stub
	}

	public Enemy(IVector position, SpriteSet sprites, TypeEnum type) {
		super(position, sprites, type);
		// TODO Auto-generated constructor stub
	}

	public Enemy(IVector position, TypeEnum type) {
		super(position, type);
		// TODO Auto-generated constructor stub
	}
}
