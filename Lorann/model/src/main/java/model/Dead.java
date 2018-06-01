package model;


import modelInterfaces.IDead;
import showboard.TypeEnum;
import vector.IVector;

/**
 * @author Max Becerro
 *
 */
public class Dead extends Entity implements IDead {

	/**
	 * Instantiates a new Dead
	 * 
	 */
	public Dead() {
		super(TypeEnum.DEAD);
	}

	/**
	 * Instantiates a new Dead
	 * 
	 * @param position
	 */
	public Dead(final IVector position) {
		super(position, TypeEnum.DEAD);
	}

}
