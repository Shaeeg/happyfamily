package com.happyfamily.model;

public class DomesticCat extends Pet{
    public DomesticCat(String nickname) {
        super(Species.CAT, nickname);
    }

    @Override
    public void respond() {
        System.out.printf("Hello, owner. I am %s. I miss you!", getSpecies() + "\n");
    }
}
