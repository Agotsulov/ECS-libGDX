package com.byzilio.common.systems;

import com.byzilio.common.components.IntegerTime;
import com.byzilio.common.components.core.Time;
import com.byzilio.engine.Component;
import com.byzilio.engine.Entity;
import com.byzilio.engine.GameObject;
import com.byzilio.engine.System;
import com.byzilio.engine.core.Container;

import java.util.ArrayList;
import java.util.List;

public class TimeSystem extends System {

    private List<Time> times;

    public TimeSystem() {
        times = new ArrayList<Time>();
    }

    @Override
    public void start() {
        Time global = new IntegerTime(0,0,0,0,0);
        global.setName("Global Time");
        engine.getScene().add(global);
    }

    @Override
    public void preUpdate() {

    }

    @Override
    public void update() {
        log("real FPS = " + 1/engine.getDeltaTime());
    }

    @Override
    public void postUpdate() {
        for(int i = 0;i < times.size();i++)
            times.get(i).add();
    }

    @Override
    public void add(GameObject gameObject) {
        if (gameObject instanceof Time){
            times.add((Time) gameObject);
            return;
        }
        if (gameObject instanceof Entity) {
            Entity e = (Entity) gameObject;
            Container<Component> gameObjects = e.getAll(Time.class);
            for(int j = 0; j < gameObjects.size();j++)
                if(gameObjects.get(j) instanceof Time)
                    times.add((Time) gameObjects.get(j));
        }
    }

    @Override
    public void add(int i, GameObject gameObject) {
        if (gameObject instanceof Time){
            times.add(i, (Time) gameObject);
            return;
        }
        if (gameObject instanceof Entity) {
            Entity e = (Entity) gameObject;
            Container<Component> gameObjects = e.getAll(Time.class);
            for(int j = 0; j < gameObjects.size();j++)
                if(gameObjects.get(j) instanceof Time)
                    times.add(i, (Time) gameObjects.get(j));
        }
    }

    @Override
    public int size() {
        return times.size();
    }

    @Override
    public void clear() {
        times.clear();
    }

    @Override
    public boolean isEmpty() {
        return times.isEmpty();
    }

    @Override
    public GameObject remove(int i) {
        return times.remove(i);
    }

    @Override
    public boolean remove(Object o) {
        return times.remove(o);
    }

    @Override
    public void dispose() {

    }
}
