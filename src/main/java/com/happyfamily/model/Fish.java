package com.happyfamily.model;

import java.util.Set;

public class Fish extends Pet {
    public Fish(String nickname) {
        super(nickname);
        setSpecies(Species.FISH);
    }

    public Fish(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
        setSpecies(Species.FISH);
    }

    public Fish() {
        setSpecies(Species.FISH);
    }

    @Override
    public void respond() {
        System.out.println("Blub blub, I am a fish " + getNickname() + ". I miss you!");
    }
}