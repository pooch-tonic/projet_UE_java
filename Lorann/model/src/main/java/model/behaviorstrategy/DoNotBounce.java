package model.behaviorstrategy;

import model.factories.VectorFactory;
import modelinterfaces.IBounceStrategy;
import modelinterfaces.IEntity;
import modelinterfaces.ILevel;

public class DoNotBounce implements IBounceStrategy {

	/**
	 * strategy which doesn't make the entity bounce
	 *
	 * @see modelinterfaces.IBounceStrategy#bounce()
	 */
	@Override
	public void bounce(final IEntity actor, final ILevel level) {
		actor.setDirection(VectorFactory.getMIDDLE());
	}
}
