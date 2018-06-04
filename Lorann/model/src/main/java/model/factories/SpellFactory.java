package model.factories;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import model.ImageLoader;
import model.Spell;
import model.SpriteSet;
import showboard.ISpriteSet;

class SpellFactory {
	private ISpriteSet spriteSet;
	Spell createSpell() {
		return new Spell(this.spriteSet);
	}
	
	public void setSpriteSet(ArrayList<String> spritePath) {
		final ArrayList<BufferedImage> images = new ArrayList<>();
        for (final String path : spritePath) {
            images.add(ImageLoader.getImageByPath(path));
        }
		this.spriteSet = new SpriteSet(images);
	}
}
