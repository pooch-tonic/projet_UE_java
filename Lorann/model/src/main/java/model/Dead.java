package model;

import java.util.Vector;

import enums.TypeEnum;
import modelInterfaces.IDead;
import modelInterfaces.IVector;

/**
 * @author Max Becerro
 *
 */
public class Dead extends Entity implements IDead{

	public Dead() {
		super(TypeEnum.DEAD);
		// TODO Auto-generated constructor stub
	}



	public Dead(IVector position) {
		super(position, TypeEnum.DEAD);
		// TODO Auto-generated constructor stub
	}

}
