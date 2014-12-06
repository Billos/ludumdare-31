package com.ld.alpaga.square;

import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SquareRenderer extends SpriteBatch {
	
	public void renderSquares(boolean haveToMoveSquare, List<Square> squares, float screenWidth, float marginWidth){	
		for(Square square : squares) {
			if(haveToMoveSquare)
				moveSquare(square, screenWidth, marginWidth);
			draw(square.getTexture(), square.x, square.y, square.width, square.height);
		}
	}
	
	private void moveSquare(Square square, float screenWidth, float marginWidth){		
		float newX = square.x + square.width;	
		float tmp = screenWidth + marginWidth;
		if(newX >= tmp || ((tmp - newX) < 0.4 ))
			newX = marginWidth;
		
		square.setX(newX);
	}
}
