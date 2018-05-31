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
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
/**
 * @author aurel
 *
 */
public class ViewFacade implements IView {
    /** The frame of the game. */
    private BoardFrame  boardFrame;
    /** The key listener using to detect keyboards inputs. */
    private KeyListener keyListener;

    /**
     * Instantiates a new ViewFacade
     *
     * @param controller
     * @param orderStacker
     * @param observable
     */
    public ViewFacade(final IController controller,
            final IOrderStacker orderStacker, final Observable observable) {
        super();

        this.setKeyListener(
                new KeyListener(new KeyEventPerformer(orderStacker)));

        this.setBoardFrame(new BoardFrame("Lorann", false));
        this.getBoardFrame().setSize(640, 416);
        this.getBoardFrame().setDimension(new Dimension(640, 416));
        this.getBoardFrame().setDisplayFrame(new Rectangle(0, 0, 640, 216));
        this.getBoardFrame().getContentPane()
                .addKeyListener(this.getKeyListener());

        controller.setBoard(this.getBoardFrame());
        observable.addObserver(this.getBoardFrame().getObserver());
    }

    /*
     * (non-Javadoc)
     *
     * @see view.IView#displayMessage(java.lang.String)
     */
    @Override
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    /**
     * Return the boardFrame
     *
     * @return
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

}
