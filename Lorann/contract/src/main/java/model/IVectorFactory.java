package model;

import java.util.Vector;

import enums.DirectionsEnum;

public interface IVectorFactory {
	public Vector getVectorForDirection(final DirectionsEnum direction);
}