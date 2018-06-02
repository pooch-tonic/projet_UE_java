/*
 *
 */
package model;

import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

import enums.DirectionsEnum;
import model.dao.QueryDAO;
import model.dao.TypeEnum;
import modelInterfaces.ILevel;
import modelInterfaces.IModel;
import modelInterfaces.IUnit;
import vector.IVector;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public final class ModelFacade extends Observable implements IModel {
    private ILevel level;

    /**
     * Instantiates a new model facade.
     */
    public ModelFacade() {
        super();
    }

    @Override
    public void addToScore(final int value) {
        // TODO Auto-generated method stub

    }

    @Override
    public ILevel getLevel() {
        // TODO Auto-generated method stub
        return this.level;
    }

    /*
     * (non-Javadoc)
     *
     * @see model.IModel#getMap(int)
     */
    @Override
    public Dimension getMap(final int mapId) throws SQLException {
        return QueryDAO.getMap(mapId);
    }

    @Override
    public int getScore() {
        // TODO Auto-generated method stub
        return 0;
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
    private ArrayList<String> getSpritePath(final TypeEnum type) throws SQLException {
        final ArrayList<String> result = QueryDAO.getSpritePath(type);
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
    public HashMap<String, IVector> getUnitByMap(final int mapId) throws SQLException {
        final HashMap<String, IVector> result = QueryDAO.getUnitByMap(mapId);
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
    private String getUnitByPosition(final int x, final int y, final int mapId)
            throws SQLException {
        return QueryDAO.getUnitByPosition(x, y, mapId);
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
    private ArrayList<IVector> getUnitByType(final TypeEnum type, final int mapId)
            throws SQLException {
        return QueryDAO.getUnitByType(type, mapId);
    }

    @Override
    public void loadLevel(final int levelId) throws SQLException {
    	final HashMap<String, IVector> resultMap = QueryDAO.getUnitByMap(levelId);
    	
    	
    	
    	ILevel level = new Level();
    	level.setDimension(QueryDAO.getMap(levelId));
        this.setLevel(this.level);
    }

    @Override
    public void resetScore() {
        // TODO Auto-generated method stub
        this.setChanged();
        this.notifyObservers();
    }

    /**
     * @param level
     *            the level to set
     */
    private void setLevel(final ILevel level) {
        this.level = level;
    }

    @Override
    public void setPlayerDirection(final DirectionsEnum direction) {

    }
}
