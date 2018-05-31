package modelInterfaces;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public interface ISpriteSet {
	public int getMaxIndex();
	
	
	public BufferedImage getSpriteByIndex(final int index);
	
	public void setNextSprite();

	public void resetIndex();
	
	public ArrayList<BufferedImage> getSprites();
	
	public void setSprites(final ArrayList<BufferedImage> sprites);
	
}
