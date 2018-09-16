package com.byzilio;

import com.badlogic.gdx.graphics.Texture;
import com.byzilio.engine.core.Engine;
import com.byzilio.engine.Entity;
import com.byzilio.engine.Scene;
import com.byzilio.game.components.LogTextComponent;
import com.byzilio.game.components.Position;
import com.byzilio.game.components.Sprite;
import com.byzilio.game.core.ArrayListEngine;
import com.byzilio.game.core.ArrayListEntity;
import com.byzilio.game.core.ArrayScene;
import com.byzilio.game.systems.LogTextSystem;
import com.byzilio.game.systems.RenderSystem;

public class Game extends com.badlogic.gdx.Game {

	//SpriteBatch batch;
	//Texture img;

	Engine engine;

	@Override
	public void create () {
		//batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg");

		Scene scene = new ArrayScene();

		Entity e = new ArrayListEntity();
		e.add(new LogTextComponent("aAAAAAA"));
		e.add(new LogTextComponent("134134124"));
		e.add(new LogTextComponent());
		e.add(new LogTextComponent());
		e.add(new LogTextComponent("adfghfadshafs"));
		scene.add(e);



		e = new ArrayListEntity();
		e.add(new Position(10, 10));
		e.add(new Sprite(new Texture("badlogic.jpg"), 100, 120));
		scene.add(e);

		e = new ArrayListEntity();
		e.add(new Position(110, 10));
		e.add(new Sprite(new Texture("badlogic.jpg"), 50, 220));
		scene.add(e);

		e = new ArrayListEntity();
		e.add(new Position(0, 30));
		e.add(new Sprite(new Texture("badlogic.jpg"), 10, 20));
		scene.add(e);

		engine = new ArrayListEngine();
		//engine.add(new ScriptSystem());
		engine.add(new LogTextSystem());
		engine.add(new RenderSystem());

		engine.changeScene(scene);

		setScreen(engine);
	}

	@Override
	public void render () {
		super.render();
		//Gdx.gl.glClearColor(0, 0, 0, 1);
		//Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		//batch.begin();
		//batch.draw(img, 0, 0);
		//batch.draw(new Texture("badlogic.jpg"),300,100,100,200);
		//batch.end();
	}
	
	@Override
	public void dispose () {
		engine.dispose();
		//batch.dispose();
		//img.dispose();
	}
}
