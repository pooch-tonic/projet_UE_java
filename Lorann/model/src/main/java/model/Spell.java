package model;

import enums.Type;
import showboard.ISpriteSet;
import vector.IVector;

public class Spell extends Entity {
	public Spell(final ISpriteSet spriteSet) {
		super(Type.SPELL, spriteSet);
	}

	/**
	 * Instantiates a new Player
	 *
	 * @param position
	 */
	public Spell(final IVector position) {
		super(Type.SPELL);
		this.setPosition(position);
	}

}
