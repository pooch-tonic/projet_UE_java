/*
 *
 */
package model.factories;

import enums.UnitTypeEnum;
import model.Door;
import showboard.ISpriteSet;

class DoorFactory {
    Door createClosed(final ISpriteSet spriteSet) {
        return new Door(UnitTypeEnum.DOOR_CLOSED, spriteSet);
    }

    Door createOpen(final ISpriteSet spriteSet) {
        return new Door(UnitTypeEnum.DOOR_OPEN, spriteSet);
    }
}
