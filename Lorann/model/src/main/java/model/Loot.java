package model;

import enums.TypeEnum;
import modelInterfaces.ILoot;
import modelInterfaces.IVector;

/**
 * @author Max Becerro
 *
 */
public class Loot extends Entity implements ILoot {

	public Loot() {
		super(TypeEnum.LOOT);
		// TODO Auto-generated constructor stub
	}

	public Loot(final IVector position) {
		super(position, TypeEnum.LOOT);
		// TODO Auto-generated constructor stub
	}

	public Loot(final IVector position, final LootType lootType) {
		super(position, TypeEnum.LOOT);
		this.setLootScoreValue(lootType);
	}

	public Loot(final LootType lootType) {
		super(TypeEnum.LOOT);
		this.setLootScoreValue(lootType);
	}

	private void setLootScoreValue(final LootType lootType) {
		switch (lootType) {
		case COIN:
			super.setScoreValue(200);
			break;
		case APPLE:
			super.setScoreValue(50);
			break;
		}
	}

}
