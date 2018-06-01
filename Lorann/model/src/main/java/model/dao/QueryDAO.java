package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import enums.TypeEnum;

/**
 * <h1>The Class ExampleDAO.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public abstract class QueryDAO extends AbstractDAO {

    /** The sql unit by type. */
    private static String sqlUnitByType    = "{call getUnitByType(?, ?)}";

    /** The sql unit by Position. */
    private static String sqlUnitByPosition = "{call getUnitByPosition(?, ?, ?)}";

    /** The sql all examples. */
    private static String sqlUnitByMap   = "{call getUnitByMap(?)}";

    /** The sql all examples. */
    private static String sqlSpritePath   = "{call getSpritePath(?)}";
    
    /** The sql all examples. */
    private static String sqlMap   = "{call getMap(?)}";

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
    public static ResultSet getUnitByType(TypeEnum type, int mapId) throws SQLException {
    	final CallableStatement callStatement = prepareCall(sqlUnitByType);
        ResultSet result = null;
        callStatement.setString(1, type.toString());
        callStatement.setInt(2, mapId);
        if (callStatement.execute()) {
            result = callStatement.getResultSet();
            if (result.first()) {
                result.close();
            	return result;
            }
        }
        result.close();
		return result;
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
    public static ResultSet getUnitByPosition(int x, int y, int mapId) throws SQLException {
    	final CallableStatement callStatement = prepareCall(sqlUnitByPosition);
        ResultSet result = null;
        callStatement.setInt(1, x);
        callStatement.setInt(2, y);
        callStatement.setInt(3, mapId);
        if (callStatement.execute()) {
            result = callStatement.getResultSet();
            if (result.first()) {
                result.close();
            	return result;
            }
        }
        result.close();
		return result;
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
    public static ResultSet getUnitByMap(int mapId) throws SQLException {
    	final CallableStatement callStatement = prepareCall(sqlUnitByMap);
        ResultSet result = null;
        callStatement.setInt(1, mapId);
        if (callStatement.execute()) {
            result = callStatement.getResultSet();
            if (result.first()) {
                result.close();
            	return result;
            }
        }
        result.close();
		return result;
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
    public static ResultSet getSpritePath(TypeEnum type) throws SQLException {
    	final CallableStatement callStatement = prepareCall(sqlSpritePath);
        ResultSet result = null;
        callStatement.setString(1, type.toString());
        if (callStatement.execute()) {
            result = callStatement.getResultSet();
            if (result.first()) {
                result.close();
            	return result;
            }
        }
        result.close();
		return result;
    }
    
    
    /**
     * Gets the map.
     * 
     * @param mapId
     *            the id of the map
     * @return the unit by position
     * @throws SQLException
     *             the SQL exception
     */ 
    public static ResultSet getMap(int mapId) throws SQLException {
    	final CallableStatement callStatement = prepareCall(sqlMap);
        ResultSet result = null;
        callStatement.setInt(1, mapId);
        if (callStatement.execute()) {
            result = callStatement.getResultSet();
            if (result.first()) {
                result.close();
            	return result;
            }
        }
        result.close();
		return result;
    }
}
