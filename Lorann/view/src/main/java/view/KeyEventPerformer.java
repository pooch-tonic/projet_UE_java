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
 * @author Aurélien Dellac
 * @version 1 juin 2018
 */
class KeyEventPerformer implements IKeyEventPerformer {
    /** The object able to stack order. */
    private IOrderStacker orderStacker;
    /** The key code of the current key pressed. */
    private OrderEnum     currentOrder;

    /**
     * Instantiates a new KeyEventPerformer
     *
     * @param orderStacker
     * @throws Exception
     */
    public KeyEventPerformer(final IOrderStacker orderStacker) throws Exception {
        if (orderStacker == null) {
            throw new Exception("The OrderStacker is null");
        }
        this.setOrderStacker(orderStacker);
        this.setCurrentOrder(OrderEnum.NONE);
    }

    /*
     * (non-Javadoc)
     *
     * @see view.IKeyEventPerformer#performEvent(java.awt.event.KeyEvent)
     */
    @Override
    public void performKeyPressedEvent(final KeyEvent keyEvent) {
        if (keyEvent.getID() == KeyEvent.KEY_PRESSED) {
            this.orderStacker.stackOrder(this.keyCodeToOrder(keyEvent.getKeyCode()));
        } else if (keyEvent.getID() == KeyEvent.KEY_RELEASED) {
            this.setCurrentOrder(OrderEnum.NONE);
            this.orderStacker.stackOrder(OrderEnum.NONE);
        }

    }

    /*
     * (non-Javadoc)
     *
     * @see view.IKeyEventPerformer#performKeyReleasedEvent(java.awt.event.KeyEvent)
     */
    @Override
    public void performKeyReleasedEvent(final KeyEvent keyEvent) {
        this.setCurrentOrder(OrderEnum.NONE);
        this.orderStacker.stackOrder(OrderEnum.NONE);
    }

    /*
     * (non-Javadoc)
     *
     * @see view.IKeyEventPerformer#performKeyTypedEvent(java.awt.event.KeyEvent)
     */
    @Override
    public void performKeyTypedEvent(final KeyEvent keyEvent) {
        // TODO Auto-generated method stub

    }

    /**
     * Returns the order corresponding to the key code of the new keyboard input
     *
     * @param keyCode
     * @return the order
     */
    private OrderEnum keyCodeToOrder(final int keyCode) {
        OrderEnum order = OrderEnum.NONE;

        switch (keyCode) {
        case KeyEvent.VK_UP:
            order = OrderEnum.UP;
            ;
            break;
        case KeyEvent.VK_DOWN:
            order = OrderEnum.DOWN;
            ;
            break;
        case KeyEvent.VK_LEFT:
            order = OrderEnum.LEFT;
            ;
            break;
        case KeyEvent.VK_RIGHT:
            order = OrderEnum.RIGHT;
            ;
            break;
        case KeyEvent.VK_SPACE:
            order = OrderEnum.CAST;
            ;
            break;
        default:
            order = this.currentOrder;
            break;
        }

        if (this.currentOrder == OrderEnum.NONE) {
            this.setCurrentOrder(order);
        } else {
            order = this.performOrderCombination(order);
        }
        System.out.println(order + " : " + this.currentOrder);
        return order;
    }

    /**
     * Checks if the new pressed key may be combine with the current one and then
     * returns the new (or not) order
     *
     * @param order
     * @return
     */
    private OrderEnum performOrderCombination(final OrderEnum order) {
        OrderEnum orderCombination = order;

        if (order != this.currentOrder) {
            if (((order == OrderEnum.UP) && (this.currentOrder == OrderEnum.RIGHT))
                    || ((this.currentOrder == OrderEnum.UP) && (order == OrderEnum.RIGHT))) {
                orderCombination = OrderEnum.UPRIGHT;
            } else if (((order == OrderEnum.UP) && (this.currentOrder == OrderEnum.LEFT))
                    || ((this.currentOrder == OrderEnum.UP) && (order == OrderEnum.LEFT))) {
                orderCombination = OrderEnum.UPLEFT;
            } else if (((order == OrderEnum.DOWN) && (this.currentOrder == OrderEnum.RIGHT))
                    || ((this.currentOrder == OrderEnum.DOWN) && (order == OrderEnum.RIGHT))) {
                orderCombination = OrderEnum.DOWNRIGHT;
            } else if (((order == OrderEnum.DOWN) && (this.currentOrder == OrderEnum.LEFT))
                    || ((this.currentOrder == OrderEnum.DOWN) && (order == OrderEnum.LEFT))) {
                orderCombination = OrderEnum.DOWNLEFT;
            }
        }

        return orderCombination;
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
     * Gets the currentOrder
     *
     * @return the currentOrder
     */
    private OrderEnum getCurrentOrder() {
        return this.currentOrder;
    }

    /**
     * Sets the currentOrder
     *
     * @param currentOrder
     */
    private void setCurrentOrder(final OrderEnum currentOrder) {
        this.currentOrder = currentOrder;
    }
}
