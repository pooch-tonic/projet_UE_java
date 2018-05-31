package model;

import java.util.Vector;

import enums.TypeEnum;
import modelInterfaces.IDoor;
import modelInterfaces.IVector;

/**
 * @author Max Becerro
 *
 */
public class Door extends Entity implements IDoor{
	
	private void setDoorType(boolean closed) {
		if(closed) {
			super.setType(TypeEnum.DOOR_CLOSED);
		}else {
			super.setType(TypeEnum.DOOR_OPEN);
		}
	}

	public Door(boolean closed) {
		super();
		this.setDoorType(closed);
		
		// TODO Auto-generated constructor stub
	}

	public Door(IVector position, boolean closed) {
		super();
		this.setDoorType(closed);
		super.setPosition(position);
		
		// TODO Auto-generated constructor stub
	}


}
