/*
 *
 */
package model;

import java.awt.Image;

import enums.Type;
import vector.IVector;

/**
 * @author Max Becerro
 *
 */
public class Key extends Entity {

    /**
     * Instantiates a new Key
     *
     */
    public Key() {
        super(Type.KEY);
        // TODO Auto-generated constructor stub
    }

    /**
     * Instantiates a new Key
     *
     * @param position
     */
    public Key(final IVector position) {
        super(position, Type.KEY);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Image getImage() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getX() {
        return this.getPosition().getX();
    }

    @Override
    public int getY() {
        return this.getPosition().getY();
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub

    }

}
