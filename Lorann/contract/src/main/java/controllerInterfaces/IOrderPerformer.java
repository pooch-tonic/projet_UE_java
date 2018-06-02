/*
 *
 */
package controllerInterfaces;

/**
 * <h1>The Interface IOrderPerformer allows an object to perform orders</h1>
 *
 * @author Aurélien Dellac
 * @version 2 juin 2018
 */
public interface IOrderPerformer {
    /**
     * Indicates to the model what to do depending on the order stacked
     */
    public void performOrder();
}
