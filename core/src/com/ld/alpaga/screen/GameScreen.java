package com.ld.alpaga.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.ld.alpaga.square.SquareManager;

public class GameScreen implements Screen {

	private SquareManager squareManager;
	
	public GameScreen(Screen launcher) {
		this.launcher = launcher;
		squareManager = new SquareManager();
		squareManager.dispatch();
	}
	
	private Screen launcher;
	
	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(255, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        squareManager.render();
        
        
        
        // reactions
        if(Gdx.input.isButtonPressed(Keys.SPACE)){
        	changePause();
        }
        
	}

	private boolean onPause;
	private void changePause() {
		// TODO Auto-generated method stub
		
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
