package model.factories;

import model.Enemy;
import model.EnemyNameEnum;
import showboard.ISpriteSet;

class EnemyFactory {
	Enemy createArrbarr(ISpriteSet spriteSet) {
		return new Enemy(EnemyNameEnum.ARRBARR, spriteSet);
	}

	Enemy createCargyv(ISpriteSet spriteSet) {
		return new Enemy(EnemyNameEnum.CARGYV, spriteSet);
	}

	Enemy createKyracj(ISpriteSet spriteSet) {
		return new Enemy(EnemyNameEnum.KYRACJ, spriteSet);
	}

	Enemy createMaarcg(ISpriteSet spriteSet) {
		return new Enemy(EnemyNameEnum.MAARCG, spriteSet);
	}
}
