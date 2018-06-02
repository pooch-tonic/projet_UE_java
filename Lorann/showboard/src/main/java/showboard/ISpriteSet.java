package showboard;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public interface ISpriteSet {
	public int getCurrentIndex();

	public BufferedImage getCurrentSprite();

	public int getMaxIndex();

	public BufferedImage getSpriteByIndex(final int index);

	public ArrayList<BufferedImage> getSprites();

	public void resetIndex();

	public void setNextSprite();

	public void setSprites(final ArrayList<BufferedImage> sprites);

	public void setSprites(final ISpriteSet spriteSet);

}
