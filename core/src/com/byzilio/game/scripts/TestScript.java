package com.byzilio.game.scripts;

import com.byzilio.game.components.Script;

public class TestScript extends Script {

    public TestScript() {
        setName("TestScript");
    }

    @Override
    public void start() {
        log("start");
    }

    @Override
    public void preUpdate() {
        log("preUpdate");
    }

    @Override
    public void update() {
        log("update");
    }

    @Override
    public void postUpdate() {
        log("postUpdate");
    }

    @Override
    public void dispose() {
        log("dispose");
    }
}
