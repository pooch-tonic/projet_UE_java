package model;


import modelInterfaces.IDoor;
import showboard.TypeEnum;
import vector.IVector;

/**
 * @author Max Becerro
 *
 */
public class Door extends Entity implements IDoor {

	/**
	 * Instantiates a new Door
	 * 
	 * @param closed
	 */
	public Door(final boolean closed) {
		super();
		this.setDoorType(closed);

		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new Door
	 * 
	 * @param position
	 * @param closed
	 */
	public Door(final IVector position, final boolean closed) {
		super();
		this.setDoorType(closed);
		super.setPosition(position);

		// TODO Auto-generated constructor stub
	}

	/**
	 * @param closed
	 */
	private void setDoorType(final boolean closed) {
		if (closed) {
			super.setType(TypeEnum.DOOR_CLOSED);
		} else {
			super.setType(TypeEnum.DOOR_OPEN);
		}
	}

}
