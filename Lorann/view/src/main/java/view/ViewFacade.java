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
import modelInterfaces.ILevel;
import showboard.BoardFrame;
import viewInterfaces.IView;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 * @author aurel
 * @version 31 mai 2018
 */
public class ViewFacade implements IView {
    /** The frame of the game. */
    private BoardFrame  boardFrame;
    /** The key listener using to detect keyboards inputs. */
    private KeyListener keyListener;
    
    private ILevel level;

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
    public ViewFacade(final IController controller,
            final IOrderStacker orderStacker, final Observable observable) {
        super();

        try {
            this.setKeyListener(
                    new KeyListener(new KeyEventPerformer(orderStacker)));
        } catch (final Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        this.setBoardFrame(new BoardFrame("Lorann", false));
        this.getBoardFrame().setSize(640, 416);
        this.getBoardFrame().setDimension(new Dimension(640, 416));
        this.getBoardFrame().setDisplayFrame(new Rectangle(0, 0, 640, 216));
        this.getBoardFrame().getContentPane()
                .addKeyListener(this.getKeyListener());

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
    
    public void updateView (ILevel level) {
    	
    }
    
    
    
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
    public BoardFrame getBoardFrame() {
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

	/**
	 * Gets the level
	 * 
	 * @return the level
	 */
	public ILevel getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(ILevel level) {
		this.level = level;
	}

}
