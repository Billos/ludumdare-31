package com.ld.alpaga.badguy;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class BadGuyRenderer extends SpriteBatch {

	private float stateTime;
	
	public BadGuyRenderer() {
		super();
		this.stateTime = 0F;
	}
	
	public void renderBadGuys(boolean hasToMove, List<BadGuy> list) {

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		
		stateTime += Gdx.graphics.getDeltaTime();
		
		for(BadGuy bg :list){
			
			bg.move();
			
			TextureRegion current = bg.getAnim().getKeyFrame(stateTime, true);
			draw(current, bg.getX(), bg.getY());
		}
		

	}

}
