package modelInterfaces;

import enums.DirectionsEnum;

public interface IEntity {
	public void destroy();

	public IVector getDirection();

	public void move(DirectionsEnum direction);

	void setDirection(IVector direction);
}
