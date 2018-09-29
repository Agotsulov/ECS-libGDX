package com.byzilio.common.scripts;

import com.byzilio.common.components.core.Script;
import com.byzilio.engine.Scene;

public class ChangeSceneOnClick extends Script {

    private Scene scene;

    public ChangeSceneOnClick(Scene scene) {
        this.scene = scene;
    }

    @Override
    public void start() {

    }

    @Override
    public void preUpdate() {

    }

    @Override
    public void update() {

    }

    @Override
    public void postUpdate() {

    }

    @Override
    public void onClick() {
        engine.changeScene(scene);
    }

    @Override
    public void dispose() {

    }
}
