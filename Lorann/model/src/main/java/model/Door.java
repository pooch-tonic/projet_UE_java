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
	
	

	public Door(boolean closed) {
		super();
		if(closed) {
			super.setType(TypeEnum.DOOR_CLOSED);
		}else {
			super.setType(TypeEnum.DOOR_OPEN);
		}
		
		// TODO Auto-generated constructor stub
	}

	public Door(IVector position, boolean closed) {
		super();
		if(closed) {
			super.setType(TypeEnum.DOOR_CLOSED);
		}else {
			super.setType(TypeEnum.DOOR_OPEN);
		}
		
		// TODO Auto-generated constructor stub
	}


}
