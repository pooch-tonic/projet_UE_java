package model.factories;

import model.Loot;
import model.LootTypeEnum;
import showboard.ISpriteSet;

class LootFactory {
	Loot createPurse(ISpriteSet spriteSet) {
		return new Loot(LootTypeEnum.COIN, spriteSet);
	}
}
