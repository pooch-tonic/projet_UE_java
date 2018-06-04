package model;

import java.io.IOException;

import javax.imageio.ImageIO;

import enums.Type;
import vector.IVector;

public class Ground extends Unit {

	/**
	 * Default constructor : instantiates a new Wall.
	 */
	public Ground() {
		super(new SpriteSet(), Type.GROUND);
		try {
			this.getSpriteSet().getSprites().add(ImageIO.read(Ground.class.getResource("/sprites/ground.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * A constructor based on a position vector.tt
	 *
	 * @param position
	 */
	public Ground(final IVector position) {
		super(Type.GROUND);
		this.setPosition(position);
	}
}
