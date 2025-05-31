package com.happyfamily.model;

import java.util.Set;

public class Dog extends Pet implements Foulable {
    public Dog(String nickname) {
        super(nickname);
        setSpecies(Species.DOG);
    }

    public Dog(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
        setSpecies(Species.DOG);
    }

    public Dog() {
        setSpecies(Species.DOG);
    }

    @Override
    public void respond() {
        System.out.println("Woof woof, I am a dog " + getNickname() + ". I miss you!");
    }

    @Override
    public void foul() {
        System.out.println("I need to cover it up... from a dog's perspective.");
    }
}