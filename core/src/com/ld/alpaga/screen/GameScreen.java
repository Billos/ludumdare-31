package com.ld.alpaga.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.ld.alpaga.badguy.BadGuyManager;
import com.ld.alpaga.square.SquareManager;
import com.ld.alpaga.util.State;

public class GameScreen implements Screen {

	private SquareManager squareManager;
	private BadGuyManager badGuysManager;
	private Screen launcher;
	private State state;

	public GameScreen(Screen launcher) {
		this.launcher = launcher;
		this.state = State.PAUSE;
		squareManager = new SquareManager();
		squareManager.dispatch();
		badGuysManager = new BadGuyManager(3);
		badGuysManager.dispatch();
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
		if(Gdx.input.isKeyJustPressed(Keys.SPACE)){
			this.state = (this.state == State.RUN) ? State.PAUSE : State.RUN;
		}

	}

	private void update() {
		squareManager.render();
		badGuysManager.render();
	}
	
	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}

}
