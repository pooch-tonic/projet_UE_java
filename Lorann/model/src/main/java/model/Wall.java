/*
 *
 */
package model;

import enums.Type;
import vector.IVector;

/**
 * @author Max Becerro
 *
 */
public class Wall extends Unit {

    /**
     * Instantiates a new Wall
     *
     * @param position
     * @param wallType
     */
    public Wall(final IVector position, final WallType wallType) {
        super();
        this.setPosition(position);

        // TODO Auto-generated constructor stub
    }

    /**
     * Instantiates a new Wall
     *
     * @param wallType
     */
    public Wall() {
        super();
        this.setType(Type.WALL);
    }
}
