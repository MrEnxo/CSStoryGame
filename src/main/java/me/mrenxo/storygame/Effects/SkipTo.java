package me.mrenxo.storygame.Effects;

import me.mrenxo.storygame.Effect;
import me.mrenxo.storygame.Section;
import me.mrenxo.storygame.StoryGame;

import java.util.HashMap;

public class SkipTo extends Effect {

    public String section;

    public SkipTo(HashMap<String, Object> data) {
        super(data);
        if (data.containsKey("section")) section = (String) data.get("section");
    }


    @Override
    public boolean runSkip(Section section) {
        StoryGame.sections.get(section).run();
        return true;
    }

}
