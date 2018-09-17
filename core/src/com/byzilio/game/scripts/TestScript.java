package com.byzilio.game.scripts;

import com.byzilio.game.components.Script;

public class TestScript extends Script {

    public TestScript() {
        setName("TestScript");
        setDebug(false);
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
        if(engine.input.keyDown("W"))
            log("AAAAAAAAAAAAAAAAAAAAAAAAAAA KeyDown W");
        if(engine.input.keyUp("W"))
            log("AAAAAAAAAAAAAAAAAAAAAAAAAAA KeyUp W");
        log("KEY W:" + engine.input.getKey("W"));
        log("update");
        log("KEYDOWN W : " + engine.input.keyDown("W"));
        log("KEYUP W : " + engine.input.keyUp("W"));
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
