package modelInterfaces;

import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

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
	ArrayList<IVector> getUnitByType(TypeEnum type, int mapId) throws SQLException;

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
	String getUnitByPosition(int x, int y, int mapId) throws SQLException;

	/**
     * Gets the unit by map.
     *
     * @param mapId
     *            the id of the map
     * @return the unit by map
     * @throws SQLException
     *             the SQL exception
     */ 
	HashMap<String, IVector> getUnitByMap(int mapId) throws SQLException;

	/**
     * Gets the path of the sprite.
     *
     * @param type
     *            the type of the unit
     * @return the path of the sprite
     * @throws SQLException
     *             the SQL exception
     */ 
	ArrayList<String> getSpritePath(TypeEnum type) throws SQLException;

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
}
