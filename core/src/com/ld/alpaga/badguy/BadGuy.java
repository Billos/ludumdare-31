package com.ld.alpaga.badguy;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;


public class BadGuy extends Actor{

	private Animation anim;
	private float stateTime;

	public BadGuy(float x, float y)  {
		super();
		setX(x);
		setY(y);
		this.stateTime = 0F;
		Texture texture = new Texture(Gdx.files.internal("game/sprite/badguy/badguy1/sprite.png"));
		TextureRegion[] frames = TextureRegion.split(texture, texture.getWidth()/4, texture.getHeight())[0];
		
		this.anim = new Animation(0.5F, frames);
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
		super.draw(batch, parentAlpha);
		
		
		
		stateTime += Gdx.graphics.getDeltaTime();
		
		TextureRegion current = anim.getKeyFrame(stateTime, true);
		move(current, -3,+3);
		batch.draw(	current, getX(), getY());
		
		// draw the second one
		float x = getX();
		float y = getY();
		
		float xSize = getWidth();
		float ySize = getHeight();
		
		float screenWidth = Gdx.graphics.getWidth();
		float screenHeight = Gdx.graphics.getHeight();
		
		// dépassement droit
		if(x+xSize > screenWidth){
			batch.draw(current, -x, y);
		}
		
		// dépassement gauche
		if(x < 0){
			batch.draw(current, screenWidth+x, y);
		}
		
		// dépassement haut
		if(y+ySize > screenHeight){
			batch.draw(current, x, -y);
		}
		
		// dépassement bas
		if(y < 0){
			batch.draw(current, x, screenHeight+y);
		}
	}

	@Override
	public void act(float delta) {
		super.act(delta);
		
		this.setPosition(getX(), getY());
	}
	
	public void onClick(){
		
	}

}
