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
import modelInterfaces.ILevel;
import modelInterfaces.IMoveStrategy;
import showboard.ISpriteSet;
import vector.IVector;

/**
 * @author Max Becerro
 *
 */
public abstract class Entity extends Unit implements IEntity {

	private IVector direction;
	private IMoveStrategy moveStrategy;
	private IDodgeStrategy dodgeStrategy;
	private IBounceStrategy bounceStrategy;
	private int scoreValue;

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

	/**
	 * Instantiates a new Entity
	 *
	 * @param type
	 * @param spriteSet
	 *
	 */
	public Entity(final Type type, final ISpriteSet spriteSet) {
		super(type, spriteSet);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see modelInterfaces.IBounceStrategy#bounce()
	 */

	@Override
	public void bounce(final ILevel level) {
		this.getBounceStrategy().bounce(this, level);
	}

	@Override
	public void dodge(final ILevel level) {
		this.getDodgeStrategy().dodge(this, level);
	}

	/**
	 * @return the bounceStrategy
	 */
	private IBounceStrategy getBounceStrategy() {
		return this.bounceStrategy;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see modelInterfaces.IDodgeStrategy#dodge()
	 */

	@Override
	/**
	 * @return a direction
	 */
	public IVector getDirection() {
		return this.direction;
	}

	/**
	 * @return the dodgeStrategy
	 */
	private IDodgeStrategy getDodgeStrategy() {
		return this.dodgeStrategy;
	}

	public Image getImage(final TypeEnum type) {
		return super.getSpriteSet().getCurrentSprite();
		// TODO ROMAIN TU DOIS ADAPTER A CETTE UTILISATION DU SPRITESET
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
		return super.getPosition();
	}

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

	@Override
	public int getX() {
		return this.getPosition().getX();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see modelInterfaces.IMoveStrategy#move()
	 */

	@Override
	public int getY() {
		return this.getPosition().getY();
	}

	@Override
	public void move() {
		this.getMoveStrategy().move();
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
		this.direction = direction;
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
		super.setPosition(position);
	}

	public void setScoreValue(final int scoreValue) {
		this.scoreValue = scoreValue;
	}

	@Override
	public void setSpriteSet(final ArrayList<BufferedImage> sprites) {
		super.setSpriteSet(sprites);
	}

	@Override
	public void setSpriteSet(final ISpriteSet spriteSet) {
		super.setSpriteSet(spriteSet);
	}

	@Override
	public void setType(final Type type) {
		super.setType(type);
	}

	@Override
	public void update() {

	}
}
