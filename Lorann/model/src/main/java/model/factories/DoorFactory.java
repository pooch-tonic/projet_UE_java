package model.factories;

import model.Door;

class DoorFactory {
	Door createClosed() {
		return new Door(true);
	}

	Door createOpen() {
		return new Door(false);
	}
}
