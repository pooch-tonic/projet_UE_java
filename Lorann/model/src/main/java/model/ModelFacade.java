package model;

import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

import model.dao.QueryDAO;
import modelInterfaces.ILevel;
import modelInterfaces.IModel;
import showboard.IPawn;
import showboard.ISquare;
import showboard.TypeEnum;
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
	public ArrayList<IPawn> getEntitiesFromLevel() {
		return this.getLevel().getEntities();
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

	@Override
	public ISquare[][] getSquaresFromLevel() {
		return this.getLevel().getSquares();
	}

	@Override
	public void loadLevel(final int levelId) {
		this.setLevel(this.level);
	}

	@Override
	public void loadLevelById(final int levelId) {
		this.setLevel(this.level);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.IModel#getSpritePath(TypeEnum)
	 */
	@Override
	public ArrayList<String> loadSpritePath(final TypeEnum type) throws SQLException {
		ArrayList<String> result = QueryDAO.getSpritePath(type);
		return result;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.IModel#getUnitByPosition(int, int, int)
	 */
	@Override
	public String loadUnitByPosition(final int x, final int y, final int mapId) throws SQLException {
		return QueryDAO.getUnitByPosition(x, y, mapId);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.IModel#getUnitByMap(int)
	 */
	@Override
	public HashMap<String, IVector> loadUnitsByMap(final int mapId) throws SQLException {
		HashMap<String, IVector> result = QueryDAO.getUnitByMap(mapId);
		return result;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.IModel#getUnitByType(TypeEnum, int)
	 */
	@Override
	public ArrayList<IVector> loadUnitsByType(final TypeEnum type, final int mapId) throws SQLException {
		return QueryDAO.getUnitByType(type, mapId);
	}

	@Override
	public void resetScore() {
	}

	/**
	 * @param level
	 *            the level to set
	 */
	private void setLevel(final ILevel level) {
		this.level = level;
	}
}
