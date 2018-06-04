package model.behaviorStrategy;

import modelInterfaces.IBounceStrategy;
import modelInterfaces.IEntity;
import modelInterfaces.ILevel;
import vector.IVector;

public class BounceTowardsPlayer implements IBounceStrategy {

	/**
	 * strategy which makes the unit bounce towards the player if possible
	 *
	 * @see modelInterfaces.IBounceStrategy#bounce()
	 */
	@Override
	public void bounce(final IEntity actor, final ILevel level) {
		IVector playerPosition = level.getPlayer().getPosition();

		IVector entityPosition = level.
	}

}
