package me.mrenxo.storygame.Effects;

import me.mrenxo.storygame.Effect;
import me.mrenxo.storygame.Section;
import me.mrenxo.storygame.StoryGame;

import java.util.HashMap;

public class WaitSkipTo extends Effect {

    private double delay;
    private String section;

    public WaitSkipTo(HashMap<String, Object> data) {
        super(data);
        if (data.containsKey("delay")) delay = (double) data.get("delay");
        if (data.containsKey("section")) section = (String) data.get("section");
    }

    @Override
    public boolean runSkip(Section section) {
        Section runSection = StoryGame.sections.get(this.section);
        try {
            if (runSection != null) {
                Thread.sleep((long) delay * 1000);
                runSection.run();
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }



}
