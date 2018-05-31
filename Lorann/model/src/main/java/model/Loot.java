package model;

import enums.TypeEnum;
import modelInterfaces.ILoot;
import modelInterfaces.IVector;

/**
 * @author Max Becerro
 *
 */
public class Loot extends Entity implements ILoot {

	public Loot() {
		super(TypeEnum.LOOT);
		// TODO Auto-generated constructor stub
	}

	public Loot(final IVector position) {
		super(position, TypeEnum.LOOT);
		// TODO Auto-generated constructor stub
	}

}
