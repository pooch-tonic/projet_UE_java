package model;

import enums.TypeEnum;
import modelInterfaces.IKey;
import modelInterfaces.IVector;

/**
 * @author Max Becerro
 *
 */
public class Key extends Entity implements IKey {

	public Key() {
		super(TypeEnum.KEY);
		// TODO Auto-generated constructor stub
	}

	public Key(final IVector position) {
		super(position, TypeEnum.KEY);
		// TODO Auto-generated constructor stub
	}

}
