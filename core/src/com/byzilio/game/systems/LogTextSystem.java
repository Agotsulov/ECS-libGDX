package com.byzilio.game.systems;

import com.byzilio.engine.Container;
import com.byzilio.engine.Entity;
import com.byzilio.engine.GameObject;
import com.byzilio.engine.System;
import com.byzilio.game.components.LogTextComponent;
import com.byzilio.game.enitites.ArrayListEntity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LogTextSystem extends System{

    private List<LogTextComponent> components = new ArrayList<LogTextComponent>();

    public LogTextSystem() {
        setName("LogTextSystem");
    }

    @Override
    public void preUpdate() {
        log("preUpdate");
    }

    @Override
    public void update() {
        log("update");
        for(int i = 0;i < size();i++){
            log(components.get(i).getName() + ":" + components.get(i).getText());
        }
    }

    @Override
    public void postUpdate() {
        log("postUpdate");
    }

    @Override
    public void dispose() {
        log("dispose");
    }

    @Override
    public void add(GameObject gameObject) {
        if (gameObject instanceof LogTextComponent){
            components.add((LogTextComponent) gameObject);
            return;
        }
        if (gameObject instanceof Entity) {
            Entity e = (Entity) gameObject;
            Container<GameObject> gameObjects = e.getAll(LogTextComponent.class);
            for(int j = 0; j < gameObjects.size();j++)
                components.add((LogTextComponent) gameObjects.get(j));
        }
    }

    @Override
    public void add(int i, GameObject gameObject) {
        if (gameObject instanceof LogTextComponent){
            components.add(i, (LogTextComponent) gameObject);
            return;
        }
        if (gameObject instanceof Entity) {
            Entity e = (Entity) gameObject;
            Container<GameObject> gameObjects = e.getAll(LogTextComponent.class);
            for(int j = 0; j < gameObjects.size();j++)
                components.add(i + j, (LogTextComponent) gameObjects.get(j));
        }
    }

    @Override
    public GameObject get(int i) {
        return components.get(i);
    }

    @Override
    public int size() {
        return components.size();
    }

    @Override
    public void clear() {
        components.clear();
    }

    @Override
    public boolean isEmpty() {
        return components.isEmpty();
    }

    @Override
    public GameObject remove(int i) {
        return components.remove(i);
    }

    @Override
    public boolean remove(Object o) {
        return components.remove(o);
    }

    @Override
    public GameObject get(String name) {
        return null;
    }

    @Override
    public GameObject get(Class c) {
        return null;
    }

    @Override
    public Container<GameObject> getAll(String name) {
        return null;
    }

    @Override
    public Container<GameObject> getAll(Class c) {
        return null;
    }

}
