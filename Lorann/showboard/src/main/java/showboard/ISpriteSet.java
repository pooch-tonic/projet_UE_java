package showboard;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * The interface used by the SpriteSet class.
 * 
 * @author Ryo SHIINA
 * @author Max Becerro
 *
 */
public interface ISpriteSet {

	/**
	 * Returns the current animation index.
	 * 
	 * @return The current index.
	 */
	public int getCurrentIndex();

	/**
	 * Returns the sprite from the ArrayList, based on the given index.
	 * 
	 * @return The current sprite.
	 */
	public BufferedImage getCurrentSprite();

	/**
	 * Returns the maximum index of the ArrayList.
	 * 
	 * @return The maximum index.
	 */
	public int getMaxIndex();

	/**
	 * Returns the sprite that matches the given index.
	 * 
	 * @param index
	 * @return A sprite that belongs to the given index.
	 */
	public BufferedImage getSpriteByIndex(final int index);

	/**
	 * Returns the ArrayList of sprites.
	 * 
	 * @return The whole ArrayList of sprites.
	 */
	public ArrayList<BufferedImage> getSprites();

	/**
	 * Resets the currentIndex to 0.
	 */
	public void resetIndex();

	/**
	 * Allows the user to set the current index to a certain value.
	 * 
	 * @param currentIndex
	 */
	public void setCurrentIndex(final int currentIndex);

	/**
	 * Increments the current index to set it to the next one.
	 */
	public void setNextSprite();

	/**
	 * Sets the ArrayList of sprites to the given one.
	 * 
	 * @param sprites
	 */
	public void setSprites(final ArrayList<BufferedImage> sprites);

	/**
	 * Sets the ArrayList of sprites to a single BufferedImage.
	 * 
	 * @param image
	 */
	public void setSprites(final BufferedImage image);

	/**
	 * Sets the ArrayList of sprites to the one contained in the given SpriteSet.
	 * 
	 * @param spriteSet
	 */
	public void setSprites(final ISpriteSet spriteSet);

}
