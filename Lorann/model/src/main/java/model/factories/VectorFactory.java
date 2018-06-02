package model.factories;

import enums.DirectionsEnum;
import modelInterfaces.IVectorFactory;
import vector.Vector;

abstract class VectorFactory implements IVectorFactory{
	private static Vector UPLEFT = new Vector(-1, -1);
	private static Vector UP = new Vector(0, -1);
	private static Vector UPRIGHT = new Vector(1, -1);
	private static Vector RIGHT = new Vector(1, 0);
	private static Vector DOWNRIGHT = new Vector(1, 1);
	private static Vector DOWN = new Vector(0,1);
	private static Vector DOWNLEFT = new Vector(-1, 1);
	private static Vector LEFT = new Vector(-1, 0);
	private static Vector MIDDLE = new Vector(0, 0);
	
	public static Vector getUPLEFT() {
		return UPLEFT;
	}
	public static Vector getUP() {
		return UP;
	}
	public static Vector getUPRIGHT() {
		return UPRIGHT;
	}
	public static Vector getRIGHT() {
		return RIGHT;
	}
	public static Vector getDOWNRIGHT() {
		return DOWNRIGHT;
	}
	public static Vector getDOWN() {
		return DOWN;
	}
	public static Vector getDOWNLEFT() {
		return DOWNLEFT;
	}
	public static Vector getLEFT() {
		return LEFT;
	}
	public static Vector getMIDDLE() {
		return MIDDLE;
	}

	public static Vector getVectorForDirection(DirectionsEnum direction) {
		switch(direction) {
			case UPLEFT :
				return getUPLEFT();
			case UP :
				return getUP();
			case UPRIGHT :
				return getUPRIGHT();
			case RIGHT :
				return getRIGHT();
			case DOWNRIGHT :
				return getDOWNRIGHT();
			case DOWN :
				return getDOWN();
			case DOWNLEFT :
				return getDOWNLEFT();
			case LEFT :
				return getLEFT();
			case MIDDLE :
				return getMIDDLE();
			default:
				break;
		}
		return null;
	}
}
