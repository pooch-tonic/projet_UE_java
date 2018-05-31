package model;

import java.util.Vector;

import enums.TypeEnum;
import modelInterfaces.IDoor;

/**
 * @author Max Becerro
 *
 */
public class Door extends Entity implements IDoor{

	public Door(TypeEnum type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	public Door(Vector position, SpriteSet sprites, TypeEnum type) {
		super(position, sprites, type);
		// TODO Auto-generated constructor stub
	}

	public Door(Vector position, TypeEnum type) {
		super(position, type);
		// TODO Auto-generated constructor stub
	}

}
