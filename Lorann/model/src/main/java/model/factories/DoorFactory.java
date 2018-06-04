/*
 * 
 */
package model.factories;

import enums.Type;
import model.Door;
import showboard.ISpriteSet;

class DoorFactory {
    Door createClosed(final ISpriteSet spriteSet) {
        return new Door(Type.ENEMY, spriteSet);
    }

    Door createOpen(final ISpriteSet spriteSet) {
        return new Door(Type.DOOR_OPEN, spriteSet);
    }
}
