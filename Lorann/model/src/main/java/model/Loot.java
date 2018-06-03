/*
 *
 */
package model;

import java.awt.Image;

import enums.Type;
import enums.TypeEnum;
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
    public Loot(ISpriteSet spriteSet) {
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

    @Override
    public Image getImage() {
        return ImageLoader.getImageByPath(TypeEnum.LOOT, 0);
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

	@Override
	public void setType(TypeEnum type) {
		// TODO Auto-generated method stub
		
	}

}
