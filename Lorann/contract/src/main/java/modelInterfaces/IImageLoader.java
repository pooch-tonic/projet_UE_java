package modelInterfaces;

import java.awt.image.BufferedImage;

import showboard.TypeEnum;



public interface IImageLoader {
	public BufferedImage getImageBypath(TypeEnum type);
}
