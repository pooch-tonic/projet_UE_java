/*
 *
 */
package viewInterfaces;

import showboard.BoardFrame;
import showboard.IPawn;

/**
 * <h1>The Interface IView.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IView {

    /**
     * Display message.
     *
     * @param message
     *            the message
     * @throws Exception
     */
    public void displayMessage(String message) throws Exception;

    /**
     * Gets the boardFrame
     *
     * @return the boardFrame
     */
    public BoardFrame getBoardFrame();

    /**
     * Tells to the board to remove this pawn
     *
     * @param pawn
     */
    public void removePawnFromBoard(IPawn pawn);

    /**
     * Tells to the board to remove all the pawns
     */
    public void removeAllPawnsFromBoard();
}
