/*
 *
 */
package controllerinterfaces;

import viewinterfaces.IView;

/**
 * <h1>The IController interface.</h1> Allows the other components to use some
 * controller features.
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IController {

	/**
	 * Asks the controller to update the model.
	 */
	void update();

	/**
	 * Loads the level according to the specified id.
	 *
	 * @param id
	 *            the id of the level
	 */
	public void loadLevel(final int id);

	/**
	 * Loads the level that comes after the specified current level id.
	 */
	public void nextLevel();

	/**
	 * Resets the current level.
	 */
	public void resetLevel();

	/**
	 * Sets the view.
	 *
	 * @param viewFacade
	 *            the IView that overrides the current viewFacade
	 */
	void setView(IView viewFacade);
}
