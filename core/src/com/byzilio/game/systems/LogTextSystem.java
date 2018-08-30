package com.byzilio.game.systems;

import com.byzilio.engine.Engine;
import com.byzilio.engine.Entity;
import com.byzilio.engine.GameObject;
import com.byzilio.engine.System;
import com.byzilio.game.components.LogTextComponent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LogTextSystem extends System{

    private List<LogTextComponent> components = new ArrayList<LogTextComponent>();

    public LogTextSystem() {
        setName("LogTextSystem");
    }

    @Override
    public void create(Engine engine) {
        super.create(engine);
        log("create");
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
            List<GameObject> gameObjects = e.getAll(LogTextComponent.class);
            for(GameObject go: gameObjects)
                components.add((LogTextComponent) go);
            //Разобраться почему не работает. А то это не красиво.
            //components.addAll((Collection<? extends LogTextComponent>) gameObjects);
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
            List<GameObject> gameObjects = e.getAll(LogTextComponent.class);
            for(GameObject go: gameObjects)
                components.add(i, (LogTextComponent) go);
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
}
