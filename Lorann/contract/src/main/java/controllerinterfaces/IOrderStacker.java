/*
 *
 */
package controllerinterfaces;

import enums.OrderEnum;

/**
 * <h1>The Interface IOrderStacker allows an object to stack orders.</h1>
 *
 * @author Aurélien Dellac
 * @version 2 juin 2018
 */
public interface IOrderStacker {
    /**
     * Stacks an order
     * 
     * @param order
     */
    void stackOrder(OrderEnum order);
}
