package model.factories;

import model.Enemy;
import model.EnemyName;

class EnemyFactory {
	Enemy createArrbarr() {
		return new Enemy(EnemyName.ARRBARR);
	}

	Enemy createCargyv() {
		return new Enemy(EnemyName.CARGYV);
	}

	Enemy createKyracj() {
		return new Enemy(EnemyName.KYRACJ);
	}

	Enemy createMaarcg() {
		return new Enemy(EnemyName.MAARCG);
	}
}
