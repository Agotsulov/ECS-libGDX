package com.byzilio.game.components;

import com.byzilio.engine.Component;

public class LogTextComponent extends Component {

    private String text = "TEST";


    public LogTextComponent(String text) {
        this.text = text;
        setName("LogTextComponent");
    }

    public LogTextComponent() {
        setName("LogTextComponent");
    }

    public String getText() {
        return text;
    }

    @Override
    public void dispose() {

    }
}
