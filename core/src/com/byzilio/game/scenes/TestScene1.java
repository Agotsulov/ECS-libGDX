package com.byzilio.game.scenes;

import com.badlogic.gdx.graphics.Texture;
import com.byzilio.engine.Engine;
import com.byzilio.engine.Entity;
import com.byzilio.game.components.Button;
import com.byzilio.game.components.Position;
import com.byzilio.game.components.Rigidbody;
import com.byzilio.game.components.Sprite;
import com.byzilio.game.core.ArrayListEntity;
import com.byzilio.game.core.ArrayScene;
import com.byzilio.game.scripts.TestScript;

public class TestScene1 extends ArrayScene {

    @Override
    public void create(Engine engine) {
        super.create(engine);
        Entity e;

        e = new ArrayListEntity();

        e.add(new Position(10, 30));
        e.add(new Sprite(1, new Texture("badlogic.jpg"), 100, 100));
        e.add(new Rigidbody(3,0,0,0,10,5,0,0.2f,0));
        e.add(new TestScript());
        e.add(new Button(10, 300,300, 100, 100, "test2.png"));

        add(e);

        e = new ArrayListEntity();

        e.add(new Position(100, 100));
        e.add(new Sprite(-10,"test1.png", 200, 200, -50, -25));
        e.add(new Sprite(1,"test2.png", 100, 200));
    }

}
