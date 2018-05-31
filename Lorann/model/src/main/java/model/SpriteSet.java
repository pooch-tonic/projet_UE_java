package model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import modelInterfaces.ISpriteSet;

public class SpriteSet {

	private ArrayList<BufferedImage> sprites;
	private int currentIndex;

	public int getCurrentIndex() {
		return this.currentIndex;
	}

	public int getMaxIndex() {

		// getSpriteByIndex(24);

		return this.getSprites().size() - 1;
	}

	public BufferedImage getSpriteByIndex(final int index) {

		// this.currentIndex = index;
		return this.getSprites().get(index);
	}

	public ArrayList<BufferedImage> getSprites() {
		return this.sprites;
	}

	public void resetIndex() {

		this.setCurrentIndex(0);

	}

	private void setCurrentIndex(final int currentIndex) {
		this.currentIndex = currentIndex;
	}

	public void setNextSprite() {

		this.setCurrentIndex((this.currentIndex + 1) % this.getMaxIndex());

	}

	public void setSprite(final ISpriteSet spriteSet) {
		this.sprites = spriteSet.getSprites();
	}

	public void setSprites(final ArrayList<BufferedImage> sprites) {
		this.sprites = sprites;
	}
}
