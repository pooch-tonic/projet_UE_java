package model.factories;

import model.Player;
import showboard.ISpriteSet;

class PlayerFactory {
	Player createLorann(ISpriteSet spriteSet) {
		return new Player(spriteSet);
	}
}
