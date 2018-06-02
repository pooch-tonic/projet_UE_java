/*
 * 
 */
package model;

import java.awt.Image;

import enums.TypeEnum;
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
        super(TypeEnum.KEY);
        // TODO Auto-generated constructor stub
    }

    /**
     * Instantiates a new Key
     *
     * @param position
     */
    public Key(final IVector position) {
        super(position, TypeEnum.KEY);
        // TODO Auto-generated constructor stub
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
    public Image getImage() {
        // TODO Auto-generated method stub
        return null;
    }

}
