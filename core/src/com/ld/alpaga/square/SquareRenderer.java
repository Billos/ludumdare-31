package com.ld.alpaga.square;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class SquareRenderer extends SpriteBatch {
	
	public void renderSquares(boolean haveToMoveSquare, List<Square> squares)
	{	
		for(Square square : squares) {
			if(haveToMoveSquare)
				moveSquare(square);
			draw(square.getTexture(), square.getRectangle().x, square.getRectangle().y, square.getRectangle().width, square.getRectangle().height);
		}
	}
	
	private void moveSquare(Square square)
	{
		Rectangle rectangle = square.getRectangle();
		float newX = rectangle.x + rectangle.width;
		
		if(newX >= Gdx.graphics.getWidth())
			newX = 0;
		
		rectangle.setX(newX);
	}
}
