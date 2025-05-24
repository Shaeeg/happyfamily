package com.happyfamily.model;

public class Dog extends Pet{

    public Dog( String nickname) {
        super(Species.DOG, nickname);
    }


    @Override
    public void respond() {
        System.out.printf("Hello, owner. I am %s. I miss you!", getSpecies() + "\n");
    }
}
