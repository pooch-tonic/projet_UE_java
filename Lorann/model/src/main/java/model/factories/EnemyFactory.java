package model.factories;

import model.Enemy;
import model.EnemyName;
import showboard.ISpriteSet;

class EnemyFactory {
	Enemy createArrbarr(ISpriteSet spriteSet) {
		return new Enemy(EnemyName.ARRBARR, spriteSet);
	}

	Enemy createCargyv(ISpriteSet spriteSet) {
		return new Enemy(EnemyName.CARGYV, spriteSet);
	}

	Enemy createKyracj(ISpriteSet spriteSet) {
		return new Enemy(EnemyName.KYRACJ, spriteSet);
	}

	Enemy createMaarcg(ISpriteSet spriteSet) {
		return new Enemy(EnemyName.MAARCG, spriteSet);
	}
}
