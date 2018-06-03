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
public class Door extends Entity {

    /**
     * Instantiates a new Door
     *
     * @param closed
     */
    public Door(final boolean closed) {
        super();
        this.setDoorType(closed);

        // TODO Auto-generated constructor stub
    }

    /**
     * Instantiates a new Door
     *
     * @param position
     * @param closed
     */
    public Door(final IVector position, final boolean closed) {
        super();
        this.setDoorType(closed);
        super.setPosition(position);

        // TODO Auto-generated constructor stub
    }

    @Override
    public Image getImage() {
        if (this.getType() == Type.ENEMY) {
            return ImageLoader.getImageByPath(TypeEnum.DOOR_CLOSED, 0);
        } else {
            return ImageLoader.getImageByPath(TypeEnum.DOOR_OPEN, 0);
        }
    }

    @Override
    public int getX() {
        return this.getPosition().getX();
    }

    @Override
    public int getY() {
        return this.getPosition().getY();
    }

    /**
     * @param closed
     */
    private void setDoorType(final boolean closed) {
        if (closed) {
            super.setType(Type.ENEMY);
        } else {
            super.setType(Type.DOOR_OPEN);
        }
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub

    }

    @Override
    public void setType(final TypeEnum type) {
        // TODO Auto-generated method stub

    }

}
