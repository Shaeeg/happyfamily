package com.happyfamily.model;

public enum Species {
    DOG(false, 4, true),
    CAT(false, 4, true),
    FISH(false, 0, false),
    PARROT(true, 2, true),
    ROBOCAT(true, 4, false),
    ;

    Species(boolean canFly, int numberOfLegs, boolean hasFur) {
    }
}
