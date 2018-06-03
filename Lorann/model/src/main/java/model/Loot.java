/*
 *
 */
package model;

import enums.Type;
import showboard.ISpriteSet;
import vector.IVector;

/**
 * @author Max Becerro
 *
 */
public class Loot extends Entity {

	/**
	 * Instantiates a new Loot
	 *
	 */
	public Loot(final ISpriteSet spriteSet) {
		super(Type.LOOT);
		super.setSpriteSet(spriteSet);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new Loot
	 *
	 * @param position
	 */
	public Loot(final IVector position) {
		super(position, Type.LOOT);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new Loot
	 *
	 * @param position
	 * @param lootType
	 */
	public Loot(final IVector position, final LootType lootType) {
		super(position, Type.LOOT);
		this.setLootScoreValue(lootType);
	}

	/**
	 * Instantiates a new Loot
	 *
	 * @param lootType
	 */
	public Loot(final LootType lootType) {
		super(Type.LOOT);
		this.setLootScoreValue(lootType);
	}

	/**
	 * @param lootType
	 */
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
