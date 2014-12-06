package com.ld.alpaga.screen.listener;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.ld.alpaga.screen.MenuScreen;

public class LaunchGameListener extends ClickListener {
	
	private MenuScreen menu;
	
	public LaunchGameListener(MenuScreen menu) {
		this.menu = menu;
	}

	@Override
	public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
		
		menu.launchGame();
		
		return super.touchDown(event, x, y, pointer, button);
	}
	
}

