package model;

import java.awt.Image;
import java.util.Vector;

import enums.TypeEnum;
import modelInterfaces.IWall;

/**
 * @author Max Becerro
 *
 */
public class Wall extends Block implements IWall{

	public Wall(TypeEnum type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	public Wall(Vector position, SpriteSet sprites, TypeEnum type) {
		super(position, sprites, type);
		// TODO Auto-generated constructor stub
	}

	public Wall(Vector position, TypeEnum type) {
		super(position, type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}

}
