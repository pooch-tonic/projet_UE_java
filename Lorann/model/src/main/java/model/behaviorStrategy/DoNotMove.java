/*
 * 
 */
package model.behaviorStrategy;

import modelInterfaces.IEntity;
import modelInterfaces.IMoveStrategy;

public class DoNotMove implements IMoveStrategy {

    /*
     * (non-Javadoc)
     *
     * @see modelInterfaces.IMoveStrategy#move()
     */
    @Override
    public void move(final IEntity actor) {

    }

}
