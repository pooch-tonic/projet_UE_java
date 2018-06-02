/*
 * 
 */
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
     * Process the key pressed event by translate it to order to the controller
     *
     * @param keyEvent
     */
    void performKeyPressedEvent(KeyEvent keyEvent);

    /**
     * Process the key released event by translate it to order to the controller
     * 
     * @param keyEvent
     */
    void performKeyReleasedEvent(KeyEvent keyEvent);

    /**
     * Process the key typed event by translate it to order to the controller
     * 
     * @param keyEvent
     */
    void performKeyTypedEvent(KeyEvent keyEvent);
}
