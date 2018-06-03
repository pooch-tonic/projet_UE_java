package modelInterfaces;

import enums.Type;
import enums.TypeEnum;
import showboard.IPawn;
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
	public void bounce();

	/**
	 * calls the dodge() method from the IDodgeStrategy object.
	 */
	public void dodge();

	/**
	 * @return the direction vector of the entity.
	 */
	public IVector getDirection();

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
	void setType(TypeEnum type);

	/**
	 * contains all the actions to be executed for a full update of the entity.
	 */
	void update();

}
