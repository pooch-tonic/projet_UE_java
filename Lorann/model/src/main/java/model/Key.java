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
        return ImageLoader.getImageByPath(TypeEnum.KEY, 0);
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
