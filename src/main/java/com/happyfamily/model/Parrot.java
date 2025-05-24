package com.happyfamily.model;

public class Parrot extends Pet{
    public Parrot(String nickname) {
        super(Species.PARROT, nickname);
    }

    @Override
    public void respond() {
        System.out.printf("Hello, owner. I am %s. I miss you!", getSpecies() + "\n");
    }
}
