package com.byzilio.game.core;

import com.byzilio.engine.Component;
import com.byzilio.engine.Engine;
import com.byzilio.engine.Scene;
import com.byzilio.engine.core.Container;

import java.util.ArrayList;
import java.util.List;

public class ArrayScene extends Scene {

    private List<Component> gameObjects = new ArrayList<Component>();

    @Override
    public void create(Engine engine) {
        super.create(engine);
        refreshSystems();
        refreshGameObjects();
    }

    private void refreshSystems(){
        for(int i = 0;i < engine.size();i++)
            for(int j = 0;j < gameObjects.size();j++)
                engine.get(i).add(gameObjects.get(j));
    }

    private void refreshGameObjects(){
        for(int j = 0;j < gameObjects.size();j++)
            gameObjects.get(j).create(engine);
    }

    @Override
    public void add(Component gameObject) {
        gameObjects.add(gameObject);
        gameObject.create(engine);
        for(int i = 0;i < engine.size();i++)
            engine.get(i).add(gameObject);
    }

    @Override
    public void add(int i, Component gameObject) {
        gameObjects.add(i, gameObject);
        gameObject.create(engine);
        for(int j = 0;j < engine.size();j++)
            engine.get(j).add(gameObject);
    }

    @Override
    public Component get(int i) {
        return gameObjects.get(i);
    }

    @Override
    public int size() {
        return gameObjects.size();
    }

    @Override
    public void clear() {
        gameObjects.clear();
        for(int i = 0;i < engine.size();i++){
            engine.get(i).clear();
        }
    }

    @Override
    public boolean isEmpty() {
        return gameObjects.isEmpty();
    }

    @Override
    public Component remove(int i) {
        return gameObjects.remove(i);
    }

    @Override
    public boolean remove(Object o) {
        return gameObjects.remove(o);
    }

    @Override
    public void dispose() {
        for(int i = 0;i < gameObjects.size();i++)
            gameObjects.get(i).dispose();
    }

    @Override
    public Component get(String name) {
        for(int i = 0;i < gameObjects.size();i++){
            Component go = gameObjects.get(i);
            if(go.getName().equals(name))
                return go;
        }
        return null;
    }

    @Override
    public Component get(Class c) {
        for(int i = 0;i < gameObjects.size();i++){
            Component go = gameObjects.get(i);
            if(c.isInstance(go))
                return go;
        }
        return null;
    }

    @Override
    public Container<Component> getAll(String name) {
        Container<Component> result = new ArrayListContainer<Component>(); //Много лишнего убрать
        for(int i = 0;i < gameObjects.size();i++){
            Component go = gameObjects.get(i);
            if(go.getName().equals(name))
                result.add(go);
        }
        return result;
    }

    @Override
    public Container<Component> getAll(Class c) {
        Container<Component> result = new ArrayListContainer<Component>();
        for(int i = 0;i < gameObjects.size();i++){
            Component go = gameObjects.get(i);
            if(c.isInstance(go))
                result.add(go);
        }
        return result;
    }

}
