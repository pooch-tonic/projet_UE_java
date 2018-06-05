/*
 *
 */
package model.behaviorstrategy;

import java.util.ArrayList;

import enums.DirectionEnum;
import enums.UnitTypeEnum;
import model.factories.VectorFactory;
import modelinterfaces.IBounceStrategy;
import modelinterfaces.IEntity;
import modelinterfaces.ILevel;
import vector.IVector;

public class BounceTowardsPlayer implements IBounceStrategy {

    /**
     * strategy which makes the unit bounce towards the player if possible
     *
     * @see modelinterfaces.IBounceStrategy#bounce()
     */
    @Override
    public void bounce(final IEntity actor, final ILevel level) {
        final IVector actorPosition = actor.getPosition();
        final IVector playerPosition = level.getPlayer().getPosition();

        final ArrayList<IVector> openSet = new ArrayList<>();
        final ArrayList<IVector> closeSet = new ArrayList<>();
        closeSet.add(actor.getDirection());

        IVector chasingDirectionBis = VectorFactory.getMIDDLE();
        int currentDist = 100;
        IVector direction = null;
        IVector position;
        IEntity target;

        for (final DirectionEnum directionEnum : DirectionEnum.values()) {
            direction = VectorFactory.getVectorForDirection(directionEnum);
            position = direction.getAddResult(actorPosition);
            target = level.getEntityOn(position);

            if ((level.getUnitOn(position.getX(), position.getY()).getType() != UnitTypeEnum.WALL)
                    && ((target == level.getPlayer()) || (target == null))) {
                final int abs = position.getX() - playerPosition.getX();
                final int ord = position.getY() - playerPosition.getY();
                final int distance = new Double(Math.sqrt((abs * abs) + (ord * ord))).intValue();
                if (distance < currentDist) {
                    currentDist = distance;
                    chasingDirectionBis = direction;
                }
            }

        }

        if ((chasingDirectionBis.getX() == 0) && (chasingDirectionBis.getY() == 0)) {
            actor.setMoveStrategy(new MoveBlocked());
        } else {
            actor.setDirection(chasingDirectionBis);
        }

    }

}
