package com.ld.alpaga.actor.manager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.ld.alpaga.actor.Square;
import com.ld.alpaga.actor.enumeration.SquareType;
import com.ld.alpaga.screen.GameScreen;

public class SquareManager {

	public float screenWidth, screenHeight;
	private static final float COLONNE = 15f;
	private static final float LINE = 10f;
	private Stage stage;
	private GameScreen gameScreen;
	
	public SquareManager(Stage stage, GameScreen gameScreen) {
		this.stage = stage;
		this.gameScreen = gameScreen;
		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();
		
		this.dispatch();
	}
	
	public void dispatch() {
		
		float squareWidth = screenWidth / COLONNE;
		float squareHeight = screenHeight / LINE;
		
		float marginWidth = (Gdx.graphics.getWidth() - screenWidth) / 2f;
		float marginHeight = (Gdx.graphics.getHeight() - screenHeight) / 2f;
		
		Texture goodTexture = new Texture(Gdx.files.internal("diamond.png"));
		Texture badTexture = new Texture(Gdx.files.internal("crap.png"));
		
		for(int i = 0; i < COLONNE; i++) {
			for(int j = 0; j < LINE; j++) {		
				
				boolean b = (Math.random() < 0.1 || ((Square.goodCount == 0) && (i == COLONNE - 1) && (j == LINE - 1)));
				SquareType type = (b) ? SquareType.Good : SquareType.Bad;
				Texture t = (b) ? goodTexture : badTexture;
				Square s = new Square((i * squareWidth) + marginWidth, (j * squareHeight ) + marginHeight, squareWidth, squareHeight, type, t, this);
				this.stage.addActor(s);
			}
		}	
	}
	
	public void goodClick() {
		gameScreen.reduce();
	}
	
	public void reduce() {
		screenWidth = screenWidth / 1.25f;
		screenHeight = screenHeight / 1.25f;
		
		dispatch();
	}
	
	public void gameOver() {
		this.gameScreen.gameOver();
	}

	public float getScreenWidth() {
		return screenWidth;
	}
}