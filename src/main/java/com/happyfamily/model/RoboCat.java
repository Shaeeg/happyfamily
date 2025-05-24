package com.happyfamily.model;

public class RoboCat extends Pet{
    public RoboCat(String nickname) {
        super(Species.ROBOCAT, nickname);
    }

    @Override
    public void respond() {
        System.out.printf("Hello, owner. I am %s. I miss you!", getSpecies() + "\n");
    }
}
