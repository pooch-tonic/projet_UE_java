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
    void addToScore(final int value);

    ILevel getLevel();

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

    int getScore();

    void loadLevel(int levelId) throws SQLException;

    void resetScore();

    // TODO javadoc
    public void setPlayerDirection(DirectionEnum direction);
}
