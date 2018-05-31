package model;

import java.util.Vector;

import enums.TypeEnum;
import modelInterfaces.IKey;
import modelInterfaces.IVector;

/**
 * @author Max Becerro
 *
 */
public class Key extends Entity implements IKey{

	public Key() {
		super(TypeEnum.KEY);
		// TODO Auto-generated constructor stub
	}



	public Key(IVector position) {
		super(position, TypeEnum.KEY);
		// TODO Auto-generated constructor stub
	}

}
