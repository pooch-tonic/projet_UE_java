/*
 *
 */
package model.factories;

import enums.DirectionEnum;
import modelInterfaces.IVectorFactory;
import vector.Vector;

public abstract class VectorFactory implements IVectorFactory {
    public static Vector getUPLEFT() {
        return new Vector(-1, -1);
    }

    public static Vector getUP() {
        return new Vector(0, -1);
    }

    public static Vector getUPRIGHT() {
        return new Vector(1, -1);
    }

    public static Vector getRIGHT() {
        return new Vector(1, 0);
    }

    public static Vector getDOWNRIGHT() {
        return new Vector(1, 1);
    }

    public static Vector getDOWN() {
        return new Vector(0, 1);
    }

    public static Vector getDOWNLEFT() {
        return new Vector(-1, 1);
    }

    public static Vector getLEFT() {
        return new Vector(-1, 0);
    }

    public static Vector getMIDDLE() {
        return new Vector(0, 0);
    }

    public static Vector getVectorForDirection(final DirectionEnum direction) {
        switch (direction) {
        case UPLEFT:
            return getUPLEFT();
        case UP:
            return getUP();
        case UPRIGHT:
            return getUPRIGHT();
        case RIGHT:
            return getRIGHT();
        case DOWNRIGHT:
            return getDOWNRIGHT();
        case DOWN:
            return getDOWN();
        case DOWNLEFT:
            return getDOWNLEFT();
        case LEFT:
            return getLEFT();
        case NONE:
            return getMIDDLE();
        default:
            break;
        }
        return null;
    }
}
