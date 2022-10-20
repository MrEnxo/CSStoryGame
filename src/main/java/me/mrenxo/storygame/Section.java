package me.mrenxo.storygame;


import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static me.mrenxo.storygame.StoryGame.replacements;
import static me.mrenxo.storygame.StoryGame.sections;

public class Section {



    public String id;
    String text;
    HashMap<String, String> options;
    HashMap<String, HashMap<String, Object>> effects;

    transient ArrayList<Effect> effectList = new ArrayList<>();


    public Section(String id, String text, HashMap<String, String> options, HashMap<String, HashMap<String, Object>> effects) {
        this.id = id;
        this.text = text;
        this.options = options;
        this.effects = effects;

    }


    public void init() {
        if (this.effects != null) {
            for (String effect : this.effects.keySet()) {
                try {
                    Constructor<?>[] constructor = StoryGame.Effects.get(effect).getDeclaredConstructors();
                    HashMap<String ,Object> data = this.effects.get(effect);
                    effectList.add((Effect) constructor[0].newInstance(data));
                } catch (Exception e){
                    System.err.println("Invalid Effect Constructor \"" + effect + "\"" + " on section \"" + this.id + "\"");
                    System.exit(0);
                }

            }
        }
    }



    public Section() {
        this(null, null, null, null);
    }

    private String getFormattedString(String str) {
        String[] strlist = str.split("%");
        for (int i = 0; i < strlist.length; i++) {
            if (i % 2 == 1) {
                strlist[i] = replacements.get(strlist[i]);
            }
        }

        return String.join("", strlist);
    }

    private String runTextEffects(String text) {
        String str = text;
        for ( Effect effect : effectList) {
            str = effect.runText(str,this);
        }
        return str;
    }
    private String runInputEffects(String input) {
        String str = input;
        for ( Effect effect : effectList) {
            str = effect.runInput(str,this);
        }
        return str;
    }
    private boolean runSkipEffects() {
        for ( Effect effect : effectList) {
            if (effect.runSkip( this)) return true;
        }
        return false;
    }

    public void run() {

        String text = runTextEffects(this.text);
        if (text.length() > 0) System.out.println(getFormattedString(text));
        if (runSkipEffects()) {
            return;
        }
        String input = new Scanner(System.in).nextLine();

        input = runInputEffects(input);

        if (options == null) return;
        if (options.size() <= 0) return;

        if (options.get("any") != null ) {
            sections.get(options.get("any")).run();
        }

        for ( String key : options.keySet()) {
            if (input.equalsIgnoreCase(key)) {
                sections.get(options.get(key)).run();
                return;
            }
        }

        if (options.get("else") != null) {
            sections.get(options.get("else")).run();
            return;
        }
        this.run();
    }
}
