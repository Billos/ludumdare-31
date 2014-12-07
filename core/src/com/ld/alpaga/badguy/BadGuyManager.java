package com.ld.alpaga.badguy;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class BadGuyManager {

	public BadGuyManager(Stage stage, int amount) {
		float screenWidth = Gdx.graphics.getWidth();
		float screenHeight = Gdx.graphics.getHeight();

		for (int i = 0; i < amount; i++) {
			
			float x = new Random().nextFloat()* screenWidth;
			float y = new Random().nextFloat()* screenHeight;
			
			BadGuy guy = new BadGuy(x, y);
			stage.addActor(guy);

		}	
	}


}