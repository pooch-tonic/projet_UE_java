/*
 *
 */
package model.dao;

import java.awt.Dimension;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import enums.TypeEnum;
import vector.IVector;
import vector.Vector;

/**
 * <h1>The Class ExampleDAO.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public abstract class QueryDAO extends AbstractDAO {

    /** The sql unit by type. */
    private static String sqlUnitByType = "{call getUnitByType(?, ?)}";

    /** The sql unit by Position. */
    private static String sqlUnitByPosition = "{call getUnitByPosition(?, ?, ?)}";

    /** The sql all examples. */
    private static String sqlUnitByMap = "{call getUnitByMap(?)}";

    /** The sql all examples. */
    private static String sqlSpritePath = "{call getSpritePath(?)}";

    /** The sql all examples. */
    private static String sqlMap = "{call getMap(?)}";

    /**
     * Gets the map.
     *
     * @param mapId
     *            the id of the map
     * @return the unit by position
     * @throws SQLException
     *             the SQL exception
     */
    public static Dimension getMap(final int mapId) throws SQLException {
        final CallableStatement callStatement = prepareCall(sqlMap);
        ResultSet result;
        callStatement.setInt(1, mapId);
        if (callStatement.execute()) {
            result = callStatement.getResultSet();
            if (result.next()) {
                return new Dimension(result.getInt(2), result.getInt(3));
            }
        }
        return null;
    }

    /**
     * Gets the path of the sprite.
     *
     * @param type
     *            the type of the unit
     * @return the path of the sprite
     * @throws SQLException
     *             the SQL exception
     */
    public static ArrayList<String> getSpritePath(final TypeEnum type) throws SQLException {
        final ArrayList<String> resultString = new ArrayList<String>();
        final CallableStatement callStatement = prepareCall(sqlSpritePath);
        ResultSet result;
        callStatement.setString(1, type.toString());
        if (callStatement.execute()) {
            result = callStatement.getResultSet();
            for (boolean isResultLeft = result.first(); isResultLeft; isResultLeft = result
                    .next()) {
                resultString.add(result.getString("Path"));
            }
            result.close();
        }
        return resultString;
    }

    /**
     * Gets the unit by map.
     *
     * @param mapId
     *            the id of the map
     * @return the unit by map
     * @throws SQLException
     *             the SQL exception
     */
    public static HashMap<String, IVector> getUnitByMap(final int mapId) throws SQLException {
        final HashMap<String, IVector> resultMap = new HashMap<String, IVector>();
        final CallableStatement callStatement = prepareCall(sqlUnitByMap);
        ResultSet result;
        callStatement.setInt(1, mapId);
        if (callStatement.execute()) {
            result = callStatement.getResultSet();
            for (boolean isResultLeft = result.first(); isResultLeft; isResultLeft = result
                    .next()) {
                resultMap.put(result.getString(1), new Vector(result.getInt(2), result.getInt(3)));
            }
            result.close();
        }
        return resultMap;
    }

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
    public static String getUnitByPosition(final int x, final int y, final int mapId)
            throws SQLException {
        final CallableStatement callStatement = prepareCall(sqlUnitByPosition);
        ResultSet result;
        callStatement.setInt(1, x);
        callStatement.setInt(2, y);
        callStatement.setInt(3, mapId);
        if (callStatement.execute()) {
            result = callStatement.getResultSet();
            return result.getString(1);
        }
        return null;
    }

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
    public static ArrayList<IVector> getUnitByType(final TypeEnum type, final int mapId)
            throws SQLException {
        final ArrayList<IVector> resultUnit = new ArrayList<IVector>();
        final CallableStatement callStatement = prepareCall(sqlUnitByType);
        ResultSet result = null;
        callStatement.setString(1, type.toString());
        callStatement.setInt(2, mapId);
        if (callStatement.execute()) {
            result = callStatement.getResultSet();
            for (boolean isResultLeft = result.first(); isResultLeft; isResultLeft = result
                    .next()) {
                resultUnit.add(new Vector(result.getInt(3), result.getInt(4)));
            }
        }
        result.close();
        return resultUnit;
    }
}
