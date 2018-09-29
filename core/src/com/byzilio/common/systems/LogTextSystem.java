package com.byzilio.common.systems;

import com.byzilio.common.components.LogTextComponent;
import com.byzilio.engine.Component;
import com.byzilio.engine.Entity;
import com.byzilio.engine.GameObject;
import com.byzilio.engine.System;
import com.byzilio.engine.core.Container;

import java.util.ArrayList;
import java.util.List;

public class LogTextSystem extends System{

    private List<LogTextComponent> components = new ArrayList<LogTextComponent>();

    public LogTextSystem() {
        setName("LogTextSystem");
        setDebug(false);
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
            Container<Component> gameObjects = e.getAll("LogTextComponent");
            for(int j = 0; j < gameObjects.size();j++)
                if(gameObjects.get(j) instanceof LogTextComponent) //Узнать что за тип переменных в instansceof
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
            Container<Component> gameObjects = e.getAll("LogTextComponent");
            for(int j = 0; j < gameObjects.size();j++)
                if(gameObjects.get(j) instanceof LogTextComponent)
                components.add(i + j, (LogTextComponent) gameObjects.get(j));
        }
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


}
