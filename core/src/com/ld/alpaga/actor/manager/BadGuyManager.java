package com.ld.alpaga.actor.manager;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.ld.alpaga.actor.BadGuy;

public class BadGuyManager {
	
	private float screenWidth;
	private float screenHeight;
	private Stage stage;
	private int amount;
	
	public BadGuyManager(Stage stage, int amount) {
		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();
		
		this.amount = amount;
		this.stage = stage;
		dispatch();
		
	}


	private void dispatch(){
		Texture texture = new Texture(Gdx.files.internal("game/sprite/badguy/badguy1/sprite.png"));
		TextureRegion[] frames = TextureRegion.split(texture, texture.getWidth()/4, texture.getHeight())[0];
		Animation anim = new Animation(0.5F, frames);

		for (int i = 0; i < amount; i++) {
			
			float x = new Random().nextFloat()* screenWidth;
			float y = new Random().nextFloat()* screenHeight;
			
			BadGuy guy = new BadGuy(x, y, anim, texture.getWidth(), texture.getHeight());
			
			this.stage.addActor(guy);

		}	
	}
	
}