package com.byzilio;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.byzilio.engine.Engine;
import com.byzilio.game.engines.ArrayListEngine;

public class Game extends com.badlogic.gdx.Game {
	//SpriteBatch batch;
	//Texture img;

	Engine engine;

	@Override
	public void create () {
		//batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg");

		engine = new ArrayListEngine();

		setScreen(engine);
	}

	@Override
	public void render () {
		super.render();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//batch.begin();
		//batch.draw(img, 0, 0);
		//batch.end();
	}
	
	@Override
	public void dispose () {
		engine.dispose();
		//batch.dispose();
		//img.dispose();
	}
}
