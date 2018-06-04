package model.behaviorStrategy;

import modelInterfaces.IBounceStrategy;
import modelInterfaces.IEntity;
import modelInterfaces.ILevel;
import vector.IVector;

public class BounceOpposite implements IBounceStrategy {

	/**
	 * strategy which makes the unit bounce towards its opposite direction
	 * 
	 * @see modelInterfaces.IBounceStrategy#bounce()
	 */
	@Override
	public void bounce(final IEntity actor, final ILevel level) {
		IVector getOppositePosition;
	}

}
