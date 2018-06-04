package model.behaviorStrategy;

import model.Unit;
import modelInterfaces.IBounceStrategy;
import modelInterfaces.IEntity;
import modelInterfaces.ILevel;
import vector.IVector;
import vector.Vector;

public class BounceOpposite implements IBounceStrategy {

	/**
	 * strategy which makes the unit bounce towards its opposite direction
	 * 
	 * @see modelInterfaces.IBounceStrategy#bounce()
	 */
	@Override
	public void bounce(final IEntity actor, final ILevel level) {
		actor.getDirection().invert();
	}
}
