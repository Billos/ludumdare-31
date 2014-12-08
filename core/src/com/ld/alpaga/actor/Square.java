package com.ld.alpaga.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.TimeUtils;
import com.ld.alpaga.actor.enumeration.SquareType;

public class Square extends ClickableActor {
	
	public static int goodCount;
	
	private Texture texture;
	private long timeSinceProcess;	
	private SquareType type;	
	
	public Square (float x, float y, float width, float height, SquareType type, Texture texture) {
		setX(x);
		setY(y);
		setWidth(width);
		setHeight(height);
		
		this.texture = texture;
		this.type = type;
		this.timeSinceProcess = TimeUtils.millis();
		
		if(this.type == SquareType.Good){
			goodCount++;
		}
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		
		boolean haveToProcessSquare = false; 
		if(TimeUtils.timeSinceMillis(timeSinceProcess) > 250) {
			haveToProcessSquare = true;
			timeSinceProcess = TimeUtils.millis();
		}
		
		if(haveToProcessSquare){
			float screenWidth = Gdx.graphics.getWidth();
			float marginWidth = (Gdx.graphics.getWidth() - screenWidth) / 2f;
			float newX = getX() + getWidth();	
			float tmp = screenWidth + marginWidth;
			if(newX >= tmp || ((tmp - newX) < 0.4 )){
				newX = marginWidth;
			}
			
			setX(newX);
		}
		
		batch.draw(texture, getX(), getY(), getWidth(), getHeight());
		
	}

	@Override
	public void onClick() {
		
		if(type == SquareType.Good){
			// screen goes smaller
		} else if(type == SquareType.Bad){
			// Nothing
		}
		
	}
	
}
