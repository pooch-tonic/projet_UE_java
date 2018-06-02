package model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import enums.TypeEnum;
import modelInterfaces.IUnit;
import showboard.ISpriteSet;
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
		this.setWallType(wallType);
		// TODO Auto-generated constructor stub
	}

	@Override
	public IVector getPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ISpriteSet getSpriteSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeEnum getType() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getX() {
		return this.getPosition().getX();
	}

	public int getY() {
		return this.getPosition().getY();
	}

	@Override
	public void setPosition(final IVector position) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSpriteSet(final ArrayList<BufferedImage> sprites) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSpriteSet(final ISpriteSet spriteSet) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setType(final TypeEnum type) {
		// TODO Auto-generated method stub

	}

	/**
	 * @param wallType
	 */
	private void setWallType(final WallType wallType) {
		switch (wallType) {
		case WALL_ROUND:
			this.setType(TypeEnum.WALL);
			break;
		case WALL_VERTICAL:
			this.setType(TypeEnum.WALL_V);
			break;
		case WALL_HORIZONTAL:
			this.setType(TypeEnum.WALL_H);
			break;
		}
	}

}
