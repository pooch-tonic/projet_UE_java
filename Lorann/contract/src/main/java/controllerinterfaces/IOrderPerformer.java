/*
 *
 */
package controllerinterfaces;

/**
 * <h1>The IOrderPerformer interface.</h1> Allows an object to perform orders.
 *
 * @author Aurélien Dellac
 * @version 2 juin 2018
 */
public interface IOrderPerformer {
	/**
	 * Indicates to the model what to do depending on the stacked order.
	 */
	public void performOrder();
}
