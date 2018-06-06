/*
 *
 */
package model.behaviorstrategy;

import enums.UnitTypeEnum;
import modelinterfaces.IBounceStrategy;
import modelinterfaces.IEntity;
import modelinterfaces.ILevel;
import vector.IVector;

public class BounceTowardsPlayerLikeSpell implements IBounceStrategy {

	/**
	 * strategy which makes the unit bounce towards the player if possible
	 *
	 * @see modelinterfaces.IBounceStrategy#bounce()
	 */
	@Override
	public void bounce(final IEntity actor, final ILevel level) {
		final IVector actorPosition = actor.getPosition();
		final IVector playerPosition = level.getPlayer().getPosition();
		final IVector chasingDirection = playerPosition.getSubResult(actorPosition);
		chasingDirection.normalize();
		final IVector actorNextPosition = actorPosition.getAddResult(chasingDirection);
		final IEntity target = level.getEntityOn(actorNextPosition);

		if ((level.getUnits()[actorNextPosition.getX()][actorNextPosition.getY()].getType() != UnitTypeEnum.WALL)
				&& ((target == level.getPlayer()) || (target == null))) {
			actor.setDirection(chasingDirection);
		} else {
			actor.setMoveStrategy(new MoveBlocked());
			;
		}

	}

}
