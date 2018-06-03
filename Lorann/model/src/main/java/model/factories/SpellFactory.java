package model.factories;

import model.Spell;
import showboard.ISpriteSet;

class SpellFactory {
	static Spell createSpell(ISpriteSet spriteSet) {
		return new Spell(spriteSet);
	}
}
