/*
 *
 */
package controllerinterfaces;

import enums.OrderEnum;

/**
 * <h1>The IOrderStacker interface.</h1>Allows an object to stack orders.
 *
 * @author Aurélien Dellac
 * @version 2 juin 2018
 */
public interface IOrderStacker {
	/**
	 * Stacks an order to keep it for later use.
	 *
	 * @param order
	 *            the order enumeration to stack
	 */
	void stackOrder(OrderEnum order);
}
