package com.byzilio.game.components;

import com.byzilio.engine.Component;

public class LogTextComponent extends Component {

    private String text = "TEST";

    public LogTextComponent() {
        setName("TestComponent");
    }

    public String getText() {
        return text;
    }

    @Override
    public void dispose() {

    }
}
