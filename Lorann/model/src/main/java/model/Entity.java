/*
 *
 */
package model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import enums.Type;
import enums.TypeEnum;
import model.factories.VectorFactory;
import modelInterfaces.IBounceStrategy;
import modelInterfaces.IDodgeStrategy;
import modelInterfaces.IEntity;
import modelInterfaces.ILevel;
import modelInterfaces.IMoveStrategy;
import showboard.ISpriteSet;
import vector.IVector;
import vector.Vector;

/**
 * @author Max Becerro
 *
 */
public abstract class Entity extends Unit implements IEntity {
	/**
	 * The last direction taken by Lorann, which allows Lorann to shoot the fireball
	 * in the opposite direction.
	 */
	private IVector lastDirection;
	private IVector direction;
	private IMoveStrategy moveStrategy;
	private IDodgeStrategy dodgeStrategy;
	private IBounceStrategy bounceStrategy;
	private int durability;
	private int scoreValue;

	/**
	 * Instantiates a new Entity
	 *
	 * @param position
	 * @param spriteSet
	 * @param type
	 * @param durability
	 * @param scoreValue
	 */
	public Entity(final IVector position, final ISpriteSet spriteSet, final Type type, final int durability,
			final int scoreValue) {
		super(position, spriteSet, type);
		this.setDurability(durability);
		this.setLastDirection(new Vector(0, 0));
		this.setScoreValue(scoreValue);
	}

	/**
	 * Instantiates a new Entity
	 *
	 * @param position
	 * @param spriteSet
	 * @param type
	 * @param durability
	 */
	public Entity(final IVector position, final ISpriteSet spriteSet, final Type type, final int durability) {
		super(position, spriteSet, type);
		this.setDurability(durability);
		this.setLastDirection(new Vector(0, 0));
		this.setScoreValue(0);
	}

	/**
	 * Instantiates a new Entity
	 *
	 * @param position
	 * @param spriteSet
	 * @param type
	 */
	public Entity(final IVector position, final ISpriteSet spriteSet, final Type type) {
		super(position, spriteSet, type);
		this.setDurability(0);
		this.setLastDirection(new Vector(0, 0));
		this.setScoreValue(0);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see modelInterfaces.IEntity#getDurability()
	 */
	@Override
	public int getDurability() {
		return this.durability;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see modelInterfaces.IEntity#decrementDurability()
	 */
	@Override
	public void decrementDurability() {
		if (this.getDurability() != 0) {
			this.setDurability(this.getDurability() - 1);
		}
	}

	/**
	 * Instantiates a new Entity
	 *
	 * @param position
	 * @param type
	 */
	public Entity(final IVector position, final Type type) {
		super(position, type);
	}

	/**
	 * Instantiates a new Entity
	 *
	 * @param type
	 */
	public Entity(final Type type) {
		super(type);
	}

	/**
	 * Instantiates a new Entity
	 *
	 * @param type
	 * @param spriteSet
	 *
	 */
	public Entity(final Type type, final ISpriteSet spriteSet) {
		super(type, spriteSet);
		this.setDirection(VectorFactory.getMIDDLE());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see modelInterfaces.IEntity#bounce(modelInterfaces.ILevel)
	 */
	@Override
	public void bounce(final ILevel level) {
		this.getBounceStrategy().bounce(this, level);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see modelInterfaces.IEntity#dodge(modelInterfaces.ILevel)
	 */
	@Override
	public void dodge(final ILevel level) {
		this.getDodgeStrategy().dodge(this, level);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see modelInterfaces.IEntity#getBounceStrategy()
	 */
	@Override
	public IBounceStrategy getBounceStrategy() {
		return this.bounceStrategy;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see modelInterfaces.IEntity#getDirection()
	 */
	@Override
	public IVector getDirection() {
		return this.direction;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see modelInterfaces.IDodgeStrategy#dodge()
	 */
	@Override
	public IDodgeStrategy getDodgeStrategy() {
		return this.dodgeStrategy;
	}

	/**
	 * @param type
	 * @return
	 */
	public Image getImage(final TypeEnum type) {
		return super.getSpriteSet().getCurrentSprite();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see modelInterfaces.IEntity#getLastDirection()
	 */
	@Override
	public IVector getLastDirection() {
		return this.lastDirection;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see modelInterfaces.IEntity#getMoveStrategy()
	 */
	@Override
	public IMoveStrategy getMoveStrategy() {
		return this.moveStrategy;
	}

	@Override
	/**
	 * @return a position
	 */
	public IVector getPosition() {
		return super.getPosition();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see modelInterfaces.IEntity#getScoreValue()
	 */
	@Override
	public int getScoreValue() {
		return this.scoreValue;
	}

	@Override
	/**
	 * @return a spriteSet
	 */
	public ISpriteSet getSpriteSet() {
		return super.getSpriteSet();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see showboard.IPawn#getX()
	 */
	@Override
	public int getX() {
		return this.getPosition().getX();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see showboard.IPawn#getY()
	 */
	@Override
	public int getY() {
		return this.getPosition().getY();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see modelInterfaces.IEntity#move()
	 */
	@Override
	public void move() {
		this.getMoveStrategy().move(this);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * modelInterfaces.IEntity#setBounceStrategy(modelInterfaces.IBounceStrategy)
	 */
	@Override
	public void setBounceStrategy(final IBounceStrategy bounceStrategy) {
		this.bounceStrategy = bounceStrategy;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see modelInterfaces.IEntity#setDirection(vector.IVector)
	 */
	@Override
	public void setDirection(final IVector direction) {
		this.direction = direction;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see modelInterfaces.IEntity#setDodgeStrategy(modelInterfaces.IDodgeStrategy)
	 */
	@Override
	public void setDodgeStrategy(final IDodgeStrategy dodgeStrategy) {
		this.dodgeStrategy = dodgeStrategy;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see modelInterfaces.IEntity#setLastDirection(vector.IVector)
	 */
	@Override
	public void setLastDirection(final IVector lastDirection) {
		this.lastDirection = lastDirection;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see modelInterfaces.IEntity#setMoveStrategy(modelInterfaces.IMoveStrategy)
	 */
	@Override
	public void setMoveStrategy(final IMoveStrategy moveStrategy) {
		this.moveStrategy = moveStrategy;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.Unit#setPosition(vector.IVector)
	 */
	@Override
	public void setPosition(final IVector position) {
		super.setPosition(position);
	}

	/**
	 * @param scoreValue
	 */
	public void setScoreValue(final int scoreValue) {
		this.scoreValue = scoreValue;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.Unit#setSpriteSet(java.util.ArrayList)
	 */
	@Override
	public void setSpriteSet(final ArrayList<BufferedImage> sprites) {
		super.setSpriteSet(sprites);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.Unit#setSpriteSet(showboard.ISpriteSet)
	 */
	@Override
	public void setSpriteSet(final ISpriteSet spriteSet) {
		super.setSpriteSet(spriteSet);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.Unit#setType(enums.Type)
	 */
	@Override
	public void setType(final Type type) {
		super.setType(type);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see modelInterfaces.IEntity#update()
	 */
	@Override
	public void update() {
		this.move();
	}

	/**
	 * @param durability
	 *            the durability to set
	 */
	private void setDurability(final int durability) {
		this.durability = durability;
	}
}
