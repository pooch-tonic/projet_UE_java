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


	public int getX() {
		return this.getPosition().getX();
	}


	public int getY() {
		return this.getPosition().getY();
	}

	/**
	 * @param wallType
	 */
	private void setWallType(final WallType wallType) {
		switch (wallType) {
		case WALL_ROUND:
			setType(TypeEnum.WALL);
			break;
		case WALL_VERTICAL:
			setType(TypeEnum.WALL_V);
			break;
		case WALL_HORIZONTAL:
			setType(TypeEnum.WALL_H);
			break;
		}
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

	@Override
	public void setPosition(IVector position) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSpriteSet(ArrayList<BufferedImage> sprites) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSpriteSet(ISpriteSet spriteSet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setType(TypeEnum type) {
		// TODO Auto-generated method stub
		
	}

}
