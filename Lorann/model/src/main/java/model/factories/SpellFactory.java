package model.factories;

import model.Spell;
import showboard.ISpriteSet;

class SpellFactory {
	Spell createSpell(final ISpriteSet spriteSet) {
		return new Spell(spriteSet);
	}
}
