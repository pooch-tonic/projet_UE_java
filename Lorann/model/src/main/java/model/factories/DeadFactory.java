package model.factories;

import model.Dead;
import showboard.ISpriteSet;

class DeadFactory {
	Dead createDefault(ISpriteSet spriteSet) {
		return new Dead(spriteSet);
	}
}
