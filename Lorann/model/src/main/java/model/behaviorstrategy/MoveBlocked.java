/*
 *
 */
package model.behaviorstrategy;

import modelinterfaces.IEntity;
import modelinterfaces.IMoveStrategy;

public class MoveBlocked implements IMoveStrategy {

    /*
     * (non-Javadoc)
     *
     * @see modelInterfaces.IMoveStrategy#move()
     */
    @Override
    public void move(final IEntity actor) {
        actor.setMoveStrategy(new MoveSimple());
    }

}
