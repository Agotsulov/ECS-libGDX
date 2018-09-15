package com.byzilio.engine.core;

import com.byzilio.engine.GameObject;

public interface GameCollection<T extends GameObject> {

    void add(T t);

    void add(int i,T t);

    int size();

    void clear();

    boolean isEmpty();

    T remove(int i);

    boolean remove(Object o);

}
