package com.ld.alpaga.badguy;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class BadGuyManager {

	public BadGuyManager(Stage stage, int amount) {
		float screenWidth = Gdx.graphics.getWidth();
		float screenHeight = Gdx.graphics.getHeight();
		
		Texture texture = new Texture(Gdx.files.internal("game/sprite/badguy/badguy1/sprite.png"));
		TextureRegion[] frames = TextureRegion.split(texture, texture.getWidth()/4, texture.getHeight())[0];
		Animation anim = new Animation(0.5F, frames);

		for (int i = 0; i < amount; i++) {
			
			float x = new Random().nextFloat()* screenWidth;
			float y = new Random().nextFloat()* screenHeight;
			
			BadGuy guy = new BadGuy(x, y, anim);
			stage.addActor(guy);

		}	
	}


}