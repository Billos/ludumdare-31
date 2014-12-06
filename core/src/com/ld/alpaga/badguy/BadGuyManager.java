package com.ld.alpaga.badguy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.TimeUtils;

public class BadGuyManager {

	private List<BadGuy> list;
	private BadGuyRenderer renderer;
	private int amount;
	
	private long timeSinceProcess;
	
	public BadGuyManager(int amount) {
		this.amount = amount;
		this.renderer = new BadGuyRenderer();
		this.list = new ArrayList<BadGuy>(amount);
		
		timeSinceProcess = TimeUtils.millis();
	}
		
	
	/**
	 * initial position of the bad guys
	 */
	public void dispatch() {
	
		float screenWidth = Gdx.graphics.getWidth();
		float screenHeight = Gdx.graphics.getHeight();
		
		for (int i = 0; i < amount; i++) {
			
			BadGuy guy = new BadGuy(Behavior.STRAIGHT_SOUTH);
			float x = new Random().nextFloat()* screenWidth;
			float y = new Random().nextFloat()* screenHeight;
			guy.setInitPosition(x,y);
			list.add(guy);
			
		}
		
	}
	
	
	public void render(){
		boolean haveToProcessSquare = false; 
		
		if(TimeUtils.timeSinceMillis(timeSinceProcess) > 250) {
			haveToProcessSquare = true;
			timeSinceProcess = TimeUtils.millis();
		}
		
		renderer.begin();
		renderer.renderBadGuys(haveToProcessSquare, list);
		renderer.end();
	}
}