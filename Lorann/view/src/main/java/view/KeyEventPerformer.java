package view;

import java.awt.event.KeyEvent;

import controllerInterfaces.IOrderStacker;
import enums.OrderEnum;

/**
 * <h1>The class KeyEventPerformer is an object able to translate keyboard
 * events to concrete action applicable to the model.</h1>
 *
 * @author aurel
 * @version 31 mai 2018
 */
class KeyEventPerformer implements IKeyEventPerformer {
    /** The object able to stack order. */
    private IOrderStacker orderStacker;
    /** The key code of the current key pressed. */
    private int           currentKeyPressed;

    /**
     * Instantiates a new KeyEventPerformer
     *
     * @param orderStacker
     */
    public KeyEventPerformer(final IOrderStacker orderStacker) {
        this.setOrderStacker(orderStacker);
    }

    /*
     * (non-Javadoc)
     *
     * @see view.IKeyEventPerformer#performEvent(java.awt.event.KeyEvent)
     */
    @Override
    public void performEvent(final KeyEvent keyEvent) {
        // TODO Auto-generated method stub

    }

    /**
     * Gets a key code and translate it to an order for the player
     *
     * @param keyCode
     * @return Order
     */
    private OrderEnum keyCodeToOrder(final int keyCode) {
        return OrderEnum.NONE;
    }

    /**
     * Gets the orderStacker
     *
     * @return the orderStacker
     */
    private IOrderStacker getOrderStacker() {
        return this.orderStacker;
    }

    /**
     * Sets the orderStacker
     *
     * @param orderStacker
     */
    private void setOrderStacker(final IOrderStacker orderStacker) {
        this.orderStacker = orderStacker;
    }

    /**
     * Gets the currentKeyPressed
     *
     * @return the currentKeyPressed
     */
    private int getCurrentKeyPressed() {
        return this.currentKeyPressed;
    }

    /**
     * Sets the currentKeyPressed
     *
     * @param currentKeyPressed
     */
    private void setCurrentKeyPressed(final int currentKeyPressed) {
        this.currentKeyPressed = currentKeyPressed;
    }

}
