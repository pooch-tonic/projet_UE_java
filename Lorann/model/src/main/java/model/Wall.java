/*
 *
 */
package model;

import java.awt.image.BufferedImage;

import enums.Type;
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
		super();
	}

	public Wall(final BufferedImage image) {
		super(new SpriteSet(image), Type.WALL);
	}

	/**
	 * Instantiates a new Wall
	 *
	 * @param position
	 * @param wallType
	 */
	public Wall(final IVector position) {
		super();
		this.setPosition(position);
	}

	public Wall(final IVector position, final BufferedImage image) {
		super(new SpriteSet(image), Type.WALL);
		this.setPosition(position);
	}
}
