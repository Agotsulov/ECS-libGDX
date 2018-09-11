package com.byzilio.engine;

public interface Debugable {

    boolean isDebug();

    void setDebug(boolean debug);

    void log(String massage);
}
