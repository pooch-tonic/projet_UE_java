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

import enums.AllUnitEnum;
import enums.DirectionEnum;
import model.behaviorstrategy.BounceTowardsPlayerLikeSpell;
import model.behaviorstrategy.DoNotMove;
import model.dao.QueryDAO;
import model.factories.UnitFactory;
import model.factories.VectorFactory;
import modelinterfaces.IEntity;
import modelinterfaces.ILevel;
import modelinterfaces.IModel;
import modelinterfaces.IScore;
import modelinterfaces.IUnit;
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
    public IEntity addEntityToLevel(final AllUnitEnum type, final IVector position) {
        final IEntity entity = UnitFactory.createEntity(type, new ArrayList<>());
        this.getLevel().addEntity(0, entity);
        entity.setPosition(position);

        if (type == AllUnitEnum.SPELL) {
            final IEntity player = this.getPlayer();
            final IVector spellDirection = new Vector(player.getLastDirection());
            spellDirection.invert();
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
                            UnitFactory.createWall(WallTypeEnum.WALL_ROUND,
                                    QueryDAO.getSpritePath(AllUnitEnum.valueOf(key)).get(0)),
                            vector.getX(), vector.getY());
                    break;
                case "WALL_H":
                    level.addUnit(
                            UnitFactory.createWall(WallTypeEnum.WALL_HORIZONTAL,
                                    QueryDAO.getSpritePath(AllUnitEnum.valueOf(key)).get(0)),
                            vector.getX(), vector.getY());
                    break;
                case "WALL_V":
                    level.addUnit(
                            UnitFactory.createWall(WallTypeEnum.WALL_VERTICAL,
                                    QueryDAO.getSpritePath(AllUnitEnum.valueOf(key)).get(0)),
                            vector.getX(), vector.getY());
                    break;
                default:
                    entity = UnitFactory.createEntity(AllUnitEnum.valueOf(key),
                            QueryDAO.getSpritePath(AllUnitEnum.valueOf(key)));
                    entity.setPosition(vector);
                    level.addEntity(entity);
                    if (AllUnitEnum.valueOf(key) == AllUnitEnum.PLAYER) {
                        this.getLevel().setPlayer(entity);
                    } else if (AllUnitEnum.valueOf(key) == AllUnitEnum.DOOR) {
                        this.getLevel().setExit(entity);
                    }
                    break;
                }
            }
        }
        UnitFactory.setSpellSpriteSet(QueryDAO.getSpritePath(AllUnitEnum.SPELL));
        UnitFactory.setDeadSpriteSet(QueryDAO.getSpritePath(AllUnitEnum.DEAD));
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
