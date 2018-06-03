package modelInterfaces;

import enums.DirectionEnum;
import showboard.IPawn;
import vector.IVector;

public interface IEntity extends IPawn {
	public void destroy();

	public IVector getDirection();

	public void move(DirectionEnum direction);

	void setDirection(IVector direction);

	void update();
	
	void setPosition(final IVector position);
}
