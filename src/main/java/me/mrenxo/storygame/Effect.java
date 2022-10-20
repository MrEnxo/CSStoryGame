package me.mrenxo.storygame;

import java.util.HashMap;

public class Effect {

    public boolean skip = false;

    public Effect(HashMap<String, Object> data) {
    }

    public String runText(String text, Section section) {

        return text;
    }

    public boolean runSkip(Section section) {

        return false;
    }
    public String runInput(String input, Section section) {
        return input;
    }
}
