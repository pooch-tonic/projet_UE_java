package model.behaviorstrategy;

import modelinterfaces.IBounceStrategy;
import modelinterfaces.IEntity;
import modelinterfaces.ILevel;

public class BounceOpposite implements IBounceStrategy {

	/**
	 * strategy which makes the unit bounce towards its opposite direction
	 *
	 * @see modelinterfaces.IBounceStrategy#bounce()
	 */
	@Override
	public void bounce(final IEntity actor, final ILevel level) {
		actor.getDirection().invert();
	}
}
