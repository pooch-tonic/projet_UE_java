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
     * @return the type enumeration of the entity, which allows the controller to
     *         identify it.
     */
    public Type getType();

    /**
     * calls the move() method from the IMoveStrategy object.
     */
    public void move();

    /**
     * sets the direction vector of the entity.
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
     * sets the position vector pf the entity.
     *
     * @param position
     */
    void setPosition(final IVector position);

    /**
     * sets the type enumeration of the entity.
     *
     * @param type
     */
    void setType(Type type);

    /**
     * contains all the actions to be executed for a full update of the entity.
     */
    void update();

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
