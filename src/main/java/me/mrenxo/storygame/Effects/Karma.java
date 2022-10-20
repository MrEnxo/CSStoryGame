package me.mrenxo.storygame.Effects;

import me.mrenxo.storygame.Effect;
import me.mrenxo.storygame.Section;
import me.mrenxo.storygame.StoryGame;

import java.util.HashMap;

public class Karma extends Effect {


    private double add;

    public Karma(HashMap<String, Object> data) {
        super(data);
        if (data.containsKey("amount")) add = (double) data.get("amount");

    }

    @Override
    public String runText(String text, Section section) {
        StoryGame.karmaValue += add;
        StoryGame.replacements.put("karma", String.valueOf(StoryGame.karmaValue));
        return text;
    }
}
