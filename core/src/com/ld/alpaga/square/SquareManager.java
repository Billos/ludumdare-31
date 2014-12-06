package com.ld.alpaga.square;

import java.util.LinkedList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.TimeUtils;

public class SquareManager {

	private float screenWidth, screenHeight, marginWidth;
	private static final float COLONNE = 15f;
	private static final float LINE = 10f;

	private List<Square> goodSquares, badSquares;
	private SquareRenderer squareRenderer;
	
	private long timeSinceProcess;	
	
	public SquareManager() {
		squareRenderer = new SquareRenderer();
		
		goodSquares = new LinkedList<Square>();
		badSquares = new LinkedList<Square>();
		
		timeSinceProcess = TimeUtils.millis();
		
		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();
		
		Gdx.input.setInputProcessor(new InputAdapter () {
			 public boolean touchDown(int screenX, int screenY, int pointer, int button) {
				 if (button == Input.Buttons.LEFT) {
					 onMouseClick(screenX, screenY);
					 return true;
				 }
				 return false;
			 }
		});
	}
	
	private void onMouseClick(int x, int y)
	{
		y = Gdx.graphics.getHeight() - y;
		if(isOnSquareList(x, y, goodSquares)) {
			screenWidth = screenWidth / 1.25f;
			screenHeight = screenHeight / 1.25f;
			dispatch();
		}
	}
	
	private boolean isOnSquareList(int x, int y, List<Square> squares)
	{
		for(Square square : squares)
		{
			boolean found = square.contains(x, y);
						
			if(found)
				return true;
		}
		return false;
	}

	public void dispatch() {
		goodSquares.clear();
		badSquares.clear();
		
		float squareWidth = screenWidth / COLONNE;
		float squareHeight = screenHeight / LINE;
		
		marginWidth = (Gdx.graphics.getWidth() - screenWidth) / 2f;
		float marginHeight = (Gdx.graphics.getHeight() - screenHeight) / 2f;		
		
		Texture goodTexture = loadGoodTexture();
		Texture badTexture = loadBadTexture();
		
		for(int i = 0; i < COLONNE; i++) {
			for(int j = 0; j < LINE; j++) {		
				
				Square tmp = new Square((i * squareWidth) + marginWidth, (j * squareHeight ) + marginHeight, squareWidth, squareHeight);				
				if(Math.random() < 0.1 || (goodSquares.isEmpty() && (i == COLONNE - 1) && (j == LINE - 1))) {
					tmp.setTexture(goodTexture);					
					goodSquares.add(tmp);
					
				} else {
					tmp.setTexture(badTexture);
					badSquares.add(tmp);
				}			
			}
		}	
	}	
	
	private Texture loadGoodTexture() {
		return new Texture(Gdx.files.internal("diamond.png"));
	}
	
	private Texture loadBadTexture() {
		return new Texture(Gdx.files.internal("crap.png"));
	}
	
	
	public void render()
	{
		boolean haveToProcessSquare = false; 
		
		if(TimeUtils.timeSinceMillis(timeSinceProcess) > 1000) {
			haveToProcessSquare = true;
			timeSinceProcess = TimeUtils.millis();
		}
		
		squareRenderer.begin();
		squareRenderer.renderSquares(haveToProcessSquare, goodSquares, screenWidth, marginWidth);
		squareRenderer.renderSquares(haveToProcessSquare, badSquares, screenWidth, marginWidth);
		squareRenderer.end();
	}
}