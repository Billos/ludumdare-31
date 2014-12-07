package com.ld.alpaga.actor;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;


public class BadGuy extends Actor implements ClickableActor {

	private Animation anim;
	private float stateTime;

	public BadGuy(float x, float y, Animation anim, float width, float height)  {
		setX(x);
		setY(y);
		setWidth(width);
		setHeight(height);
		this.stateTime = 0F;
		this.anim = anim;
	}

	public void move(TextureRegion frame, int min, int max) {
		
		Random r = new Random();

		int moveX = r.nextInt(max*2+1)+min;
		int moveY = r.nextInt(max*2+1)+min;
		
		float maxX = Gdx.graphics.getWidth() - frame.getRegionWidth();
		float maxY = Gdx.graphics.getHeight() - frame.getRegionHeight();

		float newX = getValueInBorders(getX(), moveX, 0, maxX);
		float newY = getValueInBorders(getY(), moveY, 0, maxY);
		
		super.setX(newX);
		super.setY(newY);
		
	}
	
	private float getValueInBorders(float place, float move, float min, float max) {
		float ret = place+move;
		
		if(ret >= max){
			ret = max;
		} else if(ret <= min){
			ret = min;
		}
		
		return ret;
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		stateTime += Gdx.graphics.getDeltaTime();
		
		TextureRegion current = anim.getKeyFrame(stateTime, true);
		//move(current, -3,+3);
		batch.draw(current, getX(), getY());
		
	}

	public void onClick(){
		
		// Game over
		
	}

}
