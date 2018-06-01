package model;

import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

import enums.TypeEnum;
import model.dao.QueryDAO;
import modelInterfaces.ILevel;
import modelInterfaces.IModel;
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
	public void addToScoreValue(final int value) {
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
	public int getScoreValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.IModel#getSpritePath(TypeEnum)
	 */
	@Override
	public ArrayList<String> getSpritePath(final TypeEnum type) throws SQLException {
		ArrayList<String> result = QueryDAO.getSpritePath(type);
		return result;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.IModel#getUnitByMap(int)
	 */
	@Override
	public HashMap<String, IVector> getUnitByMap(final int mapId) throws SQLException {
		HashMap<String, IVector> result = QueryDAO.getUnitByMap(mapId);
		return result;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.IModel#getUnitByPosition(int, int, int)
	 */
	@Override
	public String getUnitByPosition(final int x, final int y, final int mapId) throws SQLException {
		return QueryDAO.getUnitByPosition(x, y, mapId);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.IModel#getUnitByType(TypeEnum, int)
	 */
	@Override
	public ArrayList<IVector> getUnitByType(final TypeEnum type, final int mapId) throws SQLException {
		return QueryDAO.getUnitByType(type, mapId);
	}

	@Override
	public void loadLevel(final int levelId) {
		this.setLevel(this.level);
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub

	}

	/**
	 * @param level
	 *            the level to set
	 */
	private void setLevel(final ILevel level) {
		this.level = level;
	}
}
