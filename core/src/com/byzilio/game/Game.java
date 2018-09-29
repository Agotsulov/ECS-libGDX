package com.byzilio.game;

import com.byzilio.engine.Engine;
import com.byzilio.engine.Scene;
import com.byzilio.common.components.Position;
import com.byzilio.common.core.ArrayListEngine;
import com.byzilio.common.core.HashMapInput;
import com.byzilio.common.scenes.StartScene;
import com.byzilio.common.systems.GUISystem;
import com.byzilio.common.systems.InputSystem;
import com.byzilio.common.systems.LogTextSystem;
import com.byzilio.common.systems.MoveSystem;
import com.byzilio.common.systems.RenderSystem;
import com.byzilio.common.systems.ScriptSystem;
import com.byzilio.common.systems.TimeSystem;

public class Game extends com.badlogic.gdx.Game {//Ну не умею я называть правильно классы

	/*
		Ах да. Тестов тут нет.
		Так как не просто сюда их вставить и по сути в игре нечего тестировать.
		Если нужно показать как я пишу тесты могу скинуть другой проект

		Весь проект это написание движка и в последующем игры на шаблоне Entity-Component-System с помощью libGDX.
		Главная задача отказаться от приведений типов в игровом цикле,
		так как силшком долго в Java.

		Надо бы найди язык по лучше чем C++ и Java,
		а то слишком часто упираюсь в их "косяки" и "границы".
		Я не виню языки. Java не идеальная. Что плохово в том чтобы искать лучшее?
		TODO: Переидти на Kotlin


		(не)много глупых оправданий.
		Это все еще пробный вариант ECS.
		Я ECS пишу 3 раз в жизни.
		Так что код не получлось идеально продуман заранее.
		Поэтому тут очень много тупых мест появившихся из-за починки косяков.
		Например, функция create в Component и GameObject их не удобно использовать.
		Или что есть ArrayListContainer и ArrayListEntity c разницой в 2 строки.

		Я все больше склоняюсь к реализации через один абстракт класс GameObject(другой не текущий).
		Но это сильно увеличит и усложнит код.
	 */

	private Engine engine;

	@Override
	public void create () {
		engine = new ArrayListEngine(new HashMapInput());

		//За порядком лучше следить
		engine.add(new TimeSystem());
		engine.add(new InputSystem());
        engine.add(new GUISystem());
		engine.add(new MoveSystem());
        engine.add(new ScriptSystem());
		engine.add(new LogTextSystem());
		engine.add(new RenderSystem(new Position(99,99)));

		Scene scene = new StartScene();

		//Entity e = new ArrayListEntity();
		/*
		scene.add(e);
		e.add(new LogTextComponent("aAAAAAA"));
		e.add(new LogTextComponent("134134124"));
		e.add(new LogTextComponent());
		e.add(new LogTextComponent());
		e.add(new LogTextComponent("adfghfadshafs"));

		e = new ArrayListEntity();
		scene.add(e);
		e.add(new Position(10, 10));
		e.add(new Sprite(new Texture("badlogic.jpg"), 100, 120));

		e = new ArrayListEntity();
		scene.add(e);
		e.add(new Position(110, 10));
		e.add(new Sprite(new Texture("badlogic.jpg"), 50, 220));

		e = new ArrayListEntity();
		*/
		engine.changeScene(scene);


//		e.add(new Position(10, 30));
//		e.add(new Sprite(1, new Texture("badlogic.jpg"), 100, 100));
//        e.add(new Rigidbody(3,0,0,0,10,5,0,0.2f,0));
//		e.add(new TestScript());
//		e.add(new Button(10, 300,300, 100, 100, "test2.png"));
//		//e.add(new TestScript());
//		//e.add(new TestScript());
//		//e.add(new BoxCollider(false,100,150));
//		scene.add(e);




		setScreen(engine);

//		e = new ArrayListEntity();
//		e.add(new Position(100, 100));
//		e.add(new Sprite(-10,"test1.png", 200, 200, -50, -25));
//		e.add(new Sprite(1,"test2.png", 100, 200));
//		//e.add(new BoxCollider(true,200,200));
//
//		engine.getScene().add(e);
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		engine.dispose();
		//dispose в libGDX обязателен его же обьекты нужно таким образом удалять.
		//Иначе на андроиде будет мусор вместо текстур например.
	}
}
