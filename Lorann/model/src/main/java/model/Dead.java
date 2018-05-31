package model;

import java.util.Vector;

import enums.TypeEnum;
import modelInterfaces.IDead;

/**
 * @author Max Becerro
 *
 */
public class Dead extends Entity implements IDead{

	public Dead(TypeEnum type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	public Dead(Vector position, SpriteSet sprites, TypeEnum type) {
		super(position, sprites, type);
		// TODO Auto-generated constructor stub
	}

	public Dead(Vector position, TypeEnum type) {
		super(position, type);
		// TODO Auto-generated constructor stub
	}

}
