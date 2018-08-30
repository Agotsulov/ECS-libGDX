package com.byzilio.game.engines;

import com.byzilio.engine.Engine;

import java.util.ArrayList;
import java.util.List;

import com.byzilio.engine.Entity;
import com.byzilio.engine.GameObject;
import com.byzilio.engine.System;
import com.byzilio.game.components.LogTextComponent;
import com.byzilio.game.enitites.ArrayListEntity;
import com.byzilio.game.systems.LogTextSystem;

public class ArrayListEngine extends Engine{

    private List<System> systems = new ArrayList<System>();
    private List<GameObject> gameObjects = new ArrayList<GameObject>();

    public ArrayListEngine() {
        add(new LogTextSystem());

        Entity e = new ArrayListEntity();
        e.add(new LogTextComponent());
        e.add(new LogTextComponent());
        e.add(new LogTextComponent());
        e.add(new LogTextComponent());
        e.add(new LogTextComponent());
        gameObjects.add(e);

        //Спрятать это в класс Scene?
        for(int i = 0;i < systems.size();i++){
            for(int j = 0;j < gameObjects.size();j++){
                systems.get(i).add(gameObjects.get(j));
            }
        }

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        for (int i = 0;i < systems.size();i++){
            systems.get(i).preUpdate();
        }

        for (int i = 0;i < systems.size();i++){
            systems.get(i).update();
        }

        for (int i = 0;i < systems.size();i++){
            systems.get(i).postUpdate();
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        for (int i = 0;i < systems.size();i++)
            systems.get(i).dispose();
    }

    @Override
    public void add(System system) {
        systems.add(system);
        system.create(this);
    }

    @Override
    public void add(int i, System system) {
        systems.add(i,system);
        system.create(this);
    }

    @Override
    public System get(int i) {
        return systems.get(i);
    }

    @Override
    public int size() {
        return systems.size();
    }

    @Override
    public void clear() {
        systems.clear();
        for (int i = 0;i < systems.size();i++)
            systems.get(i).dispose();
    }

    @Override
    public boolean isEmpty() {
        return systems.isEmpty();
    }

    @Override
    public System remove(int i) {
        return systems.remove(i);
    }

    @Override
    public boolean remove(Object o) {
        return systems.remove(o);
    }
}
