package showboard;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public interface ISpriteSet {

	// TODO JAVADOC
	/**
	 * @return the current animation index of the SpriteSet
	 */
	public int getCurrentIndex();
	
	/**
	 * returns the sprite according to the current animation index, calls
	 * getSpriteByIndex() method.
	 *
	 * @return the sprite of index currentIndex. Null if ArrayList is empty.
	 */
	public BufferedImage getCurrentSprite();

	/**
	 * @return the maximal value of the animation index, to prevent a
	 *         NullPointerException
	 */
	public int getMaxIndex();

	/**
	 * returns the sprite according to its index ; putting a higher value than the
	 * maxIndex will return the first sprite of the ArrayList
	 *
	 * @param index
	 * @return a sprite for the given index, null if ArrayList is empty.
	 */
	public BufferedImage getSpriteByIndex(final int index);

	/**
	 * @return the sprites ArrayList
	 */
	public ArrayList<BufferedImage> getSprites();

	/**
	 * sets the currentIndex to 0
	 */
	public void resetIndex();
	
	/**
	 * sets the next sprite by shifting the current index, with a modulo preventing
	 * NullPointerException
	 */
	public void setNextSprite();

	/**
	 * @param sprites
	 */
	public void setSprites(final ArrayList<BufferedImage> sprites);

	/**
	 * @param image
	 */
	public void setSprites(final BufferedImage image);

	/**
	 * @param spriteSet
	 */
	public void setSprites(final ISpriteSet spriteSet);

}
