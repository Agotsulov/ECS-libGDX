package com.byzilio.common.scenes;

import com.byzilio.engine.Engine;
import com.byzilio.engine.Entity;
import com.byzilio.common.components.Button;
import com.byzilio.common.components.Position;
import com.byzilio.common.core.ArrayListEntity;
import com.byzilio.common.core.ArrayScene;
import com.byzilio.common.scripts.ChangeSceneOnClick;
import com.byzilio.games.tictactoe.TicTacToe;

public class StartScene extends ArrayScene {

    @Override
    public void create(Engine engine) {
        super.create(engine);

        Entity e;

        e = new ArrayListEntity();

        e.add(new Position(30,30));
        e.add(new Button(10, 30, 30, 200, 100,"button1.png"));
        e.add(new ChangeSceneOnClick(new TestScene1()));

        add(e);

        e = new ArrayListEntity();

        e.add(new Position(30,230));
        e.add(new Button(10, 30, 230, 200, 100,"button2.png"));
        e.add(new ChangeSceneOnClick(new TicTacToe()));

        add(e);
    }

}
