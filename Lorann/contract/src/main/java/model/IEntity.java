package model;

import java.util.Vector;

import enums.DirectionsEnum;

public interface IEntity {
	public Vector getDirection();
	void setDirection(Vector direction);
	public void destroy();
	public void move (DirectionsEnum direction);
}
