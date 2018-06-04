package model.behaviorStrategy;

import enums.Type;
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
		IVector actorPosition = actor.getPosition();
		IVector actorDirection = actor.getDirection();
		IVector playerPosition = level.getPlayer().getPosition();
		IVector chasingDirection = playerPosition.getSubResult(actorPosition);
		chasingDirection.normalize();
		IVector actorNextPosition = actorPosition.getAddResult(chasingDirection);

		if (level.getUnits()[actorNextPosition.getX()][actorNextPosition.getY()].getType() != Type.WALL) {
			actor.setDirection(chasingDirection);
		} else {

		}


		level.getUnits()[][y]
	}

}
