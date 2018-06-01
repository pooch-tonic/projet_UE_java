package model;

import java.awt.image.BufferedImage;
import java.io.File;


import javax.imageio.ImageIO;

import enums.TypeEnum;
import model.dao.QueryDAO;
import modelInterfaces.IImageLoader;

/**
 * @author Max Becerro
 *
 */
public abstract class ImageLoader implements IImageLoader{
	
	/**
	 * @param type
	 * @return an image
	 */
	public BufferedImage getImageBypath(TypeEnum type) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(QueryDAO.getSpritePath(type).getString(3))) ;
		} catch (Exception e) {
			return null;
		}
		
		return image;
	}

}
