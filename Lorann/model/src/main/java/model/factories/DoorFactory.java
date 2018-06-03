package model.factories;

import model.Door;
import showboard.ISpriteSet;

class DoorFactory {
	Door createClosed(ISpriteSet spriteSet) {
		return new Door(true, spriteSet);
	}

	Door createOpen(ISpriteSet spriteSet) {
		return new Door(false, spriteSet);
	}
}
