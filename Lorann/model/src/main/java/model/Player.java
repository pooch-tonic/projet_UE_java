/*
 *
 */
package model;

import java.awt.Image;

import enums.Type;
import enums.TypeEnum;
import modelInterfaces.IPlayer;
import showboard.ISpriteSet;
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
    public Player(ISpriteSet spriteSet) {
        super(Type.PLAYER);
        super.setSpriteSet(spriteSet);
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
        return ImageLoader.getImageByPath(TypeEnum.PLAYER, super.getSpriteSet().getCurrentIndex());
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

	@Override
	public void setType(TypeEnum type) {
		// TODO Auto-generated method stub
		
	}

}
