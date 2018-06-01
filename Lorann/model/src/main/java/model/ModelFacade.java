package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;

import model.dao.QueryDAO;
import modelInterfaces.ILevel;
import modelInterfaces.IModel;
import showboard.TypeEnum;

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

    /*
     * (non-Javadoc)
     *
     * @see model.IModel#getUnitByType(TypeEnum, int)
     */
   

    /**
	 * @param level the level to set
	 */
	private void setLevel(ILevel level) {
		this.level = level;
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
	public void addToScoreValue(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadLevel(int levelId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultSet getUnitByType(TypeEnum type, int mapId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet getUnitByPosition(int x, int y, int mapId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet getUnitByMap(int mapId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet getSpritePath(TypeEnum type) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet getMap(int mapId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
