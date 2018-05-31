package model;

import java.util.Vector;

import enums.TypeEnum;
import modelInterfaces.ILoot;

/**
 * @author Max Becerro
 *
 */
public class Loot extends Entity implements ILoot{

	public Loot(TypeEnum type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	public Loot(Vector position, SpriteSet sprites, TypeEnum type) {
		super(position, sprites, type);
		// TODO Auto-generated constructor stub
	}

	public Loot(Vector position, TypeEnum type) {
		super(position, type);
		// TODO Auto-generated constructor stub
	}

}
