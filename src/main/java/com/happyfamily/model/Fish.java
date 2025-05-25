package com.happyfamily.model;

public class Fish extends Pet {

    public Fish(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        setSpecies(Species.FISH);
    }

    @Override
    public void respond() {
        System.out.printf("Blub blub! Hello, owner. I am - %s. I miss you!\n", getNickname());
    }
}