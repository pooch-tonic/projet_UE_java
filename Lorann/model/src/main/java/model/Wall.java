/*
 *
 */
package model;

import java.awt.image.BufferedImage;

import enums.UnitTypeEnum;
import vector.IVector;

/**
 * @author Max Becerro
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
