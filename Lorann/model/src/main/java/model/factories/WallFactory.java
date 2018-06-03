/*
 *
 */
package model.factories;

import java.awt.image.BufferedImage;

import model.Wall;

class WallFactory {

	Wall createDefault(final BufferedImage image) {
		return new Wall(image);
	}
}
