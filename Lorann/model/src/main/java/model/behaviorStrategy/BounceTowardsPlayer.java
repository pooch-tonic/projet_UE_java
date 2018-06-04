/*
 *
 */
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
        final IVector actorPosition = actor.getPosition();
        final IVector playerPosition = level.getPlayer().getPosition();
        final IVector chasingDirection = playerPosition.getSubResult(actorPosition);
        chasingDirection.normalize();
        final IVector actorNextPosition = actorPosition.getAddResult(chasingDirection);

        if ((level.getUnits()[actorNextPosition.getX()][actorNextPosition.getY()]
                .getType() != Type.WALL) && (level.getEntityOn(actorNextPosition) == null)) {
            actor.setDirection(chasingDirection);
        } else {
            // TODO a enrichir
            actor.getDirection().invert();
        }

    }

}
