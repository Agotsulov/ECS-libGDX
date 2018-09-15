package com.byzilio.engine.core;

import com.byzilio.engine.GameObject;

public interface Container<T extends GameObject> extends GameCollection<T> {
    T get(int i);

    /*
        Каждый раз их лениво переопределять
     */

    GameObject get(String name);

    GameObject get(Class c);

    Container<GameObject> getAll(String name);

    Container<GameObject> getAll(Class c);

}
