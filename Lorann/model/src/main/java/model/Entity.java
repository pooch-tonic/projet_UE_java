package model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Vector;

import enums.DirectionsEnum;
import enums.TypeEnum;
import modelInterfaces.IEntity;
import modelInterfaces.IVector;

public class Entity extends Unit implements IEntity{
	
	private Vector direction;
	
	
	public Entity(TypeEnum type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	public Entity(Vector position, SpriteSet sprites, TypeEnum type) {
		super(position, sprites, type);
		// TODO Auto-generated constructor stub
	}

	public Entity(Vector position, TypeEnum type) {
		super(position, type);
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	

	
	
	
	

	@Override
	public Vector getPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPosition(Vector position) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<BufferedImage> getSpriteSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSpriteSet(ArrayList<BufferedImage> sprites) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TypeEnum getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setType(TypeEnum type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IVector getDirection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void move(DirectionsEnum direction) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDirection(IVector direction) {
		// TODO Auto-generated method stub
		
	}

	
	
	

	
}
