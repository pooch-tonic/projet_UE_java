/*
 *
 */
package model;

import java.awt.Dimension;
import java.util.ArrayList;

import modelInterfaces.IEntity;
import modelInterfaces.ILevel;
import modelInterfaces.IUnit;
import vector.IVector;

/**
 * @author Max Becerro
 *
 */
public class Level implements ILevel {
    private IUnit[][]          units;
    private ArrayList<IEntity> entities;
    private Dimension          dimension;
    private int                id;

    @Override
    public void addEntity(final IEntity entity) {
        this.getEntities().add(entity);
    }

    @Override
    public void addUnit(final IUnit unit, final int x, final int y) {
        this.getUnits()[x][y] = unit;
    }

    /**
     *
     * @return the dimension of the map, with x as rows and y as columns
     */
    @Override
    public Dimension getDimension() {
        return this.dimension;
    }

    /**
     * Gets the id
     *
     * @return the id
     */
    @Override
    public int getId() {
        return this.id;
    }

    /**
     *
     * @return the current level map, contained in a 2D array of ISquare.
     */
    @Override
    public IUnit[][] getUnits() {
        return this.units;
    }

    /**
     * @param dimension
     */
    @Override
    public void setDimension(final Dimension dimension) {
        this.dimension = dimension;
    }

    /**
     * @param id
     *            the id to set
     */
    @Override
    public void setId(final int id) {
        this.id = id;
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
     * @see modelInterfaces.ILevel#getEntities()
     */
    @Override
    public ArrayList<IEntity> getEntities() {
        // TODO Auto-generated method stub
        return this.entities;
    }

    /*
     * (non-Javadoc)
     *
     * @see modelInterfaces.ILevel#getEntityOn(vector.IVector)
     */
    @Override
    public IEntity getEntityOn(final IVector position) {
        for (final IEntity entity : this.getEntities()) {
            if (entity.getPosition().isEqual(position)) {
                return entity;
            }
        }
        return null;
    }
}