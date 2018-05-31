package model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import enums.DirectionsEnum;
import enums.TypeEnum;
import modelInterfaces.IEntity;
import modelInterfaces.ISpriteSet;
import modelInterfaces.IVector;

public class Entity extends Unit implements IEntity {

	private IVector direction;

	public Entity() {
		super();
	}

	public Entity(final IVector position, final ISpriteSet spriteSet, final TypeEnum type) {
		super(position, spriteSet, type);
		// TODO Auto-generated constructor stub
	}

	public Entity(final IVector position, final TypeEnum type) {
		super(position, type);
		// TODO Auto-generated constructor stub
	}

	public Entity(final TypeEnum type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public IVector getDirection() {
		// TODO Auto-generated method stub
		return this.direction;
	}

	@Override
	public IVector getPosition() {
		// TODO Auto-generated method stub
		return super.getPosition();
	}

	@Override
	public ISpriteSet getSpriteSet() {
		// TODO Auto-generated method stub
		return super.getSpriteSet();
	}

	@Override
	public TypeEnum getType() {
		// TODO Auto-generated method stub
		return super.getType();
	}

	@Override
	public void move(final DirectionsEnum direction) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDirection(final IVector direction) {
		// TODO Auto-generated method stub

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
	public void setType(final TypeEnum type) {
		// TODO Auto-generated method stub

	}

}
