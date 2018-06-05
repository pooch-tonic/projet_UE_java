/*
 *
 */
package model;

import java.awt.image.BufferedImage;

import enums.UnitTypeEnum;
import vector.IVector;

/**
 * <h1>The Wall class.</h1> A simple unit that blocks the way of other entities.
 * 
 * @author Ryo SHIINA
 *
 */
public class Wall extends Unit {

	/**
	 * Instantiates a new Wall
	 *
	 * @param wallType
	 */
	public Wall() {
		super(UnitTypeEnum.WALL);
	}

	public Wall(final BufferedImage image) {
		super(UnitTypeEnum.WALL, new SpriteSet(image));
	}

	/**
	 * Instantiates a new Wall
	 *
	 * @param position
	 * @param wallType
	 */
	public Wall(final IVector position) {
		super(UnitTypeEnum.WALL);
		this.setPosition(position);
	}

	public Wall(final IVector position, final BufferedImage image) {
		super(UnitTypeEnum.WALL, new SpriteSet(image));
		this.setPosition(position);
	}
}
