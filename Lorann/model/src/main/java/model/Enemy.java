package model;

import java.util.Vector;

import enums.TypeEnum;
import modelInterfaces.IEnemy;

/**
 * @author Max Becerro
 *
 */
public class Enemy extends Entity implements IEnemy{

	public Enemy(TypeEnum type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	public Enemy(Vector position, SpriteSet sprites, TypeEnum type) {
		super(position, sprites, type);
		// TODO Auto-generated constructor stub
	}

	public Enemy(Vector position, TypeEnum type) {
		super(position, type);
		// TODO Auto-generated constructor stub
	}


	
}
