/*
 *
 */
package showboard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

/**
 * <h1>The Class BoardPanel.</h1>
 * <p>
 * This class represents the board as an image. It extends JPanel.
 * </p>
 * <p>
 * It uses an ISquare[][] as board, a List&lt;IPawn&gt; as list of pawns.
 * </p>
 * <p>
 * If an ISquare has not an image, the noImage is used.
 * </p>
 * <p>
 * The same noImage is used to illustrate the board's edge.
 * </p>
 * <p>
 * The class implements Observer interface to observe the Observable who stores
 * the board's data. At each update, the image is build.
 * </p>
 * <p>
 * The all image isn't display, just the zone represented by the display
 * Rectangle is show in the panel. If this Rectangle is higher than the board
 * dimension, the noImage is also used.
 * </p>
 *
 * @author Anne-Emilie DIET
 * @version 3.0
 * @see JPanel
 * @see Dimension
 * @see Rectangle
 * @see Image
 * @see ISquare
 * @see IPawn
 * @see Observer
 * @see Observable
 */
class BoardPanel extends JPanel implements Observer {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3618605287900763008L;

	/** The squares represents the square of the board. */
	private ISquare[][] squares;

	/** The pawns represents a list of all the pawns on the board. */
	private List<IPawn> pawns;

	/**
	 * The dimension is used to known the width and the height of the board. It's
	 * used principally with the squares property
	 */
	private Dimension dimension;

	/** The center of the board. */
	private Rectangle displayFrame;

	/** The no image is used to factorize the NoImage loading. */
	private final BufferedImage noImage;

	/** The width looped. */
	private Boolean widthLooped = false;

	/** The height looped. */
	private Boolean heightLooped = false;

	/**
	 * Instantiates a new board panel.
	 */
	BoardPanel() {
		super();
		this.pawns = new ArrayList<>();
		this.noImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
		final Graphics2D graphics = this.noImage.createGraphics();
		graphics.setColor(Color.white);
		graphics.fillRect(0, 0, 2, 2);
	}

	/**
	 * Adds the pawn.
	 *
	 * @param pawn
	 *            the pawn
	 */
	public final void addPawn(final IPawn pawn) {
		this.getPawns().add(pawn);
	}

	/**
	 * Adds the square.
	 *
	 * @param square
	 *            the square
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	public final void addSquare(final ISquare square, final int x, final int y) {
		this.squares[x][y] = square;
	}

	/**
	 * Calculate real X.
	 *
	 * @param x
	 *            the x
	 * @return the int
	 */
	private int calculateRealX(final int x) {
		if (!this.isWidthLooped()) {
			return x;
		}
		return (x + this.getDimension().width) % this.getDimension().width;
	}

	/**
	 * Calculate real Y.
	 *
	 * @param y
	 *            the y
	 * @return the int
	 */
	private int calculateRealY(final int y) {
		if (!this.isHeightLooped()) {
			return y;
		}
		return (y + this.getDimension().height) % this.getDimension().height;
	}

	/**
	 * Creates the map pawn.
	 *
	 * @return the map
	 */
	private Map<String, ArrayList<IPawn>> createMapPawn() {
		final Map<String, ArrayList<IPawn>> mapPawn = new HashMap<>();
		String key;

		for (final IPawn pawn : this.getPawns()) {
			key = this.createMapPawnKey(pawn.getX(), pawn.getY());
			ArrayList<IPawn> listPawn = mapPawn.get(key);
			if (listPawn == null) {
				listPawn = new ArrayList<>();
				mapPawn.put(key, listPawn);
			}
			listPawn.add(pawn);
		}
		return mapPawn;
	}

	/**
	 * Creates the map pawn key.
	 *
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @return the string
	 */
	private String createMapPawnKey(final int x, final int y) {
		return x + ":" + y;
	}

	/**
	 * Draw pawns XY.
	 *
	 * @param graphics
	 *            the graphics
	 * @param mapPawn
	 *            the map pawn
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	private void drawPawnsXY(final Graphics graphics, final Map<String, ArrayList<IPawn>> mapPawn, final int x,
			final int y) {
		final List<IPawn> listPawn = mapPawn.get(this.createMapPawnKey(this.calculateRealX(x), this.calculateRealY(y)));
		if (listPawn != null) {
			for (final IPawn pawn : listPawn) {
				graphics.drawImage(pawn.getImage(), this.getSquareSizeWidth() * (x - this.getCornerMinX()),
						this.getSquareSizeHeight() * (y - this.getCornerMinY()), this.getSquareSizeWidth(),
						this.getSquareSizeHeight(), this);
			}
		}
	}

	/**
	 * Draw square XY.
	 *
	 * @param graphics
	 *            the graphics
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	private void drawSquareXY(final Graphics graphics, final int x, final int y) {
		Image image;
		image = this.getImageXY(x, y, this.getWidthLimit(), this.getHeightLimit());
		graphics.drawImage(image, this.getSquareSizeWidth() * (x - this.getCornerMinX()),
				this.getSquareSizeHeight() * (y - this.getCornerMinY()), this.getSquareSizeWidth(),
				this.getSquareSizeHeight(), this);

	}

	/**
	 * Gets the corner max X.
	 *
	 * @return the corner max X
	 */
	private int getCornerMaxX() {
		return this.getDisplayFrame().x + this.getDisplayFrame().width;
	}

	/**
	 * Gets the corner max Y.
	 *
	 * @return the corner max Y
	 */
	private int getCornerMaxY() {
		return this.getDisplayFrame().y + this.getDisplayFrame().height;
	}

	/**
	 * Gets the corner min X.
	 *
	 * @return the corner min X
	 */
	private int getCornerMinX() {
		return this.getDisplayFrame().x;
	}

	/**
	 * Gets the corner min Y.
	 *
	 * @return the corner min Y
	 */
	private int getCornerMinY() {
		return this.getDisplayFrame().y;
	}

	/**
	 * Gets the dimension.
	 *
	 * @return the dimension
	 * @see Dimension
	 */
	public final Dimension getDimension() {
		return this.dimension;
	}

	/**
	 * Gets the display frame.
	 *
	 * @return the displayFrame
	 */
	public final Rectangle getDisplayFrame() {
		return this.displayFrame;
	}

	/**
	 * Gets the height limit.
	 *
	 * @return the height limit
	 */
	private int getHeightLimit() {
		return Math.min(this.getDisplayFrame().height + this.getDisplayFrame().y, this.getDimension().height);
	}

	/**
	 * Gets the image XY.
	 *
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @param widthLimit
	 *            the width limit
	 * @param heightLimit
	 *            the height limit
	 * @return the image XY
	 */
	private Image getImageXY(final int x, final int y, final int widthLimit, final int heightLimit) {
		Image image;
		final int realX = this.calculateRealX(x);
		final int realY = this.calculateRealY(y);
		if ((realX < 0) || (realY < 0) || (realX >= widthLimit) || (realY >= heightLimit)) {
			image = this.noImage;
		} else {
			image = this.squares[realX][realY].getImage();
			if (image == null) {
				image = this.noImage;
			}
		}
		return image;
	}

	/**
	 * Gets the pawns.
	 *
	 * @return the pawns
	 */
	private List<IPawn> getPawns() {
		return this.pawns;
	}

	/**
	 * Gets the square size height.
	 *
	 * @return the square size height
	 */
	private int getSquareSizeHeight() {
		return this.getHeight() / this.getDisplayFrame().height;
	}

	/**
	 * Gets the square size width.
	 *
	 * @return the square size width
	 */
	private int getSquareSizeWidth() {
		return this.getWidth() / this.getDisplayFrame().width;
	}

	/**
	 * Gets the width limit.
	 *
	 * @return the width limit
	 */
	private int getWidthLimit() {
		return Math.min(this.getDisplayFrame().width + this.getDisplayFrame().x, this.getDimension().width);
	}

	/**
	 * Checks if is height looped.
	 *
	 * @return the boolean
	 */
	public Boolean isHeightLooped() {
		return this.heightLooped;
	}

	/**
	 * Checks if is width looped.
	 *
	 * @return the boolean
	 */
	public Boolean isWidthLooped() {
		return this.widthLooped;
	}

	/**
	 * Paint component.
	 *
	 * @param graphics
	 *            the graphics
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public final void paintComponent(final Graphics graphics) {
		super.paintComponent(graphics);
		final Map<String, ArrayList<IPawn>> mapPawn = this.createMapPawn();

		for (int x = this.getCornerMinX(); x <= this.getCornerMaxX(); x++) {
			for (int y = this.getCornerMinY(); y <= this.getCornerMaxY(); y++) {
				this.drawSquareXY(graphics, x, y);
				this.drawPawnsXY(graphics, mapPawn, x, y);
			}
		}
	}

	public void removeAllPawn() {
		// TODO Auto-generated method stub
		this.pawns = new ArrayList<>();
	}

	public void removePawn(final IPawn pawn) {
		// TODO Auto-generated method stub
		this.getPawns().remove(pawn);
	}

	/**
	 * Sets the dimension.
	 *
	 * @param dimension
	 *            the new dimension
	 */
	public final void setDimension(final Dimension dimension) {
		this.dimension = dimension;
		System.out.println(dimension.width + " " + dimension.height); // TODO a supprimer
		this.squares = new ISquare[this.getDimension().width][this.getDimension().height]; // TODO a clean le + 1
																							// degueulasse
																							// >> Romain et Aure
	}

	/**
	 * Sets the display frame.
	 *
	 * @param displayFrame
	 *            the displayFrame to set
	 */
	public final void setDisplayFrame(final Rectangle displayFrame) {
		this.displayFrame = displayFrame;
	}

	/**
	 * Sets the height looped.
	 *
	 * @param heightLooped
	 *            the new height looped
	 */
	public void setHeightLooped(final Boolean heightLooped) {
		this.heightLooped = heightLooped;
	}

	/**
	 * Sets the width looped.
	 *
	 * @param widthLooped
	 *            the new width looped
	 */
	public void setWidthLooped(final Boolean widthLooped) {
		this.widthLooped = widthLooped;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public final void update(final Observable observable, final Object object) {
		this.repaint();
	}
}
