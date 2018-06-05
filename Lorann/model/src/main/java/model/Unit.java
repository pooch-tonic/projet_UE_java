/*
 *
 */
package model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import enums.UnitTypeEnum;
import modelinterfaces.IUnit;
import showboard.ISpriteSet;
import vector.IVector;
import vector.Vector;

/**
 * <h1>The Unit class, which is the base class for all objects contained by the
 * map.</h1>
 *
 * @author Max Becerro
 * @author Ryo SHIINA
 *
 */
public class Unit implements IUnit {
    final static int SIZE = 32;

    /**
     * @return the size of the unit, also applies to the sprite size.
     */
    public static int getSize() {
        return SIZE;
    }

    private IVector    position;
    private ISpriteSet spriteSet;

    private UnitTypeEnum type;

    /**
     * Instantiates a new Unit
     *
     * @param spriteSet
     * @param type
     */
    public Unit(final ISpriteSet spriteSet, final UnitTypeEnum type) {
        this.setPosition(null);
        this.spriteSet = new SpriteSet();
        this.setSpriteSet(spriteSet);
        this.setType(type);
    }

    /**
     * Instantiates a new Unit
     *
     * @param position
     * @param spriteSet
     * @param type
     */
    public Unit(final IVector position, final ISpriteSet spriteSet, final UnitTypeEnum type) {
        this.setPosition(position);
        this.setSpriteSet(spriteSet);
        this.setType(type);
    }

    /**
     * Instantiates a new Unit
     *
     * @param position
     * @param type
     */
    public Unit(final IVector position, final UnitTypeEnum type) {
        this.spriteSet = new SpriteSet();
        this.setPosition(position);
        this.setSpriteSet(new ArrayList<BufferedImage>());
        this.setType(type);
    }

    /**
     * Instantiates a new Unit
     *
     * @param type
     */
    public Unit(final UnitTypeEnum type) {
        this.spriteSet = new SpriteSet();
        this.setPosition(new Vector(0, 0));
        this.setSpriteSet(new ArrayList<BufferedImage>());
        this.setType(type);
    }

    /**
     * Instantiates a new Unit
     *
     * @param type
     * @param spriteSet
     *
     */
    public Unit(final UnitTypeEnum type, final ISpriteSet spriteSet) {
        this.spriteSet = spriteSet;
        this.setPosition(null);
        this.setType(type);
    }

    /* (non-Javadoc)
     * @see showboard.ISquare#getImage()
     */
    @Override
    public Image getImage() {
        return this.getSpriteSet().getCurrentSprite();
    }

    /* (non-Javadoc)
     * @see modelinterfaces.IUnit#getPosition()
     */
    @Override
    public IVector getPosition() {
        return this.position;
    }

    /* (non-Javadoc)
     * @see modelinterfaces.IUnit#getSpriteSet()
     */
    @Override
    public ISpriteSet getSpriteSet() {
        return this.spriteSet;
    }

    /* (non-Javadoc)
     * @see modelinterfaces.IUnit#getType()
     */
    @Override
    public UnitTypeEnum getType() {
        return this.type;
    }

    /* (non-Javadoc)
     * @see modelinterfaces.IUnit#setPosition(vector.IVector)
     */
    @Override
    public void setPosition(final IVector position) {
        this.position = position;
    }

    /* (non-Javadoc)
     * @see modelinterfaces.IUnit#setSpriteSet(java.util.ArrayList)
     */
    @Override
    public void setSpriteSet(final ArrayList<BufferedImage> sprites) {
        this.spriteSet.setSprites(sprites);
    }

    /* (non-Javadoc)
     * @see modelinterfaces.IUnit#setSpriteSet(java.awt.image.BufferedImage)
     */
    @Override
    public void setSpriteSet(final BufferedImage image) {
        this.getSpriteSet().setSprites(image);
    }

    /* (non-Javadoc)
     * @see modelinterfaces.IUnit#setSpriteSet(showboard.ISpriteSet)
     */
    @Override
    public void setSpriteSet(final ISpriteSet spriteSet) {
        this.spriteSet = spriteSet;
    }

    /* (non-Javadoc)
     * @see modelinterfaces.IUnit#setType(enums.UnitTypeEnum)
     */
    @Override
    public void setType(final UnitTypeEnum type) {
        this.type = type;
    }
}
