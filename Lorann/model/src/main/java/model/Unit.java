/*
 *
 */
package model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import enums.Type;
import modelInterfaces.IUnit;
import showboard.ISpriteSet;
import vector.IVector;
import vector.Vector;

/**
 * <h1>The Unit class, which is the base class for all objects contained by the
 * map.</h1>
 *
 * @author Max Becerro
 * @author Ryo SHIINA
 *
 */
public class Unit implements IUnit {
	private IVector position;
	private ISpriteSet spriteSet;
	private Type type;

	/**
	 * Instantiates a new Unit
	 * @param type 
	 * @param spriteSet 
	 *
	 */
	public Unit(Type type, ISpriteSet spriteSet) {
		this.setPosition(null);
		this.setSpriteSet(spriteSet);
		this.setType(type);
	}

	/**
	 * Instantiates a new Unit
	 *
	 * @param spriteSet
	 * @param type
	 */
	public Unit(final ISpriteSet spriteSet, final Type type) {
		this.setPosition(null);
		this.setSpriteSet(spriteSet);
		this.setType(type);
	}

	/**
	 * Instantiates a new Unit
	 *
	 * @param position
	 * @param spriteSet
	 * @param type
	 */
	public Unit(final IVector position, final ISpriteSet spriteSet, final Type type) {
		this.setPosition(position);
		this.setSpriteSet(spriteSet);
		this.setType(type);
	}

	/**
	 * Instantiates a new Unit
	 *
	 * @param position
	 * @param type
	 */
	public Unit(final IVector position, final Type type) {
		this.setPosition(position);
		this.setSpriteSet(new ArrayList<BufferedImage>());
		this.setType(type);
	}

	/**
	 * Instantiates a new Unit
	 *
	 * @param type
	 */
	public Unit(final Type type) {
		this.setPosition(new Vector(0, 0));
		this.setSpriteSet(new ArrayList<BufferedImage>());
		this.setType(type);
	}

	@Override
	public Image getImage() {
		return this.getSpriteSet().getCurrentSprite();
	}

	@Override
	public IVector getPosition() {
		return this.position;
	}

	@Override
	public ISpriteSet getSpriteSet() {
		return this.spriteSet;
	}

	@Override
	public Type getType() {
		return this.type;
	}

	@Override
	public void setPosition(final IVector position) {
		this.position = position;
	}

	@Override
	public void setSpriteSet(final ArrayList<BufferedImage> sprites) {
		this.spriteSet.setSprites(sprites);
	}

	@Override
	public void setSpriteSet(final BufferedImage image) {
		this.getSpriteSet().setSprites(image);
	}

	@Override
	public void setSpriteSet(final ISpriteSet spriteSet) {
		this.spriteSet.setSprites(spriteSet);
	}

	@Override
	public void setType(final Type type) {
		this.type = type;
	}
}
