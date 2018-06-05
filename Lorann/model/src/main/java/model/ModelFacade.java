/*
 *
 */
package model;

import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Observable;

import enums.DirectionEnum;
import enums.TypeEnum;
import model.behaviorStrategy.BounceTowardsPlayerLikeSpell;
import model.behaviorStrategy.DoNotMove;
import model.dao.QueryDAO;
import model.factories.UnitFactory;
import model.factories.VectorFactory;
import modelInterfaces.IEntity;
import modelInterfaces.ILevel;
import modelInterfaces.IModel;
import modelInterfaces.IScore;
import modelInterfaces.IUnit;
import vector.IVector;
import vector.Vector;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public final class ModelFacade extends Observable implements IModel {

	private ILevel level;

	private int maxLevels;

	private IScore score;

	/**
	 * Instantiates a new model facade.
	 */
	public ModelFacade(final Dimension dimension) {
		super();
		// Creates a ground-only level
		this.level = new Level(0, dimension);
		this.fillVoidSquares();
		this.setScore(new Score());
	}

	@Override
	public IEntity addEntityToLevel(final TypeEnum type) {
		final IEntity entity = UnitFactory.createEntity(type, new ArrayList<>());
		this.getLevel().addEntity(0, entity);

		if (type == TypeEnum.SPELL) {
			final IEntity player = this.getPlayer();
			final IVector spellDirection = new Vector(player.getLastDirection());
			spellDirection.invert();
			entity.setPosition(player.getPosition().getAddResult(spellDirection));
			entity.setDirection(spellDirection);
			this.getLevel().setSpell(entity);
		}

		return entity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see modelInterfaces.IModel#addToScore(int)
	 */
	@Override
	public void addToScore(final int value) {
		this.getScore().addToScoreValue(value);
	}

	@Override
	public void destroyEntity(final IEntity entity) {
		this.addToScore(entity.getScoreValue());
		this.getLevel().removeEntityFromLevel(entity);
	}

	private void fillVoidSquares() {
		final IUnit[][] units = this.getLevel().getUnits();

		// TODO vérifier que x et y ne sont jamais inversés.
		for (int x = 0; x < units.length; x++) {
			for (int y = 0; y < units[0].length; y++) {
				if (units[x][y] == null) {
					this.getLevel().addUnit(new Ground(), x, y);
				}
			}
		}
	}

	@Override
	public IEntity getExit() {
		return this.getLevel().getExit();
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
	 * @see modelInterfaces.IModel#getMaxLevels()
	 */
	@Override
	public int getMaxLevels() {
		return this.maxLevels;
	}

	@Override
	public IEntity getPlayer() {
		return this.getLevel().getPlayer();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see modelInterfaces.IModel#getScore()
	 */
	@Override
	public IScore getScore() {
		return this.score;
	}

	@Override
	public IEntity getSpell() {
		return this.getLevel().getSpell();
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
	public HashMap<String, ArrayList<IVector>> getUnitByMap(final int mapId) throws SQLException {
		final HashMap<String, ArrayList<IVector>> result = QueryDAO.getUnitByMap(mapId);
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

	@Override
	public IUnit getUnitOn(final int x, final int y) {
		return this.getLevel().getUnitOn(x, y);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see modelInterfaces.IModel#loadLevel(int)
	 */
	@Override
	public void loadLevel(final int levelId) throws SQLException {
		final HashMap<String, ArrayList<IVector>> resultMap = QueryDAO.getUnitByMap(levelId);

		final ILevel level = new Level(levelId, QueryDAO.getMap(levelId));
		this.setLevel(level);

		String key;
		ArrayList<IVector> position;
		IEntity entity;

		for (final Entry<String, ArrayList<IVector>> result : resultMap.entrySet()) {
			key = result.getKey();
			position = result.getValue();

			for (final IVector vector : position) {
				switch (key) {
				case "WALL":
					level.addUnit(
							UnitFactory.createWall(WallType.WALL_ROUND,
									QueryDAO.getSpritePath(TypeEnum.valueOf(key)).get(0)),
							vector.getX(), vector.getY());
					break;
				case "WALL_H":
					level.addUnit(
							UnitFactory.createWall(WallType.WALL_HORIZONTAL,
									QueryDAO.getSpritePath(TypeEnum.valueOf(key)).get(0)),
							vector.getX(), vector.getY());
					break;
				case "WALL_V":
					level.addUnit(
							UnitFactory.createWall(WallType.WALL_VERTICAL,
									QueryDAO.getSpritePath(TypeEnum.valueOf(key)).get(0)),
							vector.getX(), vector.getY());
					break;
				default:
					entity = UnitFactory.createEntity(TypeEnum.valueOf(key),
							QueryDAO.getSpritePath(TypeEnum.valueOf(key)));
					entity.setPosition(vector);
					level.addEntity(entity);
					if (TypeEnum.valueOf(key) == TypeEnum.PLAYER) {
						this.getLevel().setPlayer(entity);
					} else if (TypeEnum.valueOf(key) == TypeEnum.DOOR) {
						this.getLevel().setExit(entity);
					}
					break;
				}
			}
		}
		UnitFactory.setSpellSpriteSet(QueryDAO.getSpritePath(TypeEnum.SPELL));
		UnitFactory.setDeadSpriteSet(QueryDAO.getSpritePath(TypeEnum.DEAD));
		this.removeEntityFromLevel(this.getPlayer());
		this.addEntityToLevel(this.getPlayer());
		this.fillVoidSquares();
		this.update();

		for (final IEntity test : this.getLevel().getEntities()) {
			test.bounce(this.getLevel());
		}

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see modelInterfaces.IModel#resetScore()
	 */
	@Override
	public void resetScore() {
		this.getScore().resetScoreValue();
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
	 * @see modelInterfaces.IModel#setMaxLevels(int)
	 */
	@Override
	public void setMaxLevels() {
		try {
			this.maxLevels = QueryDAO.getMapNumber();
		} catch (final SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void setPlayer(final IEntity player) {
		this.getLevel().setPlayer(player);

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see modelInterfaces.IModel#setPlayerDirection(enums.DirectionEnum)
	 */
	@Override
	public void setPlayerDirection(final DirectionEnum direction) {
		final IVector directionVector = VectorFactory.getVectorForDirection(direction);
		this.getPlayer().setDirection(directionVector);
		if (!directionVector.isEqual(0, 0)) {
			// TODO BRICOLAGE DU DIMANCHE DESOLE AURE
			this.getPlayer().setLastDirection(directionVector);
		}
	}

	@Override
	public void setPlayerSpriteSetToIndex(final int index) {
		this.getPlayer().getSpriteSet().setCurrentIndex(index);
	}

	/**
	 * Sets the score
	 *
	 * @param score
	 */
	private void setScore(final Score score) {
		this.score = score;
	}

	@Override
	public void setSpell(final IEntity spell) {
		this.getLevel().setSpell(spell);
	}

	@Override
	public void update() {
		this.setChanged();
		this.notifyObservers();
	}

	@Override
	public void removeEntityFromLevel(final IEntity entity) {
		this.getLevel().removeEntityFromLevel(entity);
	}

	@Override
	public void addEntityToLevel(final IEntity entity) {
		this.getLevel().addEntity(entity);
	}

	@Override
	public void doNotMoveEntity(final IEntity entity) {
		entity.setMoveStrategy(new DoNotMove());
	}

	@Override
	public void callSpell() {
		this.getSpell().setBounceStrategy(new BounceTowardsPlayerLikeSpell());
	}
}
