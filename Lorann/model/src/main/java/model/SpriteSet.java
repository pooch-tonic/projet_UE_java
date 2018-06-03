package model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import showboard.ISpriteSet;

/**
 * <h1>The SpriteSet class to store one or many sprites as a set</h1>
 *
 * @author Max Becerro
 * @author Ryo SHIINA
 *
 */

public class SpriteSet implements ISpriteSet {

	private ArrayList<BufferedImage> sprites;
	private int currentIndex;
	private int maxIndex;
	private int nSprites;

	/**
	 * the default constructor
	 */
	public SpriteSet() {
		this.setSprites(new ArrayList<BufferedImage>());
		this.getSprites().add(new BufferedImage(0, 0, 0)); // TODO default image required
		this.configure();
	}

	/**
	 * the constructor for a BufferedImage ArrayList
	 *
	 * @param sprites
	 */
	public SpriteSet(final ArrayList<BufferedImage> sprites) {
		this.setSprites(sprites);
		this.configure();
	}

	/**
	 * the constructor for a single image SpriteSet
	 *
	 * @param image
	 */
	public SpriteSet(final BufferedImage image) {
		this.setSprites(new ArrayList<BufferedImage>());
		this.getSprites().add(image);
		this.configure();
	}

	/**
	 * configures the maxIndex and nSprites values to fit the SpriteSet ArrayList.
	 */
	private void configure() {
		this.setnSprites(this.getSprites().size());
		this.setMaxIndex(this.getnSprites() - 1);
	}

	/**
	 * @return the current animation index of the SpriteSet
	 */
	public int getCurrentIndex() {
		return this.currentIndex;
	}

	/**
	 * returns the sprite according to the current animation index
	 *
	 * @return
	 */
	public BufferedImage getCurrentSprite() {
		return this.getSpriteByIndex(this.getCurrentIndex());
	}

	/**
	 * @return the maximal value of the animation index, to prevent a
	 *         NullPointerException
	 */
	public int getMaxIndex() {
		return this.maxIndex;
	}

	public int getnSprites() {
		return this.nSprites;
	}

	/**
	 * returns the sprite according to its index ; putting a higher value than the
	 * maxIndex will return the first sprite of the ArrayList
	 *
	 * @param index
	 * @return a spriteByIndex
	 */
	public BufferedImage getSpriteByIndex(final int index) {
		return this.getSprites().get(index);
	}

	/**
	 * @return the sprites ArrayList
	 */
	public ArrayList<BufferedImage> getSprites() {
		return this.sprites;
	}

	/**
	 * sets the currentIndex to 0
	 */
	public void resetIndex() {
		this.setCurrentIndex(0);
	}

	/**
	 * @param currentIndex
	 */
	private void setCurrentIndex(final int currentIndex) {
		this.currentIndex = currentIndex;
	}

	/**
	 * @param maxIndex
	 */
	private void setMaxIndex(final int maxIndex) {
		this.maxIndex = maxIndex;
	}

	/**
	 * sets the next sprite by shifting the current index, with a modulo preventing
	 * NullPointerException
	 */
	public void setNextSprite() {
		this.setCurrentIndex((this.currentIndex + 1) % this.getnSprites());
	}

	/**
	 * @param nSprites
	 */
	private void setnSprites(final int nSprites) {
		this.nSprites = nSprites;
	}

	/**
	 * @param spriteSet
	 */
	public void setSprite(final ISpriteSet spriteSet) {
		this.sprites = spriteSet.getSprites();
	}

	/**
	 * @param sprites
	 */
	public void setSprites(final ArrayList<BufferedImage> sprites) {
		this.sprites = sprites;
	}

	@Override
	public void setSprites(ISpriteSet spriteSet) {
		// TODO Auto-generated method stub
		
	}
}
