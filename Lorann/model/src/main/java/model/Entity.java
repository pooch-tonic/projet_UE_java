/*
 *
 */
package model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import enums.DirectionEnum;
import enums.Type;
import modelInterfaces.IEntity;
import showboard.ISpriteSet;
import vector.IVector;

/**
 * @author Max Becerro
 *
 */
public abstract class Entity extends Unit implements IEntity {

    private IVector direction;

    /**
     * Instantiates a new Entity
     *
     */
    public Entity() {
        super();
    }

    /**
     * Instantiates a new Entity
     *
     * @param position
     * @param spriteSet
     * @param type
     */
    public Entity(final IVector position, final ISpriteSet spriteSet, final Type type) {
        super(position, spriteSet, type);
    }

    /**
     * Instantiates a new Entity
     *
     * @param position
     * @param type
     */
    public Entity(final IVector position, final Type type) {
        super(position, type);
    }

    /**
     * Instantiates a new Entity
     *
     * @param type
     */
    public Entity(final Type type) {
        super(type);
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
    }

    @Override
    /**
     * @return a direction
     */
    public IVector getDirection() {
        // TODO Auto-generated method stub
        return this.direction;
    }

    @Override
    /**
     * @return a position
     */
    public IVector getPosition() {
        // TODO Auto-generated method stub
        return super.getPosition();
    }

    @Override
    /**
     * @return a spriteSet
     */
    public ISpriteSet getSpriteSet() {
        // TODO Auto-generated method stub
        return super.getSpriteSet();
    }

    @Override
    /**
     * @return a type
     */
    public Type getType() {
        // TODO Auto-generated method stub
        return super.getType();
    }

    @Override
    public void move(final DirectionEnum direction) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setDirection(final IVector direction) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setPosition(final IVector position) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setSpriteSet(final ArrayList<BufferedImage> sprites) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setType(final Type type) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update() {

    }

}
