package com.byzilio.game.core;

import com.byzilio.engine.Component;
import com.byzilio.engine.Engine;
import com.byzilio.engine.Entity;
import com.byzilio.engine.GameObject;
import com.byzilio.engine.core.Container;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEntity extends Entity {

    private List<Component> gameObjects;

    public ArrayListEntity() {
        gameObjects = new ArrayList<Component>();
        //Кстати как лучше писать. Обьявлять переменные в конструкторах или без разницы.
    }

    @Override
    public void create(Engine engine) {
        super.create(engine);
        refreshGameObjects();
    }

    @Override
    public void create(Engine engine, Entity entity) {
        super.create(engine, entity);
        refreshGameObjects();
    }

    private void refreshGameObjects(){
        for(int j = 0;j < gameObjects.size();j++)
            gameObjects.get(j).create(engine, this);
    }


    @Override
    public void add(Component gameObject) {
        gameObjects.add(gameObject);
        gameObject.create(engine,this);
    }

    @Override
    public void add(int i, Component gameObject) {
        gameObjects.add(i, gameObject);
        gameObject.create(engine,this);
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
        Container<Component> result = new ArrayListContainer(); //Много лишнего убрать
        for(int i = 0;i < gameObjects.size();i++){
            Component go = gameObjects.get(i);
            if(go.getName().equals(name))
                result.add(go);
        }
        return result;
    }

    @Override
    public Container<Component> getAll(Class c) {
        Container<Component> result = new ArrayListContainer();
        for(int i = 0;i < gameObjects.size();i++){
            Component go = gameObjects.get(i);
            if(c.isInstance(go)) {//Неправильно работает или правио?
                log(GameObject.class.isInstance(go) + "");
                result.add(go);
            }
        }
        return result;
    }

}
