package com.ld.alpaga.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameOverScreen implements Screen {

	private Stage stage;
	private Texture background;
	
	public GameOverScreen() {
		this.stage = new Stage();
		
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 255, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.getBatch().begin();
		stage.getBatch().draw(background, 0, 0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		stage.getBatch().end();

		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
		
	}
	
	@Override
	public void show() {
		background = new Texture(Gdx.files.internal("llama.png"));
	}

	@Override
	public void resize(int width, int height) {}
	@Override
	public void hide() {}
	@Override
	public void pause() {}
	@Override
	public void resume() {}
	@Override
	public void dispose() {}

}
