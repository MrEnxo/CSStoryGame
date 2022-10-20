package me.mrenxo.storygame.Effects;

import me.mrenxo.storygame.Effect;
import me.mrenxo.storygame.Section;

import java.util.HashMap;

public class TypeWriter extends Effect {

    private double delay = 1;

    public TypeWriter(HashMap<String, Object> data) {
        super(data);
        if (data.get("delay") != null) delay = (double) data.get("delay");
        skip = true;
    }

    @Override
    public String runText(String text, Section section) {
        try {
            for (int i = 0; i < text.length(); i++) {
                System.out.print(text.charAt(i));
                Thread.sleep((long) (delay * 10));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.print('\n');

        return "";
    }
}
