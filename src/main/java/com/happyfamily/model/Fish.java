package com.happyfamily.model;

public class Fish extends Pet{

    public Fish(String nickname) {
        super(Species.FISH, nickname);
    }


    @Override
    public void respond() {
        System.out.printf("Hello, owner. I am %s. I miss you!", getSpecies() + "\n");
    }
}
