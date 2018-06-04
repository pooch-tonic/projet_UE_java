/*
 *
 */
package modelInterfaces;

import java.awt.Dimension;
import java.sql.SQLException;

import enums.DirectionEnum;
import enums.TypeEnum;

/**
 * <h1>The Interface IModel.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IModel {

	public IEntity addEntityToLevel(TypeEnum type);

	/**
	 * Adds a score value to the current score value
	 *
	 * @param value
	 */
	void addToScore(final int value);

	public void destroyEntity(IEntity entity);

	public IEntity getExit();

	/**
	 * Gets a level
	 *
	 * @return a level
	 */
	public ILevel getLevel();

	/**
	 * Gets the map.
	 *
	 * @param mapId
	 *            the id of the map
	 * @return the unit by position
	 * @throws SQLException
	 *             the SQL exception
	 */
	Dimension getMap(int mapId) throws SQLException;

	/**
	 * Gets the maxLevels
	 *
	 * @return the maxLevels
	 */
	public int getMaxLevels();

	/**
	 * @return the player as an IEntity.
	 */
	public IEntity getPlayer();

	/**
	 * Gets the score
	 *
	 * @return the score
	 */
	public IScore getScore();

	public IEntity getSpell();

	public IUnit getUnitOn(int x, int y);

	/**
	 * @param levelId
	 * @throws SQLException
	 */
	void loadLevel(int levelId) throws SQLException;

	/**
	 *
	 */
	void resetScore();

	/**
	 * Sets the maxLevels by reading the Database
	 */
	public void setMaxLevels();

	public void setPlayer(IEntity player);

	/**
	 *
	 *
	 * @param direction
	 */
	public void setPlayerDirection(DirectionEnum direction);

	/**
	 * sets the player's spriteset current index to the specified value.
	 */
	public void setPlayerSpriteSetToIndex(final int index);

	/**
	 * sets the player's spell attribute
	 * 
	 * @param spell
	 */
	public void setSpell(IEntity spell);

	/**
	 * updates the attributes of the entity.
	 */
	public void update();

}
