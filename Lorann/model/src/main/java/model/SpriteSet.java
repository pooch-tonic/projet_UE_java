/*
 * 
 */
package model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import showboard.ISpriteSet;

/**
 * <h1>The SpriteSet class.</h1> Allows the units to store their sprites as a
 * set.
 *
 * @author Max Becerro
 * @author Ryo SHIINA
 *
 */

public class SpriteSet implements ISpriteSet {

    private ArrayList<BufferedImage> sprites;
    private int                      currentIndex;
    private int                      maxIndex;
    private int                      nSprites;

    /**
     * the default constructor
     */
    public SpriteSet() {
        this.setSprites(new ArrayList<BufferedImage>());
        this.getSprites().add(new BufferedImage(1, 1, 1));
        this.configure();
    }

    /**
     * the constructor for a BufferedImage ArrayList
     *
     * @param sprites
     */
    public SpriteSet(final ArrayList<BufferedImage> sprites) {
        this.setSprites(sprites);
        this.configure();
    }

    /**
     * the constructor for a single image SpriteSet
     *
     * @param image
     */
    public SpriteSet(final BufferedImage image) {
        this.setSprites(new ArrayList<BufferedImage>());
        this.getSprites().add(image);
        this.configure();
    }

    /**
     * configures the maxIndex and nSprites values to fit the SpriteSet ArrayList.
     */
    private void configure() {
        this.setCurrentIndex(0);
        this.setnSprites(this.getSprites().size());
        this.setMaxIndex(this.getnSprites() - 1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see showboard.ISpriteSet#getCurrentIndex()
     */
    @Override
    public int getCurrentIndex() {
        return this.currentIndex;
    }

    /**
     * returns the sprite according to the current animation index, calls
     * getSpriteByIndex() method.
     *
     * @return the sprite of index currentIndex. Null if ArrayList is empty.
     * @see showboard.ISpriteSet#getCurrentSprite()
     */
    @Override
    public BufferedImage getCurrentSprite() {
        return this.getSpriteByIndex(this.getCurrentIndex());
    }

    /**
     * @return the maximal value of the animation index, to prevent a
     *         NullPointerException
     * @see showboard.ISpriteSet#getMaxIndex()
     */
    @Override
    public int getMaxIndex() {
        return this.maxIndex;
    }

    /**
     * @return the actual amount of sprites
     */
    public int getnSprites() {
        return this.nSprites;
    }

    /**
     * returns the sprite according to its index ; putting a higher value than the
     * maxIndex will return the first sprite of the ArrayList
     *
     * @param index
     * @return a sprite for the given index, null if ArrayList is empty.
     * @see showboard.ISpriteSet#getSpriteByIndex(int)
     */
    @Override
    public BufferedImage getSpriteByIndex(final int index) {
        if (!this.getSprites().isEmpty()) {
            return this.getSprites().get(index);
        } else {
            return null;
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see showboard.ISpriteSet#getSprites()
     */
    @Override
    public ArrayList<BufferedImage> getSprites() {
        return this.sprites;
    }

    /*
     * (non-Javadoc)
     *
     * @see showboard.ISpriteSet#resetIndex()
     */
    @Override
    public void resetIndex() {
        this.setCurrentIndex(0);
    }

    /**
     * @param currentIndex
     * @see showboard.ISpriteSet#setCurrentIndex(int)
     */
    @Override
    public void setCurrentIndex(final int currentIndex) {
        if ((currentIndex <= this.maxIndex) && (currentIndex >= 0)) {
            this.currentIndex = currentIndex;
        } else {
            this.currentIndex = 0;
        }

    }

    /**
     * sets the maximum index of the ArrayList.
     *
     * @param maxIndex
     */
    private void setMaxIndex(final int maxIndex) {
        this.maxIndex = maxIndex;
    }

    /*
     * (non-Javadoc)
     * 
     * @see showboard.ISpriteSet#setNextSprite()
     */
    @Override
    public void setNextSprite() {
        this.setCurrentIndex((this.currentIndex + 1) % this.getnSprites());
    }

    /**
     * sets the amount of sprites.
     *
     * @param nSprites
     */
    private void setnSprites(final int nSprites) {
        this.nSprites = nSprites;
    }

    /**
     * @param sprites
     * @see showboard.ISpriteSet#setSprites(java.util.ArrayList)
     */
    @Override
    public void setSprites(final ArrayList<BufferedImage> sprites) {
        this.sprites = sprites;
    }

    /*
     * (non-Javadoc)
     *
     * @see showboard.ISpriteSet#setSprites(java.awt.image.BufferedImage)
     */
    @Override
    public void setSprites(final BufferedImage image) {
        this.setSprites(new ArrayList<BufferedImage>());
        this.getSprites().add(image);
    }

    /*
     * (non-Javadoc)
     * 
     * @see showboard.ISpriteSet#setSprites(showboard.ISpriteSet)
     */
    @Override
    public void setSprites(final ISpriteSet spriteSet) {
        this.setSprites(spriteSet.getSprites());
    }

}
