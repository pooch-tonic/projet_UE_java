/*
 *
 */
package model.factories;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import enums.TypeEnum;
import model.Dead;
import model.Door;
import model.Enemy;
import model.Ground;
import model.ImageLoader;
import model.Key;
import model.Loot;
import model.Player;
import model.Spell;
import model.SpriteSet;
import model.WallType;
import modelInterfaces.IEntity;
import modelInterfaces.IUnit;
import showboard.ISpriteSet;

/**
 * <h1>The abstract class UnitFactory which instanciates different types of
 * Unit</h1>
 *
 * @author Ryo SHIINA
 * @version 1.0
 */

public abstract class UnitFactory {

    private static final WallFactory   wallFactory   = new WallFactory();
    private static final EnemyFactory  enemyFactory  = new EnemyFactory();
    private static final PlayerFactory playerFactory = new PlayerFactory();
    private static final KeyFactory    keyFactory    = new KeyFactory();
    private static final LootFactory   lootFactory   = new LootFactory();
    private static final DeadFactory   deadFactory   = new DeadFactory();
    private static final DoorFactory   doorFactory   = new DoorFactory();
    private static final GroundFactory groundFactory = new GroundFactory();
    private static final SpellFactory  spellFactory  = new SpellFactory();

    /**
     * @param spriteSet
     * @return a default dead unit
     */
    public static Dead createDead_default() {
        return deadFactory.createDefault();
    }

    /**
     * @param spriteSet
     * @return a closed door
     */
    public static Door createDoor_closed(final ISpriteSet spriteSet) {
        return doorFactory.createClosed(spriteSet);
    }

    /**
     * @return an open door
     */
    public static Door createDoor_open(final ISpriteSet spriteSet) {
        return doorFactory.createOpen(spriteSet);
    }

    /**
     * @param spriteSet
     * @return an enemy : Arrbarr
     */
    public static Enemy createEnemy_Arrbarr(final ISpriteSet spriteSet) {
        return enemyFactory.createArrbarr(spriteSet);
    }

    /**
     * @param spriteSet
     * @return an enemy : Cargyv
     */
    public static Enemy createEnemy_Cargyv(final ISpriteSet spriteSet) {
        return enemyFactory.createCargyv(spriteSet);
    }

    /**
     * @param spriteSet
     * @return an enemy : Kyracj
     */
    public static Enemy createEnemy_Kyracj(final ISpriteSet spriteSet) {
        return enemyFactory.createKyracj(spriteSet);
    }

    /**
     * @param spriteSet
     * @return an enemy : Maarcg
     */
    public static Enemy createEnemy_Maarcg(final ISpriteSet spriteSet) {
        return enemyFactory.createMaarcg(spriteSet);
    }

    // TODO UTILISER IMAGELOADER
    public static IEntity createEntity(final TypeEnum type, final ArrayList<String> spritePath) {
        final ArrayList<BufferedImage> images = new ArrayList<>();
        for (final String path : spritePath) {
            images.add(ImageLoader.getImageByPath(path));
        }

        final ISpriteSet spriteSet = new SpriteSet(images);
        
        switch (type) {
        case ENEMY_A:
            return createEnemy_Arrbarr(spriteSet);
        case ENEMY_B:
            return createEnemy_Cargyv(spriteSet);
        case ENEMY_C:
            return createEnemy_Kyracj(spriteSet);
        case ENEMY_D:
            return createEnemy_Maarcg(spriteSet);
        case PLAYER:
            return createPlayer_Lorann(spriteSet);
        case KEY:
            return createKey_blue(spriteSet);
        case LOOT:
            return createLoot_coin(spriteSet);
        case DOOR:
            return createDoor_closed(spriteSet);
        case DEAD:
            return createDead_default();
        case SPELL:
            return createSpell();
        default:
            return null;
        }
    }

    public static Ground createGround_default(final ISpriteSet spriteSet) {
        return groundFactory.createDefault();
    }

    /**
     * @param spriteSet
     * @return a blue key
     */
    public static Key createKey_blue(final ISpriteSet spriteSet) {
        return keyFactory.createBlue(spriteSet);
    }

    /**
     * @param spriteSet
     * @return a loot : coin (score value 200)
     */
    public static Loot createLoot_coin(final ISpriteSet spriteSet) {
        return lootFactory.createCoin(spriteSet);
    }

    /**
     * @param spriteSet
     * @return the player : Lorann
     */
    public static Player createPlayer_Lorann(final ISpriteSet spriteSet) {
        return playerFactory.createLorann(spriteSet);
    }

    public static Spell createSpell() {
        return spellFactory.createSpell();

    }

    public static void setSpellSpriteSet(final ArrayList<String> spritePath) {
        spellFactory.setSpriteSet(spritePath);
    }

    public static void setDeadSpriteSet(final ArrayList<String> spritePath) {
        deadFactory.setSpriteSet(spritePath);
    }

    public static IUnit createWall(final WallType wallType, final String path) {
        switch (wallType) {
        case WALL_HORIZONTAL:
            return wallFactory.createDefault(ImageLoader.getImageByPath(path));
        case WALL_VERTICAL:
            return wallFactory.createDefault(ImageLoader.getImageByPath(path));
        case WALL_ROUND:
            return wallFactory.createDefault(ImageLoader.getImageByPath(path));
        default:
            return null;
        }

    }

}
