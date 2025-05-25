package com.happyfamily.model;

public class RoboCat extends Pet implements Foulable {

    public RoboCat(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        setSpecies(Species.ROBOCAT);
    }

    @Override
    public void respond() {
        System.out.printf("Beep boop! Hello, owner. I am - %s. I miss you!\n", getNickname());
    }

    @Override
    public void foul() {
        System.out.println("ERROR: Malfunction detected. Engaging self-cleaning protocol.");
    }
}