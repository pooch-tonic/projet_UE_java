package model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import modelInterfaces.ISpriteSet;

/**
 * @author Max Becerro
 *
 */
public class SpriteSet {

	private ArrayList<BufferedImage> sprites;
	private int currentIndex;
	/**
	 * 
	 * @return a currentIndex
	 */
	public int getCurrentIndex() {
		return this.currentIndex;
	}

	/**
	 * @return a maxIndex
	 */
	public int getMaxIndex() {
		
		return this.getSprites().size() - 1;
	}

	/**
	 * @param index
	 * @return a spriteByIndex
	 */
	public BufferedImage getSpriteByIndex(final int index) {

		return this.getSprites().get(index);
	}

	/**
	 * @return a sprites
	 */
	public ArrayList<BufferedImage> getSprites() {
		return this.sprites;
	}

	/**
	 * set current Index to 0
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
	 * set the next sprite
	 */
	public void setNextSprite() {

		this.setCurrentIndex((this.currentIndex + 1) % this.getMaxIndex());

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
}
