package model.factories;

import model.Dead;
import model.Door;
import model.Enemy;
import model.Key;
import model.Loot;
import model.Player;
import model.Wall;

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

}
