package model;

import enums.TypeEnum;
import modelInterfaces.IDead;
import modelInterfaces.IVector;

/**
 * @author Max Becerro
 *
 */
public class Dead extends Entity implements IDead {

	public Dead() {
		super(TypeEnum.DEAD);
	}

	public Dead(final IVector position) {
		super(position, TypeEnum.DEAD);
	}

}
