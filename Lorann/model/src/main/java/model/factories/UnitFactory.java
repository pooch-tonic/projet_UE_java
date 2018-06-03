/*
 * 
 */
package model.factories;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import enums.TypeEnum;
import model.Dead;
import model.Door;
import model.Enemy;
import model.Key;
import model.Loot;
import model.Player;
import model.Spell;
import model.SpriteSet;
import model.Wall;
import modelInterfaces.IEntity;
import showboard.ISpriteSet;

/**
 * <h1>The abstract class UnitFactory which instanciates different types of
 * Unit</h1>
 *
 * @author Ryo SHIINA
 * @version 1.0
 */

public abstract class UnitFactory {
  
	private static final WallFactory wallFactory = new WallFactory();
	private static final EnemyFactory enemyFactory = new EnemyFactory();
	private static final PlayerFactory playerFactory = new PlayerFactory();
	private static final KeyFactory keyFactory = new KeyFactory();
	private static final LootFactory lootFactory = new LootFactory();
	private static final DeadFactory deadFactory = new DeadFactory();
	private static final DoorFactory doorFactory = new DoorFactory();

	/**
	 * @param spriteSet 
	 * @return a default dead unit
	 */
	public static Dead createDead_default(ISpriteSet spriteSet) {
		return deadFactory.createDefault(spriteSet);
	}

	/**
	 * @param spriteSet 
	 * @return a closed door
	 */
	public static Door createDoor_closed(ISpriteSet spriteSet) {
		return doorFactory.createClosed(spriteSet);
	}

	/**
	 * @return an open door
	 */
	public static Door createDoor_open(ISpriteSet spriteSet) {
		return doorFactory.createOpen(spriteSet);
	}

	/**
	 * @param spriteSet 
	 * @return an enemy : Arrbarr
	 */
	public static Enemy createEnemy_Arrbarr(ISpriteSet spriteSet) {
		return enemyFactory.createArrbarr(spriteSet);
	}

	/**
	 * @param spriteSet 
	 * @return an enemy : Cargyv
	 */
	public static Enemy createEnemy_Cargyv(ISpriteSet spriteSet) {
		return enemyFactory.createCargyv(spriteSet);
	}

	/**
	 * @param spriteSet 
	 * @return an enemy : Kyracj
	 */
	public static Enemy createEnemy_Kyracj(ISpriteSet spriteSet) {
		return enemyFactory.createKyracj(spriteSet);
	}

	/**
	 * @param spriteSet 
	 * @return an enemy : Maarcg
	 */
	public static Enemy createEnemy_Maarcg(ISpriteSet spriteSet) {
		return enemyFactory.createMaarcg(spriteSet);
	}

	/**
	 * @return a blue key
	 */
	public static Key createKey_blue() {
		return keyFactory.createBlue();
	}

	/**
	 * @return a loot : apple (score value 50)
	 */
	public static Loot createLoot_apple() {
		return lootFactory.createApple();
	}

	/**
	 * @return a loot : coin (score value 200)
	 */
	public static Loot createLoot_coin() {
		return lootFactory.createCoin();
	}

	/**
	 * @return the player : Lorann
	 */
	public static Player createPlayer_Lorann() {
		return playerFactory.createLorann();
	}

	/**
	 * @return a horizontal wall
	 */
	public static Wall createWall_horizontal() {
		return wallFactory.createHorizontal();
	}

	/**
	 * @return a round wall
	 */
	public static Wall createWall_round() {
		return wallFactory.createRound();
	}

	/**
	 * @return a vertical wall
	 */
	public static Wall createWall_Vertical() {
		return wallFactory.createVertical();
	}
	
	public static Spell createSpell() {
		return SpellFactory.createSpell();
		
	}

	public static IEntity createUnit(TypeEnum type, ArrayList<String> spritePath) {
		ArrayList<BufferedImage> images = null;
		for(String sprite : spritePath) {
			try {
				images.add(ImageIO.read(new File(sprite)));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		ISpriteSet spriteSet = new SpriteSet(images);
		
		switch(type) {
			case ENEMY_A :
				return createEnemy_Arrbarr(spriteSet);
			case ENEMY_B :
				return createEnemy_Cargyv(spriteSet);
			case ENEMY_C :
				return createEnemy_Kyracj(spriteSet);
			case ENEMY_D :
				return createEnemy_Maarcg(spriteSet);
			case PLAYER :
				return createPlayer_Lorann(spriteSet);
			case KEY :
				return createKey_blue(spriteSet);
			case LOOT :
				return createLoot_coin(spriteSet);
			case DOOR_OPEN :
				return createDoor_open(spriteSet);
			case DOOR_CLOSED :
				return createDoor_closed(spriteSet);
			case DEAD :
				return createDead_default(spriteSet);
			case SPELL :
				return createSpell(spriteSet);
		}
		return null;
	}
}
