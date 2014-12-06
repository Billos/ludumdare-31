package com.ld.alpaga.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.ld.alpaga.Launcher;
import com.ld.alpaga.screen.listener.LaunchGameListener;
import com.ld.alpaga.util.Dictionary;

public class MenuScreen implements Screen {

	private Stage stage;
	private Launcher launcher;
	private Texture background;

	public MenuScreen(Launcher launcher) {
		this.launcher = launcher;

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
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {

		background = new Texture(Gdx.files.internal("style/menu/bg.png"));

		TextureRegionDrawable up 	= new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("style/menu/button/up.png"))));
		TextureRegionDrawable down 	= new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("style/menu/button/down.png"))));
		TextureRegionDrawable check = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("style/menu/button/checked.png"))));

		stage = new Stage();
		Gdx.input.setInputProcessor(stage);//stage reçoit les input

		BitmapFont font = new BitmapFont(Gdx.files.internal("style/menu/button/font.fnt"),Gdx.files.internal("style/menu/button/font.png"), false);

		/** créer son style de bouton ***/
		TextButtonStyle style = new TextButtonStyle(up, down, check, font);
		style.over = new TextureRegionDrawable(new TextureRegion(new TextureRegion(new Texture(Gdx.files.internal("style/menu/button/down.png")))));

		TextButton button = new TextButton(Dictionary.buttonMenuLaunch, style);
		// Center
		button.setPosition(stage.getWidth()/2, stage.getHeight()/2);
		button.addListener(new LaunchGameListener(this));

		stage.addActor(button);


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


	public void launchGame(){
		launcher.setScreen(new GameScreen(this));
	}

}
