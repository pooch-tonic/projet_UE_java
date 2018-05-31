package model;

import enums.TypeEnum;
import modelInterfaces.IDoor;
import modelInterfaces.IVector;

/**
 * @author Max Becerro
 *
 */
public class Door extends Entity implements IDoor {

	public Door(final boolean closed) {
		super();
		this.setDoorType(closed);

		// TODO Auto-generated constructor stub
	}

	public Door(final IVector position, final boolean closed) {
		super();
		this.setDoorType(closed);
		super.setPosition(position);

		// TODO Auto-generated constructor stub
	}

	private void setDoorType(final boolean closed) {
		if (closed) {
			super.setType(TypeEnum.DOOR_CLOSED);
		} else {
			super.setType(TypeEnum.DOOR_OPEN);
		}
	}

}
