package model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;


import enums.TypeEnum;
import modelInterfaces.IUnit;
import modelInterfaces.IVector;

/**
 * @author Max Becerro
 *
 */
public abstract class Unit implements IUnit{
	private IVector position;
	private SpriteSet spritesSet;
	private TypeEnum type;
	private int scoreValue;
	
	public Unit() {
		
	}
	
	public Unit(TypeEnum type) {
		setType(type);
	}
	
	public Unit(IVector position,TypeEnum type) {
		setPosition(position);
		setType(type);
		
	}
	
	
	public Unit(IVector position, SpriteSet sprites,TypeEnum type) {
		setPosition(position);
		setSpritesSet(sprites);
		setType(type);
	}
	
	
	
	
	public IVector getPosition() {
		return this.position;
	}
	public void setPosition(IVector position) {
		this.position = position;
	}
	
	public SpriteSet getSpritesSet() {
		return this.spritesSet;
	}
	public void setSpritesSet(SpriteSet spritesSet) {
		this.spritesSet = spritesSet;
	}
	
	public int getScoreValue() {
		return this.scoreValue;
	}
	public void setScoreValue(int scoreValue) {
		this.scoreValue = scoreValue;
	}

	public TypeEnum getType() {
		return this.type;
	}

	public void setType(TypeEnum type) {
		this.type = type;
	}
}
