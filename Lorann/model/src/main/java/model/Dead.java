package model;

import enums.TypeEnum;
import vector.IVector;

/**
 * @author Max Becerro
 *
 */
public class Dead extends Entity {

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

	@Override
	public int getX() {
		return this.getPosition().getX();
	}

	@Override
	public int getY() {
		return this.getPosition().getY();
	}

}
