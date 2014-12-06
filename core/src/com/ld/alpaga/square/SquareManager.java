package com.ld.alpaga.square;

import java.util.LinkedList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.TimeUtils;

public class SquareManager {

	private float rectangleWidth, rectangleHeight;
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
		
		float screenWidth = Gdx.graphics.getWidth();
		float screenHeight = Gdx.graphics.getHeight();
		
		rectangleWidth = screenWidth / COLONNE;
		rectangleHeight = screenHeight / LINE;
	}
	
	public void dispatch() {
	
		Texture goodTexture = loadGoodTexture();
		Texture badTexture = loadBadTexture();
		
		for(int i = 0; i < COLONNE; i++) {
			for(int j = 0; j < LINE; j++) {		
				
				Square tmp = new Square(new Rectangle(i * rectangleWidth, j * rectangleHeight, rectangleWidth, rectangleHeight));
				
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
		
		if(TimeUtils.timeSinceMillis(timeSinceProcess) > 250) {
			haveToProcessSquare = true;
			timeSinceProcess = TimeUtils.millis();
		}
		
		squareRenderer.begin();
		squareRenderer.renderSquares(haveToProcessSquare, goodSquares);
		squareRenderer.renderSquares(haveToProcessSquare, badSquares);
		squareRenderer.end();
	}
}