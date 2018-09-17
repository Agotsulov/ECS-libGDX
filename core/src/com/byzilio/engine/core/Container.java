package com.byzilio.engine.core;

import com.byzilio.engine.GameObject;

public interface Container<T extends GameObject> extends GameCollection<T> {
    T get(int i);

    /*
        Каждый раз их лениво переопределять
     */

    T get(String name);

    T get(Class c);

    Container<T> getAll(String name);

    Container<T> getAll(Class c);

}
