/*
 *
 */
package modelInterfaces;

import enums.Type;
import showboard.IPawn;
import showboard.ISpriteSet;
import vector.IVector;

/**
 * Interface used by all moving units, so-called entities. It extends IPawn in
 * order to be displayed on the showboard.
 *
 * @author Ryo
 *
 */
public interface IEntity extends IPawn {
	/**
	 * calls the bounce() method from the IBounceStrategy object.
	 */
	public void bounce(final ILevel level);

	/**
	 * calls the dodge() method from the IDodgeStrategy object.
	 */
	public void dodge(final ILevel level);

	/**
	 * @return the direction vector of the entity.
	 */
	public IVector getDirection();

	/**
	 * returns the last direction taken.
	 *
	 * @return the last direction taken
	 */
	public IVector getLastDirection();

	/**
	 * returns the score value of the entity.
	 *
	 * @return the score value.
	 */
	int getScoreValue();

	/**
	 * returns the spriteset of the entity.
	 *
	 * @return a spriteset
	 */
	public ISpriteSet getSpriteSet();

	/**
	 * Returns the type enumeration of the entity, which allows the controller to
	 * identify it.
	 *
	 * @return a type enumeration
	 */
	public Type getType();

	/**
	 * Calls the move() method from the IMoveStrategy object.
	 */
	public void move();

	/**
	 * Sets the direction vector of the entity.
	 *
	 * @param direction
	 */
	void setDirection(IVector direction);

	/**
	 * Sets the last direction taken.
	 *
	 * @param lastDirection
	 */
	public void setLastDirection(final IVector lastDirection);

	/**
	 * Sets the position vector pf the entity.
	 *
	 * @param position
	 */
	void setPosition(final IVector position);

	/**
	 * Sets the type enumeration of the entity.
	 *
	 * @param type
	 */
	void setType(Type type);

	/**
	 * Contains all the actions to be executed for a full update of the entity.
	 */
	void update();

	/**
	 * Returns the durability of the entity. If this equals 0, the entity can be
	 * destroyed instantly. If this returns a value higher than 0, then it will
	 * require a proportional time (counted in frames) before getting destroyed.
	 *
	 * @return
	 */
	public int getDurability();

	/**
	 * Decrements the durability of the entity. If its value is already 0, the
	 * operation won't happen.
	 * 
	 * @return
	 */
	public void decrementDurability();

	/**
	 * @param bounceStrategy
	 *            the bounceStrategy to set
	 */
	void setBounceStrategy(final IBounceStrategy bounceStrategy);

	/**
	 * @param dodgeStrategy
	 *            the dodgeStrategy to set
	 */
	void setDodgeStrategy(final IDodgeStrategy dodgeStrategy);

	/**
	 * @param moveStrategy
	 *            the moveStrategy to set
	 */
	void setMoveStrategy(final IMoveStrategy moveStrategy);

	/**
	 * Gets the bounceStrategy
	 *
	 * @return the bounceStrategy
	 */
	public IBounceStrategy getBounceStrategy();

	/**
	 * Gets the dodgeStrategy
	 *
	 * @return the dodgeStrategy
	 */
	public IDodgeStrategy getDodgeStrategy();

	/**
	 * Gets the moveStrategy
	 *
	 * @return the moveStrategy
	 */
	public IMoveStrategy getMoveStrategy();

}
