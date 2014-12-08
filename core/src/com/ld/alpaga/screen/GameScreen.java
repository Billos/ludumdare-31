package com.ld.alpaga.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.ld.alpaga.Launcher;
import com.ld.alpaga.actor.ClickableActor;
import com.ld.alpaga.actor.manager.BadGuyManager;
import com.ld.alpaga.actor.manager.SquareManager;
import com.ld.alpaga.util.State;

public class GameScreen implements Screen {

	private State state;
	private Stage stage;
	private SquareManager squareManager;
	private BadGuyManager guyManager;
	private Launcher launcher;

	public GameScreen(Launcher launcher) {
		this.stage = new Stage();
		this.state = State.RUN;
		this.launcher = launcher;
		
		squareManager = new SquareManager(this.stage, this);
		guyManager = new BadGuyManager(this.stage, 10, this);
	}

	public void reduce() {
		this.stage.clear();
		squareManager.reduce();
		guyManager.reduce();
	}
	
	public void gameOver() {
		this.launcher.setScreen(new GameOverScreen());
	}

	@Override
	public void render(float delta) {

		Gdx.gl.glClearColor(0, 0, 0, 255);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		switch (this.state) {
		case PAUSE:
			break;
		case RUN:
			stage.draw();
			reaction();
			break;
		default:
			break;
		}

		// pause unpause

		if(Gdx.input.isKeyPressed(Keys.SPACE)){
			this.state = State.RUN;
		} else if(Gdx.input.isKeyPressed(Keys.P)){
			this.state = State.PAUSE;
		}  else if(Gdx.input.isKeyPressed(Keys.ESCAPE)){
			Gdx.app.exit();
		}

	}

	private void reaction() {
		if (Gdx.input.justTouched()) {

			Actor hitActor = this.stage.hit(Gdx.input.getX(), Gdx.graphics.getHeight()-Gdx.input.getY(), true);
			
			if (hitActor != null && hitActor instanceof ClickableActor){
				((ClickableActor)hitActor).onClick();
			}

		}
	}


	/**
	 * UNUSED OVERRIDES
	 */
	public void resize(int width, int height) {}
	public void show() {}
	public void hide() {}
	public void pause() {}
	public void resume() {}
	public void dispose() {}

}
