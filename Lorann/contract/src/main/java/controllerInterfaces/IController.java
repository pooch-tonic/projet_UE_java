package controllerInterfaces;

import showboard.IBoard;

/**
 * <h1>The Interface IController.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IController {

	/**
	 * loads the level according to the specified id
	 * 
	 * @param id
	 */
	void loadLevel(int id);

	/**
	 * loads the level that comes after the specified current level id
	 */
	void nextlevel(int currentLevelId);

	/**
	 * sets the controller's contained game board
	 *
	 * @param board
	 */
	void setBoard(IBoard board);

	/**
	 * asks the controller to update the model
	 */
	void update();
}
