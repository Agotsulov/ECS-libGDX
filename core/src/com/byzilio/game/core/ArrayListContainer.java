package com.byzilio.game.core;

import com.byzilio.engine.GameObject;
import com.byzilio.engine.core.Container;

import java.util.ArrayList;
import java.util.List;

public class ArrayListContainer<T extends GameObject> implements Container<T> {

    private List<T> gameObjects = new ArrayList<T>();

    @Override
    public void add(T gameObject) {
        gameObjects.add(gameObject);
    }

    @Override
    public void add(int i, T gameObject) {
        gameObjects.add(i, gameObject);
    }

    @Override
    public T get(int i) {
        return gameObjects.get(i);
    }

    @Override
    public int size() {
        return gameObjects.size();
    }

    @Override
    public void clear() {
        gameObjects.clear();
    }

    @Override
    public boolean isEmpty() {
        return gameObjects.isEmpty();
    }

    @Override
    public T remove(int i) {
        return gameObjects.remove(i);
    }

    @Override
    public boolean remove(Object o) {
        return gameObjects.remove(o);
    }


    @Override
    public T get(String name) {
        for(int i = 0;i < gameObjects.size();i++){
            T go = gameObjects.get(i);
            if(go.getName().equals(name))
                return go;
        }
        return null;
    }

    @Override
    public T get(Class c) {
        for(int i = 0;i < gameObjects.size();i++){
            T go = gameObjects.get(i);
            if(c.isInstance(go))
                return go;
        }
        return null;
    }

    @Override
    public Container<T> getAll(String name) {
        Container<T> result = new ArrayListContainer(); //Много лишнего убрать
        for(int i = 0;i < gameObjects.size();i++){
            T go = gameObjects.get(i);
            if(go.getName().equals(name))
                result.add(go);
        }
        return result;
    }

    @Override
    public Container<T> getAll(Class c) {
        Container<T> result = new ArrayListContainer();
        for(int i = 0;i < gameObjects.size();i++){
            T go = gameObjects.get(i);
            if(c.isInstance(go)) {//Неправильно работает или правио?
                result.add(go);
            }
        }
        return result;
    }
}
