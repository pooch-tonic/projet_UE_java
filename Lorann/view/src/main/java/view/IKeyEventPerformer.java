package view;

import java.awt.event.KeyEvent;

/**
 * @author aurel
 *
 */
interface IKeyEventPerformer {
    /**
     * Process the keyboard event by translate it to order to the controller
     * 
     * @param keyEvent
     */
    void performEvent(KeyEvent keyEvent);
}
