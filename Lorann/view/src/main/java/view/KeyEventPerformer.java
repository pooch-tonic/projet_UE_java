/*
 *
 */
package view;

import java.awt.event.KeyEvent;

import controllerInterfaces.IOrderStacker;
import enums.OrderEnum;

/**
 * <h1>The class KeyEventPerformer translate key events to order for the
 * controller</h1>
 *
 * @author Aur�lien Dellac
 * @version 1 juin 2018
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
     * @throws Exception
     */
    public KeyEventPerformer(final IOrderStacker orderStacker)
            throws Exception {
        if (orderStacker == null) {
            throw new Exception("The OrderStacker is null");
        }
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
        this.orderStacker
                .stackOrder(this.keyCodeToOrder(keyEvent.getKeyCode()));
    }

    /**
     * Returns the order corresponding to the key code of the new keyboard input
     *
     * @param keyCode
     * @return the order
     */
    private OrderEnum keyCodeToOrder(final int keyCode) {
        return OrderEnum.NONE;
    }

    /**
     * Checks if the new pressed key may be combine with the current one and
     * then returns the new (or not) order
     *
     * @param keyCode
     * @return the order
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
