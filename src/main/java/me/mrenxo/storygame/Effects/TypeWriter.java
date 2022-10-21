package me.mrenxo.storygame.Effects;

import me.mrenxo.storygame.Effect;
import me.mrenxo.storygame.Section;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TypeWriter extends Effect {

    private double delay = 1;

    public TypeWriter(HashMap<String, Object> data) {
        super(data);
        if (data.get("delay") != null) delay = (double) data.get("delay");
        skip = true;
    }

    @Override
    public String runText(String text, Section section) {
        String[] strs = text.split("\n");
        String str = strs[0];
        strs = Arrays.copyOfRange(strs, 1, strs.length);
        try {
            for (int i = 0; i < str.length(); i++) {
                System.out.print(str.charAt(i));
                Thread.sleep((long) (delay * 10));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.print('\n');

        return String.join("\n", strs);
    }
}
