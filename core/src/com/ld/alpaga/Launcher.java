package com.ld.alpaga;

import com.badlogic.gdx.Game;
import com.ld.alpaga.screen.MenuScreen;

public class Launcher extends Game {
	
	@Override
	public void create () {
		
		// Starting on the Menu
		setScreen(new MenuScreen(this));
		
	}

}
