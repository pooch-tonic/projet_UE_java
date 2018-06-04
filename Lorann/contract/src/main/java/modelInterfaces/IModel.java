/*
 *
 */
package modelInterfaces;

import java.awt.Dimension;
import java.sql.SQLException;

import enums.DirectionEnum;

/**
 * <h1>The Interface IModel.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IModel {

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

	public IEntity getPlayer();

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
	 *
	 *
	 * @param direction
	 */
	public void setPlayerDirection(DirectionEnum direction);

	public void update();
}
