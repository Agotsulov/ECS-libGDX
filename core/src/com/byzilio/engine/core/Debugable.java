package com.byzilio.engine.core;

public interface Debugable {

    boolean isDebug();

    void setDebug(boolean debug);

    void log(String massage);
}
