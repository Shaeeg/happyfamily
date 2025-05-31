package com.happyfamily.model;

import java.util.Set;

public class RoboCat extends Pet implements Foulable {
    public RoboCat(String nickname) {
        super(nickname);
        setSpecies(Species.ROBOCAT);
    }

    public RoboCat(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
        setSpecies(Species.ROBOCAT);
    }

    public RoboCat() {
        setSpecies(Species.ROBOCAT);
    }

    @Override
    public void respond() {
        System.out.println("Bleep bloop, I am RoboCat " + getNickname() + ". I miss you!");
    }

    @Override
    public void foul() {
        System.out.println("Initiating self-cleaning protocol.");
    }
}