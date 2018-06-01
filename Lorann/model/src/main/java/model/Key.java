package model;


import modelInterfaces.IKey;
import showboard.TypeEnum;
import vector.IVector;

/**
 * @author Max Becerro
 *
 */
public class Key extends Entity implements IKey {

	/**
	 * Instantiates a new Key
	 * 
	 */
	public Key() {
		super(TypeEnum.KEY);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new Key
	 * 
	 * @param position
	 */
	public Key(final IVector position) {
		super(position, TypeEnum.KEY);
		// TODO Auto-generated constructor stub
	}

}
