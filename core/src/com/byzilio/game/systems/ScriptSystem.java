package com.byzilio.game.systems;

import com.byzilio.engine.Component;
import com.byzilio.engine.Entity;
import com.byzilio.engine.GameObject;
import com.byzilio.engine.System;
import com.byzilio.engine.core.Container;
import com.byzilio.game.components.Script;

import java.util.ArrayList;
import java.util.List;

public class ScriptSystem extends System {

    private List<Script> scripts;

    public ScriptSystem() {
        scripts = new ArrayList<Script>();
    }

    @Override
    public void preUpdate() {
        for(int i = 0;i < scripts.size();i++)
            scripts.get(i).preUpdate();
    }

    @Override
    public void update() {
        for(int i = 0;i < scripts.size();i++)
            scripts.get(i).update();
    }

    @Override
    public void postUpdate() {
        for(int i = 0;i < scripts.size();i++)
            scripts.get(i).postUpdate();
    }

    @Override
    public void add(GameObject gameObject) {
        if (gameObject instanceof Script){
            scripts.add((Script) gameObject);
            return;
        }
        if (gameObject instanceof Entity) {
            Entity e = (Entity) gameObject;
            Container<Component> gameObjects = e.getAll(Script.class);
            for(int j = 0; j < gameObjects.size();j++)
                if(gameObjects.get(j) instanceof Script)
                    scripts.add((Script) gameObjects.get(j));
        }
    }

    @Override
    public void add(int i, GameObject gameObject) {
        if (gameObject instanceof Script){
            scripts.add(i, (Script) gameObject);
            return;
        }
        if (gameObject instanceof Entity) {
            Entity e = (Entity) gameObject;
            Container<Component> gameObjects = e.getAll(Script.class);
            for(int j = 0; j < gameObjects.size();j++)
                if(gameObjects.get(j) instanceof Script) //Узнать что за тип переменных в instansceof
                    scripts.add(i, (Script) gameObjects.get(j));
        }
    }

    @Override
    public int size() {
        return scripts.size();
    }

    @Override
    public void clear() {
        scripts.clear();
    }

    @Override
    public boolean isEmpty() {
        return scripts.isEmpty();
    }

    @Override
    public GameObject remove(int i) {
        return scripts.remove(i);
    }

    @Override
    public boolean remove(Object o) {
        return scripts.remove(o);
    }

    @Override
    public void dispose() {

    }
}
