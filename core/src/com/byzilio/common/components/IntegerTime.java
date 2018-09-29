package com.byzilio.common.components;

import com.byzilio.common.components.core.Time;

public class IntegerTime extends Time {

    private int milliseconds;
    private int seconds;
    private int minutes;
    private int hours;
    private int days;

    public IntegerTime(int milliseconds, int seconds, int minutes, int hours, int days) {
        this.milliseconds = milliseconds;
        this.seconds = seconds;
        this.minutes = minutes;
        this.hours = hours;
        this.days = days;
    }

    @Override
    public int getMilliseconds() {
        return milliseconds;
    }

    @Override
    public void setMilliseconds(int milliseconds) {
        this.milliseconds = milliseconds;
    }

    @Override
    public int getSeconds() {
        return seconds;
    }

    @Override
    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public int getMinutes() {
        return minutes;
    }

    @Override
    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    @Override
    public int getHours() {
        return hours;
    }

    @Override
    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public int getDays() {
        return days;
    }

    @Override
    public void setDays(int days) {
        this.days = days;
    }

    @Override
    public String toString() {
        return "IntegerTime{" +
                "milliseconds=" + milliseconds +
                ", seconds=" + seconds +
                ", minutes=" + minutes +
                ", hours=" + hours +
                ", days=" + days +
                '}';
    }

    @Override
    public void dispose() {

    }
}
