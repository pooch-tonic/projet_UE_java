package model.factories;

import model.Loot;
import model.LootType;
import showboard.ISpriteSet;

class LootFactory {
	Loot createApple() {
		return new Loot(LootType.APPLE);
	}

	Loot createCoin(ISpriteSet spriteSet) {
		return new Loot(LootType.COIN);
	}
}
