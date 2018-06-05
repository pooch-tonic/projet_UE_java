/*
 *
 */
package view;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import controllerinterfaces.IOrderStacker;
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
    private IOrderStacker        orderStacker;
    /** The key code of the current key pressed. */
    private ArrayList<OrderEnum> currentOrders;

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
        this.setCurrentOrders(new ArrayList<>());
    }

    /*
     * (non-Javadoc)
     *
     * @see view.IKeyEventPerformer#performEvent(java.awt.event.KeyEvent)
     */
    @Override
    public void performKeyPressedEvent(final KeyEvent keyEvent) {
        final OrderEnum order = this.keyCodeToOrder(keyEvent.getKeyCode());

        if (order != OrderEnum.NONE) {
            if (this.getCurrentOrders().contains(OrderEnum.NONE)) {
                this.getCurrentOrders().remove(OrderEnum.NONE);
            }
            if (!this.getCurrentOrders().contains(order)) {
                this.getCurrentOrders().add(0, order);
            }
        }
        this.getOrderStacker().stackOrder(this.performOrderCombination());
    }

    /*
     * (non-Javadoc)
     *
     * @see view.IKeyEventPerformer#performKeyReleasedEvent(java.awt.event.KeyEvent)
     */
    @Override
    public void performKeyReleasedEvent(final KeyEvent keyEvent) {
        final OrderEnum order = this.keyCodeToOrder(keyEvent.getKeyCode());
        if (order != OrderEnum.NONE) {
            this.getCurrentOrders().remove(order);
        }
        if (this.getCurrentOrders().size() == 0) {
            this.getCurrentOrders().add(OrderEnum.NONE);
        }

        this.getOrderStacker().stackOrder(this.performOrderCombination());
    }

    /*
     * (non-Javadoc)
     *
     * @see view.IKeyEventPerformer#performKeyTypedEvent(java.awt.event.KeyEvent)
     */
    @Override
    public void performKeyTypedEvent(final KeyEvent keyEvent) {
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
            break;
        }

        return order;
    }

    /**
     * Gets the order which have to be send to the controller depending on key
     * pressed combinations
     *
     * @return
     */
    private OrderEnum performOrderCombination() {
        OrderEnum orderCombination = OrderEnum.NONE;
        final int numberOfOrders = this.getCurrentOrders().size();

        if (this.getCurrentOrders().contains(OrderEnum.CAST)) {
            orderCombination = OrderEnum.CAST;
        } else {
            if ((numberOfOrders > 1) && (numberOfOrders < 3)) {
                if (this.getCurrentOrders().contains(OrderEnum.UP)
                        && this.getCurrentOrders().contains(OrderEnum.RIGHT)) {
                    orderCombination = OrderEnum.UPRIGHT;
                } else if (this.getCurrentOrders().contains(OrderEnum.UP)
                        && this.getCurrentOrders().contains(OrderEnum.LEFT)) {
                    orderCombination = OrderEnum.UPLEFT;
                } else if (this.getCurrentOrders().contains(OrderEnum.DOWN)
                        && this.getCurrentOrders().contains(OrderEnum.RIGHT)) {
                    orderCombination = OrderEnum.DOWNRIGHT;
                } else if (this.getCurrentOrders().contains(OrderEnum.DOWN)
                        && this.getCurrentOrders().contains(OrderEnum.LEFT)) {
                    orderCombination = OrderEnum.DOWNLEFT;
                } else {

                    this.getCurrentOrders().get(0);
                }
            } else if (numberOfOrders == 1) {

                orderCombination = this.getCurrentOrders().get(0);
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
    private ArrayList<OrderEnum> getCurrentOrders() {
        return this.currentOrders;
    }

    /**
     * Sets the currentOrder
     *
     * @param currentOrder
     */
    private void setCurrentOrders(final ArrayList<OrderEnum> currentOrders) {
        this.currentOrders = currentOrders;
    }
}
