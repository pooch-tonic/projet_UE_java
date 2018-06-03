package model;

import java.awt.Image;

import enums.Type;
import enums.TypeEnum;
import showboard.ISpriteSet;
import vector.IVector;

public class Spell extends Entity {
	public Spell(ISpriteSet spriteSet) {
        super(Type.SPELL);
        super.setSpriteSet(spriteSet);
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
        return ImageLoader.getImageByPath(TypeEnum.SPELL, super.getSpriteSet().getCurrentIndex());
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

	@Override
	public void setType(TypeEnum type) {
		// TODO Auto-generated method stub
		
	}
}
