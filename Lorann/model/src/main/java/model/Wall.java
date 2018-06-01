package model;

import java.awt.Image;

import enums.TypeEnum;
import modelInterfaces.IWall;
import vector.IVector;

/**
 * @author Max Becerro
 *
 */
public class Wall extends Block implements IWall {

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
	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
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
