package com.byzilio.game.enitites;

import com.byzilio.engine.core.Container;
import com.byzilio.engine.Entity;
import com.byzilio.engine.GameObject;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEntity extends Entity {

    private List<GameObject> gameObjects = new ArrayList<GameObject>();

    @Override
    public void add(GameObject gameObject) {
        gameObjects.add(gameObject);
        gameObject.create(engine,this);
    }

    @Override
    public void add(int i, GameObject gameObject) {
        gameObjects.add(i, gameObject);
        gameObject.create(engine,this);
    }

    @Override
    public GameObject get(int i) {
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
    public GameObject remove(int i) {
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
    public GameObject get(String name) {
        for(int i = 0;i < gameObjects.size();i++){
            GameObject go = gameObjects.get(i);
            if(go.getName().equals(name))
                return go;
        }
        return null;
    }

    @Override
    public GameObject get(Class c) {
        for(int i = 0;i < gameObjects.size();i++){
            GameObject go = gameObjects.get(i);
            if(GameObject.class.isInstance(go))
                return go;
        }
        return null;
    }

    @Override
    public Container<GameObject> getAll(String name) {
        Container<GameObject> result = new ArrayListEntity(); //Много лишнего убрать
        for(int i = 0;i < gameObjects.size();i++){
            GameObject go = gameObjects.get(i);
            if(go.getName().equals(name))
                result.add(go);
        }
        return result;
    }

    @Override
    public Container<GameObject> getAll(Class c) {
        Container<GameObject> result = new ArrayListEntity();
        for(int i = 0;i < gameObjects.size();i++){
            GameObject go = gameObjects.get(i);
            if(GameObject.class.isInstance(go))
                result.add(go);
        }
        return result;
    }

}
