package model.factories;

import model.Key;
import showboard.ISpriteSet;

class KeyFactory {
	Key createBlue(ISpriteSet spriteSet) {
		return new Key(spriteSet);
	}
}
