/*
 *
 */
package viewinterfaces;

import showboard.BoardFrame;
import showboard.IPawn;

/**
 * <h1>The Interface IView.</h1>
 * 
 * @author Aurélien Dellac
 * @version 5 juin 2018
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
