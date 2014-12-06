package com.ld.alpaga.square;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Square extends Rectangle {
	
	private static final long serialVersionUID = 1L;
	private Texture texture;
	
	public Square (float x, float y, float width, float height) {
		super(x, y, width, height);
	}
	
	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public Texture getTexture() {
		return texture;
	}
}
