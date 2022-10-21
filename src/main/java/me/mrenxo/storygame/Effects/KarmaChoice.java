package me.mrenxo.storygame.Effects;

import com.google.gson.internal.LinkedTreeMap;
import me.mrenxo.storygame.Effect;
import me.mrenxo.storygame.Section;
import me.mrenxo.storygame.StoryGame;

import java.util.HashMap;

public class KarmaChoice extends Effect {

    private HashMap<String, Object> choices;

    public KarmaChoice(HashMap<String, Object> data) {
        super(data);
        choices = data;
    }

    @Override
    public boolean runSkip(Section section) {
        for (String choice : choices.keySet()) {
            char operator = choice.charAt(0);
            String reducedChoice = choice.substring(1);
            double num = Double.parseDouble(reducedChoice);
            if (operator == '>') {
                if (StoryGame.karmaValue > num) {
                    StoryGame.sections.get(choices.get(choice)).run();
                    return true;
                }
            } else if (operator == '<') {
                if (StoryGame.karmaValue < num) {
                    StoryGame.sections.get(choices.get(choice)).run();
                    return true;
                }
            } else if (operator == '=') {
                if (StoryGame.karmaValue == num) {
                    StoryGame.sections.get(choices.get(choice)).run();
                    return true;
                }
            }
        }
        return false;
    }
}
