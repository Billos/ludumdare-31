package com.ld.alpaga.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.ld.alpaga.badguy.BadGuy;
import com.ld.alpaga.badguy.BadGuyManager;
import com.ld.alpaga.square.SquareManager;
import com.ld.alpaga.util.State;

public class GameScreen implements Screen {

	private SquareManager squareManager;
	private State state;
	private Stage stage;
	private Camera camera;
	private Batch batch;

	public GameScreen(Screen launcher) {
		this.batch = new SpriteBatch();
		this.stage = new Stage();
		this.state = State.RUN;
		this.camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		
		squareManager = new SquareManager();
		squareManager.dispatch();
		new BadGuyManager(this.stage, 150);
		
	}



	@Override
	public void render(float delta) {

		Gdx.gl.glClearColor(0, 0, 0, 255);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


		switch (this.state) {
		case PAUSE:
			break;
		case RUN:
			update();
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
			System.out.println(hitActor);
			
			if (hitActor != null && hitActor instanceof BadGuy){
				System.out.println("PLOP");
			}

		}
	}



	private void update() {
		
		squareManager.render();
		stage.draw();
		
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        
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
