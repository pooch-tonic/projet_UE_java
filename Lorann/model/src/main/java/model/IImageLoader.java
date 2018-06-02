/*
 * 
 */
package model;

import java.awt.image.BufferedImage;

import model.dao.TypeEnum;

public interface IImageLoader {
    public BufferedImage getImageBypath(TypeEnum type);
}
