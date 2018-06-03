/*
 * 
 */
package model;

import java.awt.image.BufferedImage;

import enums.TypeEnum;

public interface IImageLoader {
    public BufferedImage getImageBypath(TypeEnum type);
}
