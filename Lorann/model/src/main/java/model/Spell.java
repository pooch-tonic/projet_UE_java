package model;

import enums.Type;
import showboard.ISpriteSet;
import vector.IVector;

public class Spell extends Entity {
	public Spell(final ISpriteSet spriteSet) {
		super(Type.SPELL);
		super.setSpriteSet(spriteSet);
	}

	/**
	 * Instantiates a new Player
	 *
	 * @param position
	 */
	public Spell(final IVector position) {
		super(position, Type.SPELL);
	}

}
