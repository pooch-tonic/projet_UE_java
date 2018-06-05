/*
 *
 */
package view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.Observable;

import javax.swing.JOptionPane;

import controllerinterfaces.IController;
import controllerinterfaces.IOrderStacker;
import modelinterfaces.IModel;
import showboard.BoardFrame;
import showboard.IPawn;
import viewinterfaces.IView;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author aurel
 * @version 31 mai 2018
 */
public class ViewFacade implements IView, Runnable {
    /** The frame of the game. */
    private BoardFrame  boardFrame;
    /** The key listener using to detect keyboards inputs. */
    private KeyListener keyListener;

    /**
     * Instantiates a new ViewFacade without setting any attribute.
     */
    public ViewFacade() {
    }

    /**
     * Instantiates a new ViewFacade
     *
     * @param controller
     * @param orderStacker
     * @param observable
     * @param frameSize
     * @param model
     * @param gameWidth
     * @param gameHeight
     */
    public ViewFacade(final IController controller, final IOrderStacker orderStacker,
            final Observable observable, final Dimension frameSize, final IModel model,
            final int gameWidth, final int gameHeight) {
        super();

        try {
            this.setKeyListener(new KeyListener(new KeyEventPerformer(orderStacker)));
        } catch (final Exception e) {
            e.printStackTrace();
        }

        this.setBoardFrame(new BoardFrame("Lorann", false, frameSize));
        this.getBoardFrame().setDimension(new Dimension(gameWidth, gameHeight));
        this.getBoardFrame().setDisplayFrame(new Rectangle(0, 0, gameWidth, gameHeight));
        this.getBoardFrame().addKeyListener(this.getKeyListener());

        for (int x = 0; x < gameWidth; x++) {
            for (int y = 0; y < gameHeight; y++) {
                this.getBoardFrame().addSquare(model.getLevel().getUnits()[x][y], x, y);
            }
        }

        controller.setView(this);
        observable.addObserver(this.getBoardFrame().getObserver());
    }

    /*
     * (non-Javadoc)
     *
     * @see view.IView#displayMessage(java.lang.String)
     */
    @Override
    public final void displayMessage(final String message) throws Exception {
        if (message.isEmpty()) {
            throw new Exception("Message to display is empty");
        }
        JOptionPane.showMessageDialog(this.getBoardFrame(), message);
    }

    /**
     * Return the boardFrame
     *
     * @return boardFrame
     */
    @Override
    public BoardFrame getBoardFrame() {
        return this.boardFrame;
    }

    /**
     * Return the key listener
     *
     * @return the key listener
     */
    private KeyListener getKeyListener() {
        return this.keyListener;
    }

    @Override
    public void removeAllPawnsFromBoard() {
        this.getBoardFrame().removeAllPawn();
    }

    @Override
    public void removePawnFromBoard(final IPawn pawn) {
        this.getBoardFrame().removePawn(pawn);
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

    }

    /**
     * Set the boardFrame
     *
     * @param boardFrame
     */
    private void setBoardFrame(final BoardFrame boardFrame) {
        this.boardFrame = boardFrame;
    }

    /**
     * Set the key listener
     *
     * @param keyListener
     */
    private void setKeyListener(final KeyListener keyListener) {
        this.keyListener = keyListener;
    }

}
