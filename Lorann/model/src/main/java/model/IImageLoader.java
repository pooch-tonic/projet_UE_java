/*
 * 
 */
package model;

import java.awt.image.BufferedImage;

import enums.AllUnitEnum;

public interface IImageLoader {
    public BufferedImage getImageBypath(AllUnitEnum type);
}
