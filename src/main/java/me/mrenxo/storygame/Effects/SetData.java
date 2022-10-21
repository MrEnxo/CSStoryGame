package me.mrenxo.storygame.Effects;

import me.mrenxo.storygame.Effect;
import me.mrenxo.storygame.Section;
import me.mrenxo.storygame.StoryGame;

import java.util.HashMap;

public class SetData extends Effect {

    public HashMap<String, Object> data;

    public SetData(HashMap<String, Object> data) {
        super(data);
        this.data = data;
    }

    @Override
    public String runText(String text, Section section) {
        for (String val : data.keySet()) {
            StoryGame.replacements.put(val, data.get(val).toString());
        }

        return text;
    }
}
