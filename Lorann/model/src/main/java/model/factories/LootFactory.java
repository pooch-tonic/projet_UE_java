package model.factories;

import model.Loot;
import model.LootType;
import showboard.ISpriteSet;

class LootFactory {
	Loot createCoin(ISpriteSet spriteSet) {
		return new Loot(LootType.COIN);
	}
}
