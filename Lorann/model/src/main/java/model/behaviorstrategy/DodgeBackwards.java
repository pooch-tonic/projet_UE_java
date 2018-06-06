/*
 *
 */
package model.behaviorstrategy;

import modelinterfaces.IDodgeStrategy;
import modelinterfaces.IEntity;
import modelinterfaces.ILevel;

public class DodgeBackwards implements IDodgeStrategy {

    /*
     * (non-Javadoc)
     *
     * @see modelInterfaces.IDodgeStrategy#dodge()
     */
    @Override
    public void dodge(final IEntity actor, final ILevel level) {
        actor.getDirection().invert();
    }

}
