/*
 *
 */
package model;

import java.awt.image.BufferedImage;

import enums.AllUnitEnum;

/**
 * <h1>The IImageLoader interface.</h1> Allows to use the ImageLoader class to
 * load images from resource path.
 * 
 * @author Ryo SHIINA
 *
 */
public interface IImageLoader {
	public BufferedImage getImageBypath(AllUnitEnum type);
}
