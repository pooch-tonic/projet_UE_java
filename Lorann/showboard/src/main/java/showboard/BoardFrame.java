/*
 *
 */
package showboard;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * <h1>The Class BoardFrame.</h1>
 * <p>
 * This class is just used to load the BoardPanel. It extends JPanel and
 * implements IBoard.
 * </p>
 * <p>
 * As the BoardPanel is a private class, BoardPanel is a Facade.
 * </p>
 *
 * @author Anne-Emilie DIET
 * @version 3.0
 * @see JFrame
 * @see BoardPanel
 * @see Dimension
 * @see Rectangle
 * @see IBoard
 * @see ISquare
 * @see IPawn
 */
public class BoardFrame extends JFrame implements IBoard {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6563585351564617603L;

    /** The initial frame size. */
    private static final int defaultFrameSize = 700;

    /** The board panel. */
    private final BoardPanel boardPanel;

    /**
     * Instantiates a new board frame.
     */
    public BoardFrame() {
        this("", false, new Dimension(defaultFrameSize, defaultFrameSize));
    }

    /**
     * Instantiates a new board frame.
     *
     * @param decorated
     *            the decorated
     */
    public BoardFrame(final Boolean decorated) {
        this("", decorated, new Dimension(defaultFrameSize, defaultFrameSize));
    }

    /**
     * Instantiates a new board frame.
     *
     * @param title
     *            the title
     */
    public BoardFrame(final String title) {
        this(title, false, new Dimension(defaultFrameSize, defaultFrameSize));
    }

    /**
     * Instantiates a new BoardFrame
     *
     * @param title
     * @param decorated
     */
    public BoardFrame(final String title, final Boolean decorated, final Dimension frameSize) {
        super();
        this.setTitle(title);
        this.boardPanel = new BoardPanel();
        this.setContentPane(this.boardPanel);
        this.getContentPane().setPreferredSize(frameSize);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setUndecorated(decorated);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.exia.showboard.IBoard#addPawn(fr.exia.showboard.IPawn)
     */
    @Override
    public final void addPawn(final IPawn pawn) {
        this.getBoardPanel().addPawn(pawn);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.exia.showboard.IBoard#addSquare(fr.exia.showboard.ISquare, int, int)
     */
    @Override
    public final void addSquare(final ISquare square, final int x, final int y) {
        this.getBoardPanel().addSquare(square, x, y);
    }

    /**
     * Gets the board panel.
     *
     * @return the board panel
     */
    private BoardPanel getBoardPanel() {
        return this.boardPanel;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.exia.showboard.IBoard#getDimension()
     */
    @Override
    public final Dimension getDimension() {
        return this.getBoardPanel().getDimension();
    }

    /**
     * Gets the display frame.
     *
     * @return the display frame
     */
    public final Rectangle getDisplayFrame() {
        return this.getBoardPanel().getDisplayFrame();
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.exia.showboard.IBoard#getObserver()
     */
    @Override
    public final Observer getObserver() {
        return this.getBoardPanel();
    }

    /**
     * Checks if is height looped.
     *
     * @return the boolean
     */
    public final Boolean isHeightLooped() {
        return this.getBoardPanel().isHeightLooped();
    }

    /**
     * Checks if is width looped.
     *
     * @return the boolean
     */
    public final Boolean isWidthLooped() {
        return this.getBoardPanel().isWidthLooped();
    }

    @Override
    public void removeAllPawn() {
        this.getBoardPanel().removeAllPawn();
    }

    @Override
    public void removePawn(final IPawn pawn) {
        this.getBoardPanel().removePawn(pawn);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.exia.showboard.IBoard#setDimension(java.awt.Dimension)
     */
    @Override
    public final void setDimension(final Dimension dimension) {
        this.getBoardPanel().setDimension(dimension);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.exia.showboard.IBoard#setDisplayFrame(java.awt.Rectangle)
     */
    @Override
    public final void setDisplayFrame(final Rectangle displayFrame) {
        this.getBoardPanel().setDisplayFrame(displayFrame);
    }

    /**
     * Sets the height looped.
     *
     * @param heightLooped
     *            the new height looped
     */
    public final void setHeightLooped(final Boolean heightLooped) {
        this.getBoardPanel().setHeightLooped(heightLooped);
    }

    /**
     * Sets the width looped.
     *
     * @param widthLooped
     *            the new width looped
     */
    public final void setWidthLooped(final Boolean widthLooped) {
        this.getBoardPanel().setWidthLooped(widthLooped);
    }
}
