package com.happyfamily.model;

import java.util.Set;

public class DomesticCat extends Pet implements Foulable {
    public DomesticCat(String nickname) {
        super(nickname);
        setSpecies(Species.CAT);
    }

    public DomesticCat(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
        setSpecies(Species.CAT);
    }

    public DomesticCat() {
        setSpecies(Species.CAT);
    }

    @Override
    public void respond() {
        System.out.println("Meow, I am a domestic cat " + getNickname() + ". I miss you!");
    }

    @Override
    public void foul() {
        System.out.println("I need to cover it up... from a cat's perspective.");
    }
}