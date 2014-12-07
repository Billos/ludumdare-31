package com.ld.alpaga.badguy;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class BadGuyRenderer extends SpriteBatch {

	private float stateTime;
	
	public BadGuyRenderer() {
		super();
		this.stateTime = 0F;
	}
	
	public void renderBadGuys(boolean hasToMove, List<BadGuy> list) {

		stateTime += Gdx.graphics.getDeltaTime();
		for(BadGuy bg :list){
			
			bg.move();
			
			TextureRegion current = bg.getAnim().getKeyFrame(stateTime, true);
			draw(current, bg.getX(), bg.getY());
		}
		

	}

}
