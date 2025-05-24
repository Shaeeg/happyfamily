package com.happyfamily.model;

public enum Species {
    DOG(false, 4, true),
    CAT(false, 4, true),
    HAMSTER(false, 4, true),
    FISH(false, 0, false),
    SNAKE(false, 0, false),
    PIG(false, 4, true),
    PARROT(true, 2, true),;

    Species(boolean canFly, int numberOfLegs, boolean hasFur) {
    }
}
