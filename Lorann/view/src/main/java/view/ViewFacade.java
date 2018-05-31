package view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.Observable;

import javax.swing.JOptionPane;

import controller.IOrderStacker;
import model.IModel;
import showboard.BoardFrame;

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
    private BoardFrame  boardFrame;
    private KeyListener keyListener;

    /**
     * Instantiates a new view facade.
     * 
     * @param model
     * @param observable
     * @param orderStacker
     */
    public ViewFacade(final IModel model, final Observable observable,
            final IOrderStacker orderStacker) {
        super();

        this.setKeyListener(
                new KeyListener(new KeyEventPerformer(orderStacker)));

        this.setBoardFrame(new BoardFrame("Lorann", false));
        this.getBoardFrame().setSize(640, 416);
        this.getBoardFrame().setDimension(new Dimension(640, 416));
        this.getBoardFrame().setDisplayFrame(new Rectangle(0, 0, 640, 216));
        this.getBoardFrame().getContentPane()
                .addKeyListener(this.getKeyListener());

        model.setBoard(this.getBoardFrame());
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

    private KeyListener getKeyListener() {
        return this.keyListener;
    }

    private void setKeyListener(final KeyListener keyListener) {
        this.keyListener = keyListener;
    }

}
