package com.byzilio.game.scripts;

import com.byzilio.engine.Entity;
import com.byzilio.game.components.Rigidbody;
import com.byzilio.game.components.core.Script;
import com.byzilio.game.components.core.Time;

public class TestScript extends Script {

    private Rigidbody rb;
    private Time globalTime;

    public TestScript() {
        setName("TestScript");
        setDebug(true);
    }

    @Override
    public void start() {
        rb = (Rigidbody) entity.get(Rigidbody.class);
        globalTime = (Time) engine.getScene().get("Global Time");
        //log("start");
    }

    @Override
    public void preUpdate() {
        //log("preUpdate");
    }

    @Override
    public void update() {
        /*
        if(engine.input.keyDown("W"))
            log("AAAAAAAAAAAAAAAAAAAAAAAAAAA KeyDown W");
        if(engine.input.keyUp("W"))
            log("AAAAAAAAAAAAAAAAAAAAAAAAAAA KeyUp W");
        log("KEY W:" + engine.input.getKey("W"));
        log("update");
        log("KEYDOWN W : " + engine.input.keyDown("W"));
        log("KEYUP W : " + engine.input.keyUp("W"));
        */

        log(rb.getAx() + " " + rb.getAy() + " " + rb.getUx() + " " + rb.getUy());
        if(rb != null) {
            if (engine.input.keyDown("W")) {
                rb.setAy(1);
            }
            if (engine.input.keyDown("A")) {
                rb.setAx(-1);
            }
            if (engine.input.keyDown("S")) {
                rb.setAy(-1);
            }
            if (engine.input.keyDown("D")) {
                rb.setAx(1);
            }
        }

        if(globalTime != null){
            log(globalTime.toString());
        }

    }

    @Override
    public void postUpdate() {
        //log("postUpdate");
    }

    @Override
    public void onCollision(Entity other) {
        log("onCollide : " + other.getName());
    }

    @Override
    public void dispose() {
        log("dispose");
    }
}
