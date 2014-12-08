package com.ld.alpaga.actor;

import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class ClickableActor extends Actor {
	
	public abstract void onClick();
	
	protected static boolean firstClick = true;
}
