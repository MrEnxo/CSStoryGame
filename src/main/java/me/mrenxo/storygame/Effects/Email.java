package me.mrenxo.storygame.Effects;

import me.mrenxo.storygame.Effect;
import me.mrenxo.storygame.Section;
import me.mrenxo.storygame.StoryGame;

import java.util.HashMap;
import java.util.Scanner;

public class Email extends Effect {


    public Email(HashMap<String, Object> data) {
        super(data);
    }

    @Override
    public boolean runSkip(Section section) {
        Boolean done = false;
        Boolean openedEmailOne = false;
        Boolean openedEmailTwo = false;
        Boolean openedEmailThree = false;
        while (!done) {
            System.out.println("-- Emails -- \n");
            System.out.println("[1] Email From: Jonny Marsh");
            System.out.println("[2] Email From: %$6!");
            System.out.println("[3] Email From: Spam\n");
            System.out.println("(1-3) Open Email");
            System.out.println("(4) Leave");
            String input = new Scanner(System.in).nextLine();

            if (input.equalsIgnoreCase("1")) {
                System.out.println("Email From: Johnny Marsh");
                System.out.println("Hi, How are you today %name%. I was wondering if you could come over to terminal a-24. \nMy Computer wont turn on, I have pressed the power button multiple times\n");
                System.out.println("Your Coworker,/n Johnny Marsh");
                openedEmailOne = true;
            } else if (input.equalsIgnoreCase("2")) {
                System.out.println("Email From: %$6!");
                try {
                    System.out.print("L");
                    Thread.sleep(400);
                    System.out.print("o");
                    Thread.sleep(400);
                    System.out.print("o");
                    Thread.sleep(400);
                    System.out.print("k");
                    Thread.sleep(400);
                    System.out.print(" ");
                    Thread.sleep(400);
                    System.out.print("o");
                    Thread.sleep(400);
                    System.out.print("u");
                    Thread.sleep(400);
                    System.out.print("t");
                    Thread.sleep(400);
                    System.out.print(".");
                } catch (Exception ee) {
                    ee.printStackTrace();
                }

                openedEmailTwo = true;
            } else if (input.equalsIgnoreCase("3")) {
                System.out.println("Email From: Spam");
                System.out.println("On Read - Are you looking for single moms? Well there are 10 single moms interested in you, within 10 miles.");
                openedEmailThree = true;
            } else if (input.equalsIgnoreCase("4")) {
                if (openedEmailOne && openedEmailTwo && openedEmailThree) {
                    done = true;
                } else {
                    System.out.println("You must read all emails");
                }
            }
        }
        StoryGame.sections.get("johnny").run();

        return true;
    }
}
