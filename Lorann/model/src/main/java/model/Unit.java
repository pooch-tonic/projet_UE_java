package model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Vector;

import enums.TypeEnum;
import modelInterfaces.IUnit;

/**
 * @author Max Becerro
 *
 */
public abstract class Unit implements IUnit{
	private Vector position;
	private SpriteSet spritesSet;
	private TypeEnum type;
	private int scoreValue;
	
	public Unit(TypeEnum type) {
		setType(type);
	}
	
	public Unit(Vector position,TypeEnum type) {
		setPosition(position);
		setType(type);
		
	}
	
	
	public Unit(Vector position, SpriteSet sprites,TypeEnum type) {
		setPosition(position);
		setSpritesSet(sprites);
		setType(type);
	}
	
	
	
	
	public Vector getPosition() {
		return position;
	}
	public void setPosition(Vector position) {
		this.position = position;
	}
	
	public SpriteSet getSpritesSet() {
		return spritesSet;
	}
	public void setSpritesSet(SpriteSet spritesSet) {
		this.spritesSet = spritesSet;
	}
	
	public int getScoreValue() {
		return scoreValue;
	}
	public void setScoreValue(int scoreValue) {
		this.scoreValue = scoreValue;
	}

	public TypeEnum getType() {
		return type;
	}

	public void setType(TypeEnum type) {
		this.type = type;
	}
}
