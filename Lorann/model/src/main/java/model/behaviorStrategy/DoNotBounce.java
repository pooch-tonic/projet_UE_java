package model.behaviorStrategy;

import modelInterfaces.IBounceStrategy;

public class DoNotBounce implements IBounceStrategy {

	/**
	 * strategy which doesn't make the entity bounce
	 * 
	 * @see modelInterfaces.IBounceStrategy#bounce()
	 */
	@Override
	public void bounce() {
		// nothing on purpose
	}

}
