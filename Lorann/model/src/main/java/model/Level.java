/*
 *
 */
package model;

import java.awt.Dimension;
import java.util.ArrayList;

import modelinterfaces.IEntity;
import modelinterfaces.ILevel;
import modelinterfaces.IUnit;
import vector.IVector;

/**
 * <h1>The Level class.</h1> Stores the game units.
 *
 * @author Ryo SHIINA
 *
 */
public class Level implements ILevel {
    private IUnit[][]          units;
    private ArrayList<IEntity> entities;
    private Dimension          dimension;
    private int                id;
    private IEntity            exit;
    private IEntity            player;
    private IEntity            spell;

    /**
     * Instantiates a new Level
     *
     * @param id
     * @param dimension
     */
    public Level(final int id, final Dimension dimension) {
        final Double width = dimension.getWidth();
        final Double height = dimension.getHeight();

        this.setId(id);
        this.setUnits(new IUnit[width.intValue()][height.intValue()]);
        this.setEntities(new ArrayList<>());
    }

    /*
     * (non-Javadoc)
     *
     * @see modelInterfaces.ILevel#addEntity(modelInterfaces.IEntity)
     */
    @Override
    public void addEntity(final IEntity entity) {
        this.getEntities().add(entity);
    }

    /*
     * (non-Javadoc)
     *
     * @see modelInterfaces.ILevel#addUnit(modelInterfaces.IUnit, int, int)
     */
    @Override
    public void addUnit(final IUnit unit, final int x, final int y) {
        this.getUnits()[x][y] = unit;
    }

    /*
     * (non-Javadoc)
     *
     * @see modelInterfaces.ILevel#getDimension()
     */
    @Override
    public Dimension getDimension() {
        return this.dimension;
    }

    /*
     * (non-Javadoc)
     *
     * @see modelInterfaces.ILevel#getEntities()
     */
    @Override
    public ArrayList<IEntity> getEntities() {
        return this.entities;
    }

    /*
     * (non-Javadoc)
     *
     * @see modelInterfaces.ILevel#getEntityOn(vector.IVector)
     */
    @Override
    public IEntity getEntityOn(final IVector position) {
        IEntity result = null;
        for (final IEntity entity : this.getEntities()) {
            if (entity.getPosition().isEqual(position)) {
                result = entity;
            }
        }
        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see modelInterfaces.ILevel#getExit()
     */
    @Override
    public IEntity getExit() {
        return this.exit;
    }

    /*
     * (non-Javadoc)
     *
     * @see modelInterfaces.ILevel#getId()
     */
    @Override
    public int getId() {
        return this.id;
    }

    /*
     * (non-Javadoc)
     *
     * @see modelInterfaces.ILevel#getPlayer()
     */
    @Override
    public IEntity getPlayer() {
        return this.player;
    }

    /*
     * (non-Javadoc)
     *
     * @see modelInterfaces.ILevel#getUnits()
     */
    @Override
    public IUnit[][] getUnits() {
        return this.units;
    }

    /*
     * (non-Javadoc)
     *
     * @see modelInterfaces.ILevel#removeEntityFromLevel(modelInterfaces.IEntity)
     */
    @Override
    public void removeEntityFromLevel(final IEntity entity) {
        this.getEntities().remove(entity);
    }

    /*
     * (non-Javadoc)
     *
     * @see modelInterfaces.ILevel#setDimension(java.awt.Dimension)
     */
    @Override
    public void setDimension(final Dimension dimension) {
        this.dimension = dimension;
    }

    /**
     * Sets the entities
     *
     * @param entities
     */
    private void setEntities(final ArrayList<IEntity> entities) {
        this.entities = entities;
    }

    /*
     * (non-Javadoc)
     *
     * @see modelInterfaces.ILevel#setExit(modelInterfaces.IEntity)
     */
    @Override
    public void setExit(final IEntity exit) {
        this.exit = exit;
    }

    /*
     * (non-Javadoc)
     *
     * @see modelInterfaces.ILevel#setId(int)
     */
    @Override
    public void setId(final int id) {
        this.id = id;
    }

    /*
     * (non-Javadoc)
     *
     * @see modelInterfaces.ILevel#setPlayer(modelInterfaces.IEntity)
     */
    @Override
    public void setPlayer(final IEntity player) {
        this.player = player;
    }

    /*
     * (non-Javadoc)
     *
     * @see modelInterfaces.ILevel#setUnits(modelInterfaces.IUnit[][])
     */
    @Override
    public void setUnits(final IUnit[][] units) {
        this.units = units;
    }

    /*
     * (non-Javadoc)
     *
     * @see modelInterfaces.ILevel#getEntityOverlapping(modelInterfaces.IEntity)
     */
    @Override
    public IEntity getEntityOverlapping(final IEntity entity) {
        IEntity result = null;
        for (final IEntity entityStudied : this.getEntities()) {
            if (entity.getPosition().isEqual(entityStudied.getPosition())
                    && (entity != entityStudied)) {
                result = entityStudied;
            }
        }
        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see modelInterfaces.ILevel#getUnitOn(int, int)
     */
    @Override
    public IUnit getUnitOn(final int x, final int y) {
        return this.getUnits()[x][y];
    }

    /*
     * (non-Javadoc)
     *
     * @see modelInterfaces.ILevel#getSpell()
     */
    @Override
    public IEntity getSpell() {
        return this.spell;
    }

    /*
     * (non-Javadoc)
     *
     * @see modelInterfaces.ILevel#setSpell(modelInterfaces.IEntity)
     */
    @Override
    public void setSpell(final IEntity spell) {
        this.spell = spell;
    }

    /*
     * (non-Javadoc)
     *
     * @see modelInterfaces.ILevel#addEntity(int, modelInterfaces.IEntity)
     */
    @Override
    public void addEntity(final int index, final IEntity entity) {
        this.getEntities().add(index, entity);

    }
}