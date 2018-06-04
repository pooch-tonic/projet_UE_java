/*
 *
 */
package model.factories;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import model.Dead;
import model.ImageLoader;
import model.SpriteSet;
import showboard.ISpriteSet;

class DeadFactory {
    private ISpriteSet spriteSet;

    Dead createDefault() {
        return new Dead(this.spriteSet);
    }

    public void setSpriteSet(final ArrayList<String> spritePath) {
        final ArrayList<BufferedImage> images = new ArrayList<>();
        for (final String path : spritePath) {
            images.add(ImageLoader.getImageByPath(path));
        }
        this.spriteSet = new SpriteSet(images);
    }
}
