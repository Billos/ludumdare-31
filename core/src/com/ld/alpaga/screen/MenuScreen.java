package com.ld.alpaga.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.ld.alpaga.Launcher;
import com.ld.alpaga.util.Dictionary;

public class MenuScreen implements Screen {

	private Launcher launcher;
	private TextButton gameButton;
	private BitmapFont font;
	
	public MenuScreen(Launcher launcher) {
		this.launcher = launcher;
		
    	TextureRegionDrawable drawU = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("style/menu/button/up.png"))));
    	TextureRegionDrawable drawD = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("style/menu/button/down.png"))));
    	TextureRegionDrawable drawC = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("style/menu/button/checked.png"))));
    	
    	this.font = new BitmapFont(Gdx.files.internal("style/menu/button/font.fnt"));
    	
    	TextButtonStyle style = new TextButtonStyle(drawU, drawD, drawC, font);
		this.gameButton = new TextButton(Dictionary.buttonMenuLaunch, style);
		
	}
	
	
	@Override
	public void render(float delta) {

		Gdx.gl.glClearColor(0, 0, 255, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		this.gameButton.setPosition(100, 100);
		
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
	
	
	private void launchGame(){
		launcher.setScreen(new GameScreen(this));
	}

}
