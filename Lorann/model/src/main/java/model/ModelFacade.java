/*
 *
 */
package model;

import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

import enums.DirectionEnum;
import enums.TypeEnum;
import model.dao.QueryDAO;
import model.factories.UnitFactory;
import modelInterfaces.IEntity;
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
	private IUnit unit;

	/**
	 * Instantiates a new model facade.
	 */
	public ModelFacade() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see modelInterfaces.IModel#addToScore(int)
	 */
	@Override
	public void addToScore(final int value) {
		this.getUnit().setScoreValue(this.getUnit().getScoreValue() + value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see modelInterfaces.IModel#getLevel()
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see modelInterfaces.IModel#getScore()
	 */
	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return this.getUnit().getScoreValue();
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
	 * Gets the unit
	 *
	 * @return the unit
	 */
	public IUnit getUnit() {
		return this.unit;
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
	private String getUnitByPosition(final int x, final int y, final int mapId) throws SQLException {
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
	private ArrayList<IVector> getUnitByType(final TypeEnum type, final int mapId) throws SQLException {
		return QueryDAO.getUnitByType(type, mapId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see modelInterfaces.IModel#loadLevel(int)
	 */
	@Override
	public void loadLevel(final int levelId) throws SQLException {
		final HashMap<String, IVector> resultMap = QueryDAO.getUnitByMap(levelId);
		final ILevel level = new Level(levelId, QueryDAO.getMap(levelId));

		String key;
		IVector vector;
		IEntity entity;

		for (final HashMap.Entry<String, IVector> result : resultMap.entrySet()) {
			key = result.getKey();
			vector = result.getValue();
			switch (key) {
			case "WALL":
				level.addUnit(UnitFactory.createWall(), vector.getX(), vector.getY());
				break;
			case "WALL_H":
				level.addUnit(UnitFactory.createWall(), vector.getX(), vector.getY());
				break;
			case "WALL_V":
				level.addUnit(UnitFactory.createWall(), vector.getX(), vector.getY());
				break;
			default:
				entity = UnitFactory.createEntity(TypeEnum.valueOf(key), QueryDAO.getSpritePath(TypeEnum.valueOf(key)));
				entity.setPosition(vector);
				level.addEntity(entity);
				break;
			}
		}
		this.setLevel(level);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see modelInterfaces.IModel#resetScore()
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see modelInterfaces.IModel#setPlayerDirection(enums.DirectionEnum)
	 */
	@Override
	public void setPlayerDirection(final DirectionEnum direction) {

	}

	/**
	 * @param unit
	 *            the unit to set
	 */
	public void setUnit(final IUnit unit) {
		this.unit = unit;
	}
}
