package model;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import model.factories.UnitFactory;

/**
 * @author Max Becerro
 *
 */
public abstract class ImageLoader implements IImageLoader {

	/**
	 * @param type
	 * @return an image
	 */
	public static BufferedImage getImageByPath(final String path) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(UnitFactory.class.getResource(path));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return image;
	}

}
