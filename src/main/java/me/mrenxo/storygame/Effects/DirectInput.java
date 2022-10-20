package me.mrenxo.storygame.Effects;

import me.mrenxo.storygame.Effect;
import me.mrenxo.storygame.Section;
import me.mrenxo.storygame.StoryGame;

import java.util.HashMap;

public class DirectInput extends Effect {


    public String next;
    public String var;

    public DirectInput(HashMap<String, Object> data) {
        super(data);
        if (data.containsKey("next")) next = (String) data.get("next");
        if (data.containsKey("var")) var = (String) data.get("var");
    }

    @Override
    public String runInput(String input, Section section) {

        StoryGame.replacements.put(var, input);

        if (next != null) return next;
        else return "next";
    }
}
