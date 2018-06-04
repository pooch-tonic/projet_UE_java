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

    public void setPlayer(IEntity player);

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

    public IEntity getSpell();

    public void setSpell(IEntity spell);

    public void update();

    public IUnit getUnitOn(int x, int y);

    public IEntity addEntityToLevel(TypeEnum type);

    public void removeEntityFromLevel(IEntity entity);

    /**
     * Gets the maxLevels
     *
     * @return the maxLevels
     */
    public int getMaxLevels();

    /**
     * Sets the maxLevels by reading the Database
     */
    public void setMaxLevels();

    /**
     * Gets the score
     *
     * @return the score
     */
    public IScore getScore();
}
