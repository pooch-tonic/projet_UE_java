package model;

import enums.TypeEnum;
import vector.IVector;

/**
 * @author Max Becerro
 *
 */
public class Wall implements IUnit {

	/**
	 * Instantiates a new Wall
	 *
	 * @param position
	 * @param wallType
	 */
	public Wall(final IVector position, final WallType wallType) {
		super();
		this.setWallType(wallType);
		this.setPosition(position);

		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new Wall
	 *
	 * @param wallType
	 */
	public Wall(final WallType wallType) {
		super();
		this.setWallType(wallType);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getX() {
		return this.getPosition().getX();
	}

	@Override
	public int getY() {
		return this.getPosition().getY();
	}

	/**
	 * @param wallType
	 */
	private void setWallType(final WallType wallType) {
		switch (wallType) {
		case WALL_ROUND:
			super.setType(TypeEnum.WALL);
			break;
		case WALL_VERTICAL:
			super.setType(TypeEnum.WALL_V);
			break;
		case WALL_HORIZONTAL:
			super.setType(TypeEnum.WALL_H);
			break;
		}
	}

}
