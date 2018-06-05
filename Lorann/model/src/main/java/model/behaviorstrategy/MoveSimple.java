package model.behaviorstrategy;

import modelinterfaces.IEntity;
import modelinterfaces.IMoveStrategy;

public class MoveSimple implements IMoveStrategy {

	/*
	 * (non-Javadoc)
	 *
	 * @see modelInterfaces.IMoveStrategy#move()
	 */
	@Override
	public void move(final IEntity actor) {
		actor.getPosition().add(actor.getDirection());
	}

}
