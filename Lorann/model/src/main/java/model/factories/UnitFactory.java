package model.factories;

import enums.TypeEnum;
import model.Dead;
import model.Door;
import model.Enemy;
import model.Key;
import model.Loot;
import model.Player;
import model.Spell;
import model.Wall;
import modelInterfaces.IEntity;

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
	 * @return a default dead unit
	 */
	public static Dead createDead_default() {
		return deadFactory.createDefault();
	}

	/**
	 * @return a closed door
	 */
	public static Door createDoor_closed() {
		return doorFactory.createClosed();
	}

	/**
	 * @return an open door
	 */
	public static Door createDoor_open() {
		return doorFactory.createOpen();
	}

	/**
	 * @return an enemy : Arrbarr
	 */
	public static Enemy createEnemy_Arrbarr() {
		return enemyFactory.createArrbarr();
	}

	/**
	 * @return an enemy : Cargyv
	 */
	public static Enemy createEnemy_Cargyv() {
		return enemyFactory.createCargyv();
	}

	/**
	 * @return an enemy : Kyracj
	 */
	public static Enemy createEnemy_Kyracj() {
		return enemyFactory.createKyracj();
	}

	/**
	 * @return an enemy : Maarcg
	 */
	public static Enemy createEnemy_Maarcg() {
		return enemyFactory.createMaarcg();
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

	public static IEntity createUnit(TypeEnum type) {
		switch(type) {
			case ENEMY_A :
				return createEnemy_Arrbarr();
			case ENEMY_B :
				return createEnemy_Cargyv();
			case ENEMY_C :
				return createEnemy_Kyracj();
			case ENEMY_D :
				return createEnemy_Maarcg();
			case PLAYER :
				return createPlayer_Lorann();
			case KEY :
				return createKey_blue();
			case LOOT :
				return createLoot_coin();
			case DOOR_OPEN :
				return createDoor_open();
			case DOOR_CLOSED :
				return createDoor_closed();
			case DEAD :
				return createDead_default();
			case SPELL :
				return createSpell();
		}
		return null;
	}
}
