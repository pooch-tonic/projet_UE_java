package model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public interface ISpriteSet {
	public int getMaxIndex();
	
	
	public BufferedImage getSpriteByIndex(int index);
	
	public void setNextSprite();

	public void resetIndex();
	
	public ArrayList<BufferedImage> getSprites();
	
	public void setSprites(ArrayList<BufferedImage> sprites);
	
}
