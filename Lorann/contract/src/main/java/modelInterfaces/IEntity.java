/*
 *
 */
package modelInterfaces;

import enums.Type;
import enums.TypeEnum;
import showboard.IPawn;
import vector.IVector;

public interface IEntity extends IPawn {
	public IVector getDirection();

	public Type getType();

	void setDirection(IVector direction);

	void setPosition(final IVector position);

	void setType(TypeEnum type);

	void update();
}
