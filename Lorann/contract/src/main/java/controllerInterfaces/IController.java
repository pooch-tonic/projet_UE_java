/*
 *
 */
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
     * sets the controller's contained game board
     *
     * @param board
     */
    void setBoard(IBoard board);

    /**
     * asks the controller to update the model
     *
     * @return
     */
    void update();

    /**
     * Loads the level according to the specified id
     *
     * @param id
     */
    public void loadLevel(final int id);

    /**
     * Loads the level that comes after the specified current level id
     */
    public void nextLevel();

    /**
     * Reset the current level
     */
    public void resetLevel();
}
