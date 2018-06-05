/*
 *
 */
package model;

import enums.UnitTypeEnum;
import model.behaviorstrategy.DoNotBounce;
import model.behaviorstrategy.DoNotDodge;
import model.behaviorstrategy.DoNotMove;
import showboard.ISpriteSet;
import vector.IVector;

/**
 * <h1>The Loot class.</h1> Grants the user a certain score value when picked
 * up.
 * 
 * @author Ryo SHIINA
 *
 */
public class Loot extends Entity {
	public static int SCORE = 620;

	/**
	 * Instantiates a new Loot
	 *
	 * @param coin
	 *
	 */
	public Loot(final LootTypeEnum coin, final ISpriteSet spriteSet) {
		super(UnitTypeEnum.LOOT, spriteSet);
		this.setBounceStrategy(new DoNotBounce());
		this.setDodgeStrategy(new DoNotDodge());
		this.setMoveStrategy(new DoNotMove());
		this.setScoreValue(SCORE);
	}

	/**
	 * Instantiates a new Loot
	 *
	 * @param position
	 */
	public Loot(final IVector position) {
		super(position, UnitTypeEnum.LOOT);
		this.setScoreValue(SCORE);
	}

	/**
	 * Instantiates a new Loot
	 *
	 * @param position
	 * @param lootType
	 */
	public Loot(final IVector position, final LootTypeEnum lootType) {
		super(position, UnitTypeEnum.LOOT);
		this.setLootScoreValue(lootType);
		this.setScoreValue(SCORE);
	}

	/**
	 * Instantiates a new Loot
	 *
	 * @param lootType
	 */
	public Loot(final LootTypeEnum lootType) {
		super(UnitTypeEnum.LOOT);
		this.setLootScoreValue(lootType);
	}

	/**
	 * @param lootType
	 */
	private void setLootScoreValue(final LootTypeEnum lootType) {
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
