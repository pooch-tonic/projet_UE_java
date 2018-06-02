package model;

import java.awt.image.BufferedImage;
import java.io.File;


import javax.imageio.ImageIO;

import model.dao.QueryDAO;
import modelInterfaces.IImageLoader;
import showboard.TypeEnum;

/**
 * @author Max Becerro
 *
 */
public abstract class ImageLoader implements IImageLoader{
	
	/**
	 * @param type
	 * @return an image
	 */
	public BufferedImage getImageBypath(TypeEnum type, int index) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(QueryDAO.getSpritePath(type).get(index))) ;
		} catch (Exception e) {
			return null;
		}
		
		return image;
	}

}
