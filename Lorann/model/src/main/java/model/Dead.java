/*
 *
 */
package model;

import java.awt.Image;

import enums.Type;
import enums.TypeEnum;
import vector.IVector;

/**
 * @author Max Becerro
 *
 */
public class Dead extends Entity {

    public Dead() {
        super(Type.DEAD);
    }

    /**
     * Instantiates a new Dead
     *
     * @param position
     */
    public Dead(final IVector position) {
        super(position, Type.DEAD);
    }

    @Override
    public Image getImage() {
        return ImageLoader.getImageByPath(TypeEnum.DEAD, 0);
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
        this.move();
    }

    @Override
    public void setType(final TypeEnum type) {
        // TODO Auto-generated method stub

    }

}
