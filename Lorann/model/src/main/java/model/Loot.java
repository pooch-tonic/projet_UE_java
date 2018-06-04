/*
 *
 */
package model;

import enums.Type;
import model.behaviorStrategy.DoNotBounce;
import model.behaviorStrategy.DoNotDodge;
import model.behaviorStrategy.DoNotMove;
import showboard.ISpriteSet;
import vector.IVector;

/**
 * @author Max Becerro
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
    public Loot(final LootType coin, final ISpriteSet spriteSet) {
        super(Type.LOOT, spriteSet);
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
        super(position, Type.LOOT);
        this.setScoreValue(SCORE);
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
        this.setScoreValue(SCORE);
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
