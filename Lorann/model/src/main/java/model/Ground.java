package model;

import java.io.IOException;

import javax.imageio.ImageIO;

import enums.UnitTypeEnum;
import vector.IVector;

public class Ground extends Unit {

	/**
	 * Default constructor : instantiates a new Wall.
	 */
	public Ground() {
		super(new SpriteSet(), UnitTypeEnum.GROUND);
		this.getSpriteSet().getSprites().add(null);
	}

	/**
	 * A constructor based on a position vector.tt
	 *
	 * @param position
	 */
	public Ground(final IVector position) {
		super(UnitTypeEnum.GROUND);
		this.setPosition(position);
	}
}
