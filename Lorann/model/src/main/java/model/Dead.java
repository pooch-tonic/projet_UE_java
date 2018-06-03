/*
 *
 */
package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;

import enums.DirectionEnum;
import enums.Type;
import enums.TypeEnum;
import model.dao.QueryDAO;
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
    public Image getImage() throws IOException, SQLException {
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

    }

	@Override
	public void move(DirectionEnum direction) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setType(TypeEnum type) {
		// TODO Auto-generated method stub
		
	}

}
