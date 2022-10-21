package me.mrenxo.storygame;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.reflections.Reflections;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import static org.reflections.scanners.Scanners.SubTypes;

public class StoryGame {

    public static HashMap<String, Section> sections = new HashMap<String, Section>();
    public static HashMap<String, String> replacements = new HashMap<>();

    public static HashMap<String, Class<? extends Effect>> Effects = new HashMap<>();

    public static double karmaValue = 0;

    public static void initEffects() {

        Reflections reflections = new Reflections("me.mrenxo.storygame");
        Set<Class<?>> subTypes = reflections.get(SubTypes.of(Effect.class).asClass());
        subTypes.forEach((effect) -> {
            Class<Effect> clazz = (Class<Effect>) effect;
            Effects.put(clazz.getSimpleName(), clazz);
        });
    }

    public static void main(String args[]) {

        File StoryFile = new File(System.getProperty("user.dir") + "/story.json");


        try {
            initEffects();

            Gson gson = new Gson();

            Type MyType = new TypeToken<ArrayList<Section>>(){}.getType();
            ArrayList<Section> sectionList = gson.fromJson(new FileReader(StoryFile), MyType);

            for (Section section : sectionList) {
                section.init();
                sections.put(section.id,section);
            }

            replacements.put("name","null");

            sections.get("start").run();
        } catch (Exception e) {
            if (!StoryFile.exists()) {
                System.err.println("Could Not Find Story Data!");
                System.exit(0);
            }
            e.printStackTrace();

        }


    }



}
