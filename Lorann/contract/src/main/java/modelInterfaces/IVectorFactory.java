package modelInterfaces;

import enums.DirectionsEnum;

public interface IVectorFactory {
	public IVector getVectorForDirection(final DirectionsEnum direction);
}
