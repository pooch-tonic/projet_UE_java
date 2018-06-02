/*
 *
 */
package model;

import java.awt.Image;

import enums.Type;
import modelInterfaces.IPlayer;
import vector.IVector;

/**
 * @author Max Becerro
 *
 */
public class Player extends Entity implements IPlayer {

    /**
     * Instantiates a new Player
     *
     */
    public Player() {
        super(Type.PLAYER);
        // TODO Auto-generated constructor stub
    }

    /**
     * Instantiates a new Player
     *
     * @param position
     */
    public Player(final IVector position) {
        super(position, Type.PLAYER);
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
