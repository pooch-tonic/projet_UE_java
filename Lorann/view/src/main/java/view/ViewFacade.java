/*
 *
 */
package view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.Observable;

import javax.swing.JOptionPane;

import controllerInterfaces.IController;
import controllerInterfaces.IOrderStacker;
import showboard.BoardFrame;
import viewInterfaces.IView;

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
     * Instantiates a new ViewFacade
     *
     * @param controller
     *            the game controller
     * @param orderStacker
     *            the object able to stack order
     * @param observable
     *            the observable object
     */
    public ViewFacade(final IController controller, final IOrderStacker orderStacker,
            final Observable observable, final Dimension frameSize) {
        super();

        try {
            this.setKeyListener(new KeyListener(new KeyEventPerformer(orderStacker)));
        } catch (final Exception e) {
            e.printStackTrace();
        }
        // TODO get the width and height of the frame from model or game settings
        this.setBoardFrame(new BoardFrame("Lorann", false));
        this.getBoardFrame().setSize(frameSize.width, frameSize.height);
        this.getBoardFrame()
                .setDimension(new Dimension(frameSize.width / 32, frameSize.height / 32));
        this.getBoardFrame()
                .setDisplayFrame(new Rectangle(0, 0, frameSize.width / 32, frameSize.height / 32));
        this.getBoardFrame().addKeyListener(this.getKeyListener());

        controller.setBoard(this.getBoardFrame());
        observable.addObserver(this.getBoardFrame().getObserver());
    }

    /**
     * Instantiates a new ViewFacade without setting any attribute.
     */
    public ViewFacade() {
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
        JOptionPane.showMessageDialog(null, message);
    }

    /**
     * Return the boardFrame
     *
     * @return boardFrame
     */
    private BoardFrame getBoardFrame() {
        return this.boardFrame;
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
     * Return the key listener
     *
     * @return the key listener
     */
    private KeyListener getKeyListener() {
        return this.keyListener;
    }

    /**
     * Set the key listener
     *
     * @param keyListener
     */
    private void setKeyListener(final KeyListener keyListener) {
        this.keyListener = keyListener;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

    }

}
