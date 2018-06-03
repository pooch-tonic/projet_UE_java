package model;

import java.awt.Image;

import enums.Type;
import vector.IVector;

public class Spell extends Entity {
	public Spell() {
        super(Type.SPELL);
        // TODO Auto-generated constructor stub
    }

    /**
     * Instantiates a new Player
     *
     * @param position
     */
    public Spell(final IVector position) {
        super(position, Type.SPELL);
    }

    @Override
    public Image getImage() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getX() {
        return this.getPosition().getX();
    }

    @Override
    public int getY() {
        return this.getPosition().getY();
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub

    }
}
