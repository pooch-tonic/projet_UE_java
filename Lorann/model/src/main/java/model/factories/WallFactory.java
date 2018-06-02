/*
 * 
 */
package model.factories;

import model.Wall;

class WallFactory {
    Wall createHorizontal() {
        return new Wall();
    }

    Wall createRound() {
        return new Wall();
    }

    Wall createVertical() {
        return new Wall();
    }
}
