package modelInterfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import enums.TypeEnum;

/**
 * <h1>The Interface IModel.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IModel {
    ILevel getLevel();

    int getScoreValue();

    void addToScoreValue(final int value);

    void reset();

    void loadLevel(int levelId);
    /**
     * Gets the unit by type.
     *
     * @param type
     *            the type of the unit
     * @param mapId
     *            the id of the map
     * @return the unit by type
     * @throws SQLException
     *             the SQL exception
     */ 
	ResultSet getUnitByType(TypeEnum type, int mapId) throws SQLException;

	/**
     * Gets the unit by position.
     *
     * @param x
     *            the x coordinate
     * @param y
     *            the y coordinate
     * @param mapId
     *            the id of the map
     * @return the unit by position
     * @throws SQLException
     *             the SQL exception
     */ 
	ResultSet getUnitByPosition(int x, int y, int mapId) throws SQLException;

	/**
     * Gets the unit by map.
     *
     * @param mapId
     *            the id of the map
     * @return the unit by map
     * @throws SQLException
     *             the SQL exception
     */ 
	ResultSet getUnitByMap(int mapId) throws SQLException;

	/**
     * Gets the path of the sprite.
     *
     * @param type
     *            the type of the unit
     * @return the path of the sprite
     * @throws SQLException
     *             the SQL exception
     */ 
	ResultSet getSpritePath(TypeEnum type) throws SQLException;

	/**
     * Gets the map.
     * 
     * @param mapId
     *            the id of the map
     * @return the unit by position
     * @throws SQLException
     *             the SQL exception
     */ 
	ResultSet getMap(int mapId) throws SQLException;
}
