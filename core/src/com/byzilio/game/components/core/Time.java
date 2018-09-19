package com.byzilio.game.components.core;

import com.byzilio.engine.Component;

public abstract class Time extends Component{

    //TODO: Переделать их на float

    private static final int MILLISECOND = 60;
    private static final int SECOND = 60;
    private static final int MINUTE = 60;
    private static final int HOUR = 24;

    public void add(){
        add(1);
    }

    public void add(int millisecond) {
        setMilliseconds(getMilliseconds() + millisecond);
        if (getMilliseconds() >= MILLISECOND) {
            setSeconds(getSeconds() + 1);
            setMilliseconds(0);
        }
        if (getSeconds() >= SECOND) {
            setMinutes(getMinutes() + 1);
            setSeconds(0);
        }
        if (getMinutes() >= MINUTE){
            setHours(getHours() + 1);
            setMinutes(0);
        }
        if(getHours() >= HOUR) {
            setDays(getDays() + 1);
            setHours(0);
        }
    }

    public abstract void setMilliseconds(int milliseconds);

    public abstract void setSeconds(int seconds);

    public abstract void setMinutes(int minutes);

    public abstract void setHours(int hours);

    public abstract void setDays(int days);

    public abstract int getMilliseconds();

    public abstract int getSeconds();

    public abstract int getMinutes();

    public abstract int getHours();

    public abstract int getDays();

}
