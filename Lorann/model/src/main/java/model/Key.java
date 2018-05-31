package model;

import java.util.Vector;

import enums.TypeEnum;
import modelInterfaces.IKey;

/**
 * @author Max Becerro
 *
 */
public class Key extends Entity implements IKey{

	public Key(TypeEnum type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	public Key(Vector position, SpriteSet sprites, TypeEnum type) {
		super(position, sprites, type);
		// TODO Auto-generated constructor stub
	}

	public Key(Vector position, TypeEnum type) {
		super(position, type);
		// TODO Auto-generated constructor stub
	}

}
