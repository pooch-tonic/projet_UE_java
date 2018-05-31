package model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class SpriteSet {
	
	private ArrayList<BufferedImage> sprites;
	private int currentIndex;
	
	
	
	
	public int getMaxIndex() {
		
		//getSpriteByIndex(24);
		
		return this.getSprites().size()-1;
	}
	
	
	public BufferedImage getSpriteByIndex(int index) {
		

		//this.currentIndex = index;
		return getSprites().get(index);
	}
	
	
	public void setNextSprite() {
		
			this.setCurrentIndex((currentIndex+1)%getMaxIndex());
		

		
	}
	
	
	public void resetIndex() {
		
		this.setCurrentIndex(0);
		
	}
	
	
	
	
	
	public ArrayList<BufferedImage> getSprites() {
		return sprites;
	}
	public void setSprites(ArrayList<BufferedImage> sprites) {
		this.sprites = sprites;
	}
	private int getCurrentIndex() {
		return currentIndex;
	}
	private void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}
}
