/*
 *
 */
package model.behaviorStrategy;

import modelInterfaces.IEntity;
import modelInterfaces.IMoveStrategy;

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
