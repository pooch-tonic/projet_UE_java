/*
 *
 */
package model.factories;

import model.Wall;
import showboard.ISpriteSet;

class WallFactory {
	Wall createDefault(final ISpriteSet spriteSet) {
		return new Wall();
	}
}
