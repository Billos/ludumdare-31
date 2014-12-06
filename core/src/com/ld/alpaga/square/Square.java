package com.ld.alpaga.square;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Square {

	private Rectangle rectangle;
	private Texture texture;
	
	public Square(Rectangle rectangle, Texture texture) {
		this.rectangle = rectangle;
		this.texture = texture;
	}
	
	public Square(Rectangle rectangle) {
		this.rectangle = rectangle;
	}
	
	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public Rectangle getRectangle() {
		return rectangle;
	}
	public Texture getTexture() {
		return texture;
	}
}
