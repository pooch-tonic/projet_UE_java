package model.factories;

import model.Loot;
import model.LootType;

class LootFactory {
	Loot createApple() {
		return new Loot(LootType.APPLE);
	}

	Loot createCoin() {
		return new Loot(LootType.COIN);
	}
}
