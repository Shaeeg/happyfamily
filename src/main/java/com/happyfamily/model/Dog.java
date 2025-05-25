package com.happyfamily.model;

public class Dog extends Pet implements Foulable {

    public Dog(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        setSpecies(Species.DOG);
    }

    @Override
    public void respond() {
        System.out.printf("Woof woof! Hello, owner. I am - %s. I miss you!\n", getNickname());
    }

    @Override
    public void foul() {
        System.out.println("I need to cover it up (Dog foul)");
    }
}