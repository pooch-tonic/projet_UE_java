package model.behaviorStrategy;

import modelInterfaces.IDodgeStrategy;
import modelInterfaces.IEntity;
import modelInterfaces.ILevel;

public class DoNotDodge implements IDodgeStrategy {

	/*
	 * (non-Javadoc)
	 *
	 * @see modelInterfaces.IDodgeStrategy#dodge()
	 */
	@Override
	public void dodge(final IEntity actor, final ILevel level) {

	}

}
