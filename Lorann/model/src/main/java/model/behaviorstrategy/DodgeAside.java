/*
 * 
 */
package model.behaviorstrategy;

import modelinterfaces.IDodgeStrategy;
import modelinterfaces.IEntity;
import modelinterfaces.ILevel;

public class DodgeAside implements IDodgeStrategy {

    /*
     * (non-Javadoc)
     *
     * @see modelInterfaces.IDodgeStrategy#dodge()
     */
    @Override
    public void dodge(final IEntity actor, final ILevel level) {
        actor.bounce(level);
    }

}
