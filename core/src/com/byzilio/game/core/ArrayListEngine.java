package com.byzilio.game.core;

import com.byzilio.engine.Engine;
import com.byzilio.engine.Scene;
import com.byzilio.engine.System;
import com.byzilio.engine.core.Container;
import com.byzilio.engine.core.Input;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEngine extends Engine{

    /*
        TODO: Дописать get'ы. Хоть они и бесполезны
     */

    private List<System> systems = new ArrayList<System>();
    private Scene scene;

    public ArrayListEngine(Input input) {
        super(input);
    }


    @Override
    public void changeScene(Scene scene) {
        this.scene = scene;
        this.scene.create(this);
        for(int i = 0;i < size();i++){
            get(i).start();
        }
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        //Gdx.app.log("Engine","update");

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

    @Override
    public Scene getScene() {
        return scene;
    }

    @Override
    public System get(String name) {
        return null;
    }

    @Override
    public System get(Class c) {
        return null;
    }

    @Override
    public Container<System> getAll(String name) {
        return null;
    }

    @Override
    public Container<System> getAll(Class c) {
        return null;
    }
}
