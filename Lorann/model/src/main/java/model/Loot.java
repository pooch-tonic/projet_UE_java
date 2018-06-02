/*
 *
 */
package model;

import java.awt.Image;

import enums.TypeEnum;
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
	public Loot() {
		super(TypeEnum.LOOT);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new Loot
	 *
	 * @param position
	 */
	public Loot(final IVector position) {
		super(position, TypeEnum.LOOT);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new Loot
	 *
	 * @param position
	 * @param lootType
	 */
	public Loot(final IVector position, final LootType lootType) {
		super(position, TypeEnum.LOOT);
		this.setLootScoreValue(lootType);
	}

	/**
	 * Instantiates a new Loot
	 *
	 * @param lootType
	 */
	public Loot(final LootType lootType) {
		super(TypeEnum.LOOT);
		this.setLootScoreValue(lootType);
	}

	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getX() {
		return this.getPosition().getX();
	}

	@Override
	public int getY() {
		return this.getPosition().getY();
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

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
