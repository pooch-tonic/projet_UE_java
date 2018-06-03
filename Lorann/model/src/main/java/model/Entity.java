/*
 *
 */
package model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import enums.Type;
import enums.TypeEnum;
import modelInterfaces.IBounceStrategy;
import modelInterfaces.IDodgeStrategy;
import modelInterfaces.IEntity;
import modelInterfaces.IMoveStrategy;
import showboard.ISpriteSet;
import vector.IVector;

/**
 * @author Max Becerro
 *
 */
public abstract class Entity extends Unit implements IEntity, IMoveStrategy, IBounceStrategy, IDodgeStrategy {

	private IVector direction;
	private IMoveStrategy moveStrategy;
	private IDodgeStrategy dodgeStrategy;
	private IBounceStrategy bounceStrategy;

	/**
	 * Instantiates a new Entity
	 *
	 */
	public Entity() {
		super();
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

	/*
	 * (non-Javadoc)
	 *
	 * @see modelInterfaces.IBounceStrategy#bounce()
	 */
	@Override
	public void bounce() {

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see modelInterfaces.IDodgeStrategy#dodge()
	 */
	@Override
	public void dodge() {

	}

	/**
	 * @return the bounceStrategy
	 */
	private IBounceStrategy getBounceStrategy() {
		return this.bounceStrategy;
	}

	@Override
	/**
	 * @return a direction
	 */
	public IVector getDirection() {
		// TODO Auto-generated method stub
		return this.direction;
	}

	/**
	 * @return the dodgeStrategy
	 */
	private IDodgeStrategy getDodgeStrategy() {
		return this.dodgeStrategy;
	}

	/**
	 * @return the moveStrategy
	 */
	private IMoveStrategy getMoveStrategy() {
		return this.moveStrategy;
	}

	@Override
	/**
	 * @return a position
	 */
	public IVector getPosition() {
		// TODO Auto-generated method stub
		return super.getPosition();
	}

	@Override
	/**
	 * @return a spriteSet
	 */
	public ISpriteSet getSpriteSet() {
		// TODO Auto-generated method stub
		return super.getSpriteSet();
	}

	@Override
	/**
	 * @return a type
	 */
	public Type getType() {
		// TODO Auto-generated method stub
		return super.getType();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see modelInterfaces.IMoveStrategy#move()
	 */
	@Override
	public void move() {
		// TODO Auto-generated method stub

	}

	/**
	 * @param bounceStrategy
	 *            the bounceStrategy to set
	 */
	private void setBounceStrategy(final IBounceStrategy bounceStrategy) {
		this.bounceStrategy = bounceStrategy;
	}

	@Override
	public void setDirection(final IVector direction) {
		// TODO Auto-generated method stub

	}

	/**
	 * @param dodgeStrategy
	 *            the dodgeStrategy to set
	 */
	private void setDodgeStrategy(final IDodgeStrategy dodgeStrategy) {
		this.dodgeStrategy = dodgeStrategy;
	}

	/**
	 * @param moveStrategy
	 *            the moveStrategy to set
	 */
	private void setMoveStrategy(final IMoveStrategy moveStrategy) {
		this.moveStrategy = moveStrategy;
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
	public void setType(final Type type) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {

	}

	public Image getImage(TypeEnum type) {
		// TODO Auto-generated method stub
		return null;
	}

}
