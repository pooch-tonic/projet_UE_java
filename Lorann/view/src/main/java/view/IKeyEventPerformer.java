package view;

import java.awt.event.KeyEvent;

/**
 * <h1>The Interface IKeyEventPerformer allows an object to perform keyboard
 * events.</h1>
 *
 * @author aurel
 * @version 31 mai 2018
 */
interface IKeyEventPerformer {
    /**
     * Process the keyboard event by translate it to order to the controller
     *
     * @param keyEvent
     */
    void performEvent(KeyEvent keyEvent);
}
