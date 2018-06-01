package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;

import enums.TypeEnum;
import model.dao.QueryDAO;
import modelInterfaces.ILevel;
import modelInterfaces.IModel;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public final class ModelFacade extends Observable implements IModel {

    /**
     * Instantiates a new model facade.
     */
    public ModelFacade() {
        super();
    }

    /*
     * (non-Javadoc)
     *
     * @see model.IModel#getUnitByType(TypeEnum, int)
     */
    @Override
    public ResultSet getUnitByType(TypeEnum type, int mapId) throws SQLException {
        return QueryDAO.getUnitByType(type, mapId);
    }

    /*
     * (non-Javadoc)
     *
     * @see model.IModel#getUnitByPosition(int, int, int)
     */
    @Override
    public ResultSet getUnitByPosition(int x, int y, int mapId) throws SQLException {
        return QueryDAO.getUnitByPosition(x, y, mapId);
    }

    /*
     * (non-Javadoc)
     *
     * @see model.IModel#getUnitByMap(int)
     */
    @Override
    public ResultSet getUnitByMap(int mapId) throws SQLException {
        return QueryDAO.getUnitByMap(mapId);
    }
    
    /*
     * (non-Javadoc)
     *
     * @see model.IModel#getSpritePath(TypeEnum)
     */
    @Override
    public ResultSet getSpritePath(TypeEnum type) throws SQLException {
        return QueryDAO.getSpritePath(type);
    }
    
    /*
     * (non-Javadoc)
     *
     * @see model.IModel#getMap(int)
     */
    @Override
    public ResultSet getMap(int mapId) throws SQLException {
        return QueryDAO.getMap(mapId);
    }

    @Override
    public ILevel getLevel() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getScoreValue() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void addToScoreValue(final int value) {
        // TODO Auto-generated method stub

    }

    @Override
    public void reset() {
        // TODO Auto-generated method stub

    }
}
