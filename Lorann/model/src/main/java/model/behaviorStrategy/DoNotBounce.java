package model.behaviorStrategy;

import model.factories.VectorFactory;
import modelInterfaces.IBounceStrategy;
import modelInterfaces.IEntity;
import modelInterfaces.ILevel;

public class DoNotBounce implements IBounceStrategy {

	/**
	 * strategy which doesn't make the entity bounce
	 *
	 * @see modelInterfaces.IBounceStrategy#bounce()
	 */
	@Override
	public void bounce(final IEntity actor, final ILevel level) {
		actor.setDirection(VectorFactory.getMIDDLE());
	}
}
