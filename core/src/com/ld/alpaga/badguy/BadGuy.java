package com.ld.alpaga.badguy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class BadGuy {

	private float x;
	private float y;
	private Behavior behavior;
	private Animation anim;

	public BadGuy(Behavior behavior) {
		this.behavior = behavior;
		
		Texture texture = new Texture(Gdx.files.internal("game/sprite/badguy/badguy1/sprite.png"));
		TextureRegion[] frames = TextureRegion.split(texture, texture.getWidth(), texture.getHeight())[0];
		
		this.anim = new Animation(0.025F, frames);
	}

	public Behavior getBehavior() {
		return behavior;
	}

	public Animation getAnim() {
		return anim;
	}

	public void setAnim(Animation anim) {
		this.anim = anim;
	}

	public void setInitPosition(float x, float y) {
		this.setX(x);
		this.setY(y);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public void move() {
		
	}


}
