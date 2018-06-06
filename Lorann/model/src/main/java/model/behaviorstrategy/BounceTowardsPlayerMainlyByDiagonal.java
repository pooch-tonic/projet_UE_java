/*
 *
 */
package model.behaviorstrategy;

import enums.DirectionEnum;
import enums.UnitTypeEnum;
import model.factories.VectorFactory;
import modelinterfaces.IBounceStrategy;
import modelinterfaces.IEntity;
import modelinterfaces.ILevel;
import vector.IVector;

public class BounceTowardsPlayerMainlyByDiagonal implements IBounceStrategy {

    /**
     * strategy which makes the unit bounce towards the player if possible
     *
     * @see modelinterfaces.IBounceStrategy#bounce()
     */
    @Override
    public void bounce(final IEntity actor, final ILevel level) {
        final IVector actorPosition = actor.getPosition();
        final IVector playerPosition = level.getPlayer().getPosition();
        IVector chasingDirection = VectorFactory.getMIDDLE();
        IVector directionStudied;
        IVector positionStudied;
        IEntity target;
        int currentDistance = 100;
        int currentDistanceToActor = 3;

        for (final DirectionEnum directionEnum : DirectionEnum.values()) {
            directionStudied = VectorFactory.getVectorForDirection(directionEnum);
            positionStudied = directionStudied.getAddResult(actorPosition);
            target = level.getEntityOn(positionStudied);

            if ((level.getUnitOn(positionStudied.getX(), positionStudied.getY())
                    .getType() != UnitTypeEnum.WALL)
                    && ((target == level.getPlayer()) || (target == null))) {
                final int abs = positionStudied.getX() - playerPosition.getX();
                final int ord = positionStudied.getY() - playerPosition.getY();
                final int distance = new Double(Math.sqrt((abs * abs) + (ord * ord))).intValue();
                final int distanceToActor = Math.abs(directionStudied.getX())
                        + Math.abs(directionStudied.getY());
                if ((distance < currentDistance)) {
                    currentDistance = distance;
                    currentDistanceToActor = distanceToActor;
                    chasingDirection = directionStudied;
                } else if ((distance == currentDistance)
                        && (distanceToActor > currentDistanceToActor)) {
                    currentDistance = distance;
                    currentDistanceToActor = distanceToActor;
                    chasingDirection = directionStudied;
                }
            }

        }
        if ((chasingDirection.getX() == 0) && (chasingDirection.getY() == 0)) {
            actor.setMoveStrategy(new MoveBlocked());
        } else {
            actor.setDirection(chasingDirection);
        }

    }

}
