package com.ld.alpaga.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.ld.alpaga.square.SquareManager;
import com.ld.alpaga.util.State;

public class GameScreen implements Screen {

	private SquareManager squareManager;
	private Screen launcher;
	private State state;

	public GameScreen(Screen launcher) {
		this.launcher = launcher;
		this.state = State.PAUSE;
		squareManager = new SquareManager();
		squareManager.dispatch();
	}



	@Override
	public void render(float delta) {

		Gdx.gl.glClearColor(255, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


		switch (this.state) {
		case PAUSE:
			break;
		case RUN:
			update();
			break;
		default:
			break;
		}

		// pause unpause

		if(Gdx.input.isKeyPressed(Keys.SPACE)){
			this.state = State.RUN;
		}
		if(Gdx.input.isKeyPressed(Keys.P)){
			this.state = State.PAUSE;
		}
		System.out.println(this.state);

	}

	private void update() {
		squareManager.render();
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
