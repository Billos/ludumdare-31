package com.ld.alpaga.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.ld.alpaga.Launcher;

public class MenuScreen implements Screen {

	private Launcher launcher;
	
	public MenuScreen(Launcher launcher) {
		this.launcher = launcher;
	}
	
	
	@Override
	public void render(float delta) {

		Gdx.gl.glClearColor(0, 0, 255, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
