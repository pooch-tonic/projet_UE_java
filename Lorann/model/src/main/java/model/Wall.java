package model;

import java.awt.Image;
import java.util.Vector;

import enums.TypeEnum;
import modelInterfaces.IVector;
import modelInterfaces.IWall;

/**
 * @author Max Becerro
 *
 */
public class Wall extends Block implements IWall{

	
	private void setWallType(WallType wallType) {
		switch (wallType) {
		case WALL_ROUND: super.setType(TypeEnum.WALL);
			break;
		case WALL_VERTICAL: super.setType(TypeEnum.WALL_V);
			break;
		case WALL_HORIZONTAL: super.setType(TypeEnum.WALL_H);
			break;
		}
	}
	
	
	public Wall(WallType wallType) {
		super();
		this.setWallType(wallType);
		// TODO Auto-generated constructor stub
	}



	public Wall(IVector position, WallType wallType) {
		super();
		this.setWallType(wallType);
		this.setPosition(position);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}

}
