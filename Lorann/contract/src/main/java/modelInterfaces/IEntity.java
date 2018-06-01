package modelInterfaces;

import enums.DirectionsEnum;
import vector.IVector;

public interface IEntity extends IUnit {
	public void destroy();

	public IVector getDirection();

	public void move(DirectionsEnum direction);

	void setDirection(IVector direction);
}
