package model.factories;

import model.Wall;
import model.WallType;

class WallFactory {
	Wall createHorizontal() {
		return new Wall(WallType.WALL_HORIZONTAL);
	}

	Wall createRound() {
		return new Wall(WallType.WALL_ROUND);
	}

	Wall createVertical() {
		return new Wall(WallType.WALL_VERTICAL);
	}
}
