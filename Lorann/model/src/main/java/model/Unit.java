/*
 *
 */
package model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import enums.Type;
import modelInterfaces.IUnit;
import showboard.ISpriteSet;
import vector.IVector;
import vector.Vector;

/**
 * @author Max Becerro
 *
 */
public class Unit implements IUnit {
    private IVector    position;
    private ISpriteSet spriteSet;
    private Type       type;
    private int        scoreValue;

    /**
     * Instantiates a new Unit
     *
     */
    public Unit() {

    }

    /**
     * Instantiates a new Unit
     *
     * @param position
     * @param spriteSet
     * @param type
     */
    public Unit(final IVector position, final ISpriteSet spriteSet, final Type type) {
        this.setPosition(position);
        this.setSpriteSet(spriteSet);
        this.setType(type);
        this.setScoreValue(0);
    }

    /**
     * Instantiates a new Unit
     *
     * @param position
     * @param type
     */
    public Unit(final IVector position, final Type type) {
        this.setPosition(position);
        this.setType(type);
        this.setScoreValue(0);
    }

    /**
     * Instantiates a new Unit
     *
     * @param type
     */
    public Unit(final Type type) {
        this.setPosition(new Vector(0, 0));
        this.setType(type);
        this.setScoreValue(0);
    }

    @Override
    public IVector getPosition() {
        return this.position;
    }

    /**
     * Gets the scoreValue
     *
     * @return the scoreValue
     */
    public int getScoreValue() {
        return this.scoreValue;
    }

    @Override
    public ISpriteSet getSpriteSet() {
        return this.spriteSet;
    }

    @Override
    public Type getType() {
        return this.type;
    }

    @Override
    public void setPosition(final IVector position) {
        this.position = position;
    }

    public void setScoreValue(final int scoreValue) {
        this.scoreValue = scoreValue;
    }

    @Override
    public void setSpriteSet(final ArrayList<BufferedImage> sprites) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setSpriteSet(final ISpriteSet spriteSet) {
        this.spriteSet = spriteSet;
    }

    @Override
    public void setType(final Type type) {
        this.type = type;
    }

    @Override
    public Image getImage() {
        // TODO Auto-generated method stub
        return null;
    }
}
