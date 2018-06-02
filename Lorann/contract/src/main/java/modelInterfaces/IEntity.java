package modelInterfaces;

import enums.DirectionsEnum;
import showboard.IPawn;
import vector.IVector;

public interface IEntity extends IPawn {
	public void destroy();

	public IVector getDirection();

	public void move(DirectionsEnum direction);

	void setDirection(IVector direction);

	void update();
}
